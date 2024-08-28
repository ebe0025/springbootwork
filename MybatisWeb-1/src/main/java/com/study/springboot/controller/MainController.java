package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("안녕");
		return "hello";
	}
}
