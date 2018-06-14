package com.cm.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.pojo.JSONResult;
import com.cm.pojo.User;

@RestController
public class UserController {

	@RequestMapping("/getUser")
	public JSONResult hello() {
		
		
		User u = new User();
		u.setName("imooc2");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("imooc2");
		//u.setDesc("hello imooc2~~");
		
		return JSONResult.ok(u);	
		
	}
}
