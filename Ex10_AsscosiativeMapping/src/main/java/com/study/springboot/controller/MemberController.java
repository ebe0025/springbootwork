package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;


@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("minsert")
	public String memberInsert(Member member, Model model) {
		Member m = memberService.minsert(member);
		model.addAttribute("member", m);
			
		return "minsert";
	}
	
	@RequestMapping("mupdate")
	public String memberUpdate(Member member, Model model) {
		
		Member m = memberService.mupdate(member);
		model.addAttribute("member", m);
		return "minsert";
	}
	
}
