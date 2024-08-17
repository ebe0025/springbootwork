package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> alist = memberService.selectAll();
		model.addAttribute("mlist", alist);
		model.addAttribute("title", "All");
		return "selectAll";
	}

	@RequestMapping("/selectById")
	public String selectById(Long id, Model model) {
		Optional<Member> member = memberService.select(id);
	
		if(member.isPresent())
		{
			model.addAttribute("member", member.get());
		}else {
			model.addAttribute("member", null);
		}
		model.addAttribute("title", id);
		
		return "select_one";
	}
	
	@RequestMapping("/selectByName")
	public String selectByName(String name, Model model) {
		Optional<Member> member = memberService.selectByName(name);
		if(member.isPresent())
		{
			model.addAttribute("member", member.get());
		}else {
			model.addAttribute("member", null);
		}
		model.addAttribute("title", name);
		
		return "select_one";
	}
	
	@RequestMapping("/selectByEmail")
	public String selectByEmail(String email, Model model) {
		Optional<Member> member = memberService.selectByEmail(email);
		if(member.isPresent())
		{
			model.addAttribute("member", member.get());
		}else {
			model.addAttribute("member", null);
		}
		model.addAttribute("title", email);
		
		return "select_one";
	}
	
	@RequestMapping("/selectByNameLike")
	public String selectByNameLike(String name, Model model) {
		String username ="%" + name + "%";
		List<Member> alist = memberService.selectByLikeName(username);

		model.addAttribute("mlist", alist);
		model.addAttribute("title", "LikeAll");
		
		return "selectAll";
	}
	
	@RequestMapping("/selectByNameLikeDesc")
	public String selectByNameLikeDesc(String name, Model model) {
		String username ="%" + name + "%";
		List<Member> alist = memberService.selectByNameLikeDesc(username);

		model.addAttribute("mlist", alist);
		model.addAttribute("title", "NameLikeDesc");
		
		return "selectAll";
	}
	
	@RequestMapping("/selectByNameLikeSort")
	public String selectByNameLikeSort(String name, Model model) {
		String username ="%" + name + "%";
		Sort sort = Sort.by(Sort.Order.desc("username"), Sort.Order.asc("email"));
		
		List<Member> alist = memberService.selectByNameLikeSort(username, sort);

		model.addAttribute("mlist", alist);
		model.addAttribute("title", "NameLikeDesc");
		
		return "selectAll";
	}
	
}
