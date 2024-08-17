package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/binsert")
	public String boardInsert(Board board, Model model) {
		Member m = new Member();
		m.setId("vince");
		board.setMember(m);
		Board b = boardService.boardInsert(board);
		model.addAttribute("board", b);
		
		
		return "binsert";
	}
}
