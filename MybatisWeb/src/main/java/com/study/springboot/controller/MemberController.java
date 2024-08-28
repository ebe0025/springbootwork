package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	@RequestMapping("/register")
	public String register(Model model) {
		
		return "member/register";
	}
	@PostMapping("/checkId")
	@ResponseBody
	public boolean checkId(Model model) {
		boolean flag = false;
		
		
		return flag;
	}
	
}
