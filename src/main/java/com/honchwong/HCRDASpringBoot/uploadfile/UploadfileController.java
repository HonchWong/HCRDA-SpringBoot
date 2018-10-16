package com.honchwong.HCRDASpringBoot.uploadfile;

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

import com.honchwong.HCRDASpringBoot.domain.JsonData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.apache.commons.io.IOUtils;

@RestController
public class UploadfileController {
	private Map<String,Object> params = new HashMap<>();

	@Value("classpath:uploadFile/needUpLoadList.json")
	private Resource needUpLoadListJson;


//	@Value("classpath:userLog/")
//	private Resource userLogFilePath;

//	@Value("${web.file.path}")
//	private String userLogFilePath;

	@GetMapping(value="/api/needUploadList")
	public Object needUploadList(){
		params.clear();

		String jsonStr = "error";
		try {
			jsonStr = IOUtils.toString(needUpLoadListJson.getInputStream(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ObjectMapper objectMapper = new ObjectMapper();
		params.put("status", "error");
		Map map = params;
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
		System.out.println("/api/getFileList " + name);

		params.clear();
		File dir = new File(getJarRootPath(), "/userLog/");
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
		File fileDownload = new File(getJarRootPath(), "/userLog/" + fileName);
		System.out.println("fileDownload: "+fileDownload.getAbsolutePath());
		if (fileDownload.exists()) {

			String mimeType = URLConnection.guessContentTypeFromName(fileDownload.getName());
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			System.out.println("mimeType:"+mimeType);

			response.setContentType(mimeType);
			System.out.println("fileDownload.getName():"+fileDownload.getName());
			response.setHeader("Content-Disposition", "attachment; fileName="+  fileDownload.getName() +";filename*=utf-8''"+URLEncoder.encode(fileDownload.getName(), "UTF-8"));
			response.setContentLength((int) fileDownload.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(fileDownload));

			FileCopyUtils.copy(inputStream, response.getOutputStream());
		}
	}

	@PostMapping(value="/api/updateNeedUploadList")
	public Object updateNeedUploadList(@RequestBody Map<String,Object> reqMap){
		System.out.println("/api/updateNeedUploadList");
		params.clear();
		params.put("status", "ok");

		String jsonStr = "error";
		try {
			jsonStr = new ObjectMapper().writeValueAsString(reqMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonStr);

		File jsonFile = null;
		try {
			jsonFile = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "uploadFile/needUpLoadList.json");
		} catch (FileNotFoundException e) {
			params.put("status", "error");
			e.printStackTrace();
		}
		System.out.println(jsonFile);

		if (!jsonStr.equals("error") && jsonFile != null) {
			FileWriter fw=null;
			try {
				fw = new FileWriter(jsonFile);
				IOUtils.write(jsonStr, fw);
			} catch (IOException e) {
				e.printStackTrace();
				params.put("status", "error");
			} finally {
				IOUtils.closeQuietly(fw);
			}
		}

		return params;
	}

	@PostMapping("/api/upload")
	public Object singleFileUpload(@RequestParam("user_log") MultipartFile file, HttpServletRequest request) throws FileNotFoundException {
		String fileName = file.getOriginalFilename();
		String name = fileName.substring(0, fileName.lastIndexOf("."));
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		String formatDate = UploadfileController.timeStampToFormatDate(System.currentTimeMillis(), "yyyy-MM-dd_HH:mm:ss");
		fileName = name + "_" + formatDate + suffixName;

		System.out.println("转换后的名称:"+fileName);

		File savePath = new File(getJarRootPath(), "/userLog/" + fileName);

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

	private String getJarRootPath() throws FileNotFoundException {
		String path = ResourceUtils.getURL("classpath:").getPath();
		//=> file:/root/tmp/demo-springboot-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/
//		log.debug("ResourceUtils.getURL(\"classpath:\").getPath() -> "+path);
		//创建File时会自动处理前缀和jar包路径问题  => /root/tmp
		File rootFile = new File(path);
		if(!rootFile.exists()) {
//			log.info("根目录不存在, 重新创建");
			rootFile = new File("");
//			log.info("重新创建的根目录: "+rootFile.getAbsolutePath());
		}
//		log.debug("项目根目录: "+rootFile.getAbsolutePath());        //获取的字符串末尾没有分隔符 /
		return rootFile.getAbsolutePath();
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