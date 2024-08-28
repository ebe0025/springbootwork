package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.domain.Member;
import com.study.service.MemberService;

@RestController
@RequestMapping("/axios")
public class TestController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/saveReg")
	public String saveReg(Member m) {
		memberService.save(m);
		
		return "";
	}
	
}
