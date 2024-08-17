package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		return "menu";
	}
	
	@RequestMapping("/selectByNameLike1")
	public String selectByNameLike1(String name, Model model ) {
		String search = name + "%";
		
		List<Member> result = memberService.selectByNameLike1(search);
		model.addAttribute("member", result);
		return "selectList1";
	}
	
	@RequestMapping("/selectByNameLike2")
	public String selectByNameLike2(String name, Model model ) {
		String search = name + "%";
		Sort sort = Sort.by(Sort.Order.asc("id"));
		List<Member> result = memberService.selectMembers2(search, sort);
		model.addAttribute("member", result);
		return "selectList1";
	}
	
	@RequestMapping("/selectByNameLike3")
	public String selectByNameLike3(String name, int page, Model model ) {
		String search = name + "%";
		Sort sort = Sort.by(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page-1 , 10, sort);
		Page<Member> result = memberService.selectMembers3(search, pageable);
		List<Member> content = result.getContent();
		
		model.addAttribute("member", content);
		model.addAttribute("totalRecord", result.getTotalElements());
		model.addAttribute("nowPage", result.getNumber() + 1 );
		
		return "selectList2";
	}
	
	@RequestMapping("/selectByNameLike4")
	public String selectByNameLike4(String name, Model model ) {
		String search = name + "%";
	
		List<Member> result = memberService.selectMembers4(search);
		model.addAttribute("member", result);
		return "selectList1";
	}

	
}
