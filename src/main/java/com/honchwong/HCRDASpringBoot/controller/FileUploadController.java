package com.honchwong.HCRDASpringBoot.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import com.honchwong.HCRDASpringBoot.Unit.ReadAndWriteJson;
import com.honchwong.HCRDASpringBoot.domain.JsonData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

@RestController
@PropertySource({"classpath:application.properties"})
public class FileUploadController {

	private Map<String,Object> params = new HashMap<>();

	@Value("${userlog.dir.path}")
	private String logDirPath;

	@GetMapping(value="/api/needUpload")
	public Object needUpload(@RequestParam String uin) throws IOException {
		params.clear();
		params.put("needUpload", 0);

		String jsonFilePath  = getNeedUploadListJson();
		String jsonStr = ReadAndWriteJson.ReadFile(jsonFilePath);
		ObjectMapper objectMapper = new ObjectMapper();
		Map map = objectMapper.readValue(jsonStr, Map.class);
		List<Map> list = (List<Map>) map.get("needUploadList");
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				Map needUploadMap = list.get(i);
				if (uin.equals(needUploadMap.get("uin"))) {
					if (needUploadMap.get("uploadType") != null) {
						params.put("needUpload", needUploadMap.get("uploadType"));
					} else {
						params.put("needUpload", 0);
					}
				}
			}
		}

		return params;
	}

	@GetMapping(value="/api/needUploadList")
	public Object needUploadList(){
		params.clear();
		params.put("status", "error");

		String jsonFilePath = null;
		try {
			jsonFilePath = getNeedUploadListJson();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String jsonStr = ReadAndWriteJson.ReadFile(jsonFilePath);
		ObjectMapper objectMapper = new ObjectMapper();
		Map map = null;
		try {
			map = objectMapper.readValue(jsonStr, Map.class);
			map.put("status", "ok");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

	@GetMapping(value="/api/getFileList")
	public Object getFileList(@RequestParam String name) throws IOException {
		params.clear();
		File dir = new File(logDirPath);

		String[] children = dir.list();
		List<Map> fileParams = new ArrayList<>();
		for(int i = 0; i < children.length; i++) {
			Map<String,Object> fileParam = new HashMap<>();
			if (!name.equals("allFile")) {
				if (children[i].indexOf(name) != -1) {
					fileParam.put("key", System.currentTimeMillis() + i);
					fileParam.put("name", children[i]);
					fileParams.add(fileParam);
				}
			} else {
				fileParam.put("key", System.currentTimeMillis() + i);
				fileParam.put("name", children[i]);
				fileParams.add(fileParam);
			}
		}
		if (!fileParams.isEmpty()) {
			params.put("list", fileParams);
		}

		return params;
	}

	@GetMapping(value="/api/download/{fileName}")
	public void download(HttpServletRequest request, HttpServletResponse response,
						 @PathVariable("fileName") String fileName) throws IOException {
		File fileDownload = new File(logDirPath, fileName);
//		System.out.println("fileDownload: "+fileDownload.getAbsolutePath());
		if (fileDownload.exists()) {

			String mimeType = URLConnection.guessContentTypeFromName(fileDownload.getName());
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
//			System.out.println("mimeType:"+ mimeType);

			response.setContentType(mimeType);
//			System.out.println("fileDownload.getName():"+fileDownload.getName());
			response.setHeader("Content-Disposition", "attachment; fileName="+  fileDownload.getName() +";filename*=utf-8''"+URLEncoder.encode(fileDownload.getName(), "UTF-8"));
			response.setContentLength((int) fileDownload.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(fileDownload));

			FileCopyUtils.copy(inputStream, response.getOutputStream());
		}
	}

	@PostMapping(value="/api/updateNeedUploadList")
	public Object updateNeedUploadList(@RequestBody Map<String,Object> reqMap) throws IOException {
//		System.out.println("/api/updateNeedUploadList");
		params.clear();

		String jsonFilePath = getNeedUploadListJson();
		String jsonStr = "error";
		try {
			jsonStr = new ObjectMapper().writeValueAsString(reqMap);
			ReadAndWriteJson.writeFile(jsonFilePath, jsonStr);
			params.put("status", "ok");
		} catch (JsonProcessingException e) {
			params.put("status", "error");
			params.put("msg", e.toString());
			e.printStackTrace();
		}
//		System.out.println(jsonStr);

		return params;
	}

	@PostMapping("/api/upload")
	public Object singleFileUpload(@RequestParam("user_log") MultipartFile file, HttpServletRequest request) throws FileNotFoundException {
		String fileName = file.getOriginalFilename();
		String name = fileName.substring(0, fileName.lastIndexOf("."));
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		String formatDate = FileUploadController.timeStampToFormatDate(System.currentTimeMillis(), "yyyy-MM-dd_HH:mm:ss");
		fileName = name + "_uploadTime_" + formatDate + suffixName;

//		System.out.println("转换后的名称:"+fileName);
		File savePath = new File(logDirPath, fileName);

		try {
			byte[] bytes = file.getBytes();

			Path path = Paths.get(savePath.getAbsolutePath());
			Files.write(path, bytes);
			return new JsonData(0, "ok", null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return  new JsonData(-1, "fail to save ", null);
	}

	private String getNeedUploadListJson() throws FileNotFoundException {
		String path = ResourceUtils.getURL("classpath:").getPath() + "needUploadList/needUploadList.json";
		return  path;
	}

	/**
	 * 时间戳转换为格式化日期
	 *
	 * @param dateObj 时间对象
	 *                System.currentTimeMillis()
	 *                new Date()
	 *                new Date().getTime()
	 *                Calendar.getInstance().getTimeInMillis()
	 * @param pattern 日期格式
	 *                yyyy-MM-dd HH:mm:ss
	 *                yyyy/MM/dd HH:mm:ss
	 *                yyyy年MM月dd日 HH:mm:ss
	 * @return sdf.format(Object dateObj)
	 */
	public static String timeStampToFormatDate(Object dateObj, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String formatDate = sdf.format(dateObj);
		return formatDate;
	}
}