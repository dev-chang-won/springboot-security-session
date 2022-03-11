package com.ch1.springbootsecuritysession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

	@GetMapping("/index")
	public String index() {
		
		/*
		 * 뷰 설정 prefix:/WEB-INF/views/ , suffix:.html 
		 * */
		
		return "index";
	}
	
}