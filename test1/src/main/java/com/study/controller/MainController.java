package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String root() {
		
		return "index";
	}
	
	@GetMapping("/main")
	public String main() {
		return "redirect:/react-app";
	}
}
