package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes({"loginUser"})
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/boardList")
	public String list(@RequestParam(value="nowPage", defaultValue="0") int nowPage, Model model) {
		Page<Board> pageList = boardService.list(PageRequest.of(nowPage, 2, Sort.by(Sort.Direction.DESC, "bno")));
		
		int pagePerBlock = 5;	// [1][2][3][4][5]
		int endPage = Math.min(pageList.getTotalPages(), nowPage + pagePerBlock);

		model.addAttribute("boardPage", pageList);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("endPage", endPage);
		return "board/list";
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		return "board/write";
	}
	
	/*	@PostMapping("/insertBoard")
		public String insertBoard(Board board, HttpSession session) {
			
			Member m = (Member)session.getAttribute("loginUser");
			board.setWriter(m.getName());
			boardService.insertBoard(board);
			return "redirect:/boardList";
		}*/
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:/boardList";
	}
	
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam(value="nowPage", defaultValue="0") int nowPage, Board board, Model model) {
		Board b = boardService.SelectBoard(board);
		

		model.addAttribute("board", b);
		model.addAttribute("nowPage", nowPage);
		
		return "board/boardDetail";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam(value="nowPage", defaultValue="0") int nowPage, Board board, Model model)
	{

		boardService.deleteBoard(board);
		return "redirect:/boardList?nowPage=" + nowPage;
	}
}
