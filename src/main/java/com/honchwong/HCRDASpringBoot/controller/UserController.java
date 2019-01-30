package com.honchwong.HCRDASpringBoot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import com.honchwong.domain.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class UserController {
	private Map<String,Object> params = new HashMap<>();
	
	@GetMapping(value="/api/currentUser")
	public Object currentUser(){
		params.clear();
		params.put("name", "Assistant");
		params.put("avatar", "http://m.qpic.cn/psb?/V10JaO4w40EHz4/XpA66Nfht256ej20pDQGRadjMOJP9yKqUpbr4lvhUsQ!/b/dFMBAAAAAAAA&bo=LAELAQAAAAADFxU!&rf=viewer_4&t=5");
		return params;
	}

	@GetMapping(value="/api/users")
	public Object users(){
		params.clear();
		return params;
	}

	@PostMapping(value="/api/login/account")
	public Object login(@RequestBody Map<String,Object> reqMap){
		String userName = reqMap.get("userName").toString();
	    String password = reqMap.get("password").toString();
		params.clear();
		if (userName.equals("admin") && password.equals("123")) {
			params.put("status", "ok");
			params.put("currentAuthority", "admin");			
		} else if (userName.equals("guest") && password.equals("123")) {
			params.put("status", "ok");
			params.put("currentAuthority", "user");		
		} else {
			params.put("status", "error");
			params.put("currentAuthority", "guest");	
		}

		return params;
	}

	@PostMapping(value="/api/register")
	public Object register(){
		params.clear();
		params.put("status", "ok");
		params.put("currentAuthority", "user");
		return params;
	}
}
