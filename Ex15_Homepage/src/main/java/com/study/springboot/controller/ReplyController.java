package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Reply;
import com.study.springboot.service.ReplyService;

@Controller
@SessionAttributes({"loginUser"})
public class ReplyController {
	@Autowired
	ReplyService replyService;
	

	
	@PostMapping("/insertReply")
	@ResponseBody
	public Reply insertReply(Reply reply, Model model) {
		return replyService.insertReply(reply);
		
		
	}
	
	@GetMapping("/boardDetail")
	public void 
}
