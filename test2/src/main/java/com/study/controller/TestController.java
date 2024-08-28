package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.domain.Member;
import com.study.service.MemberService;

@RestController
public class TestController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("/saveReg")
	public Member saveReg(@RequestBody Member m) {
		System.out.println("작동됨");
		
		return memberService.save(m);
	}
	
}
