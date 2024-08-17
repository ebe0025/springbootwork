package com.study.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.dto.Board;
import com.study.springboot.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "redirect:list";
	}
	
	/*
	 * 요청 처리 후 응답페이지로 포워딩 또는 url재요청시 응답 데이터를 담는 방법
	   1. Model 객체
	   	  포워딩할 뷰로 전달하고자 하는 데이터를 맵형식<key-value>로 담을 수 있는 영역
	   	  requestScope임.
	   	  ** 단, setAttribute가 아닌 addAttribute메소드 이용
	   2. ModelAndView
	      Model은 데이터를 맵형식<key-value>로 담을 수 있는 영역
	      View는 응답뷰에 대한 정보를 담을 수 있는 공간
	 
	 */
	
	@RequestMapping("/list")
	public String userlistPage(Model model){
		model.addAttribute("totalRecord", boardService.totalRecord());
		model.addAttribute("list", boardService.list());
		return "list";
	}
	/*
	 * 요청시 전달한값(파라메터)를 받는 방법
	   1. HttpServletRequest를 이용하여 전달받는 방법
	      : 메서드의 매개변수에 넣는방법
	      ex ) 메서드명(HttpServletRequest request)
	   2. 어노테이션을 사용 하는 방법 : @RequestParam
	      : 메서드 위에 어노테이션을 넣는 방법
	      - 변수에 저장할 때 : request.getParamater("키")
	      
	   3. 메서드 매개변수에 직접 이름(전달한 키와 동일한 이름)을 넣어줌
	 * 
	 */
	
	
	@RequestMapping("/detail")
	public String detailView(HttpServletRequest request, Model model) {
		String boardNo = request.getParameter("boardno");
		model.addAttribute("detail", boardService.detailBoard(boardNo));
		return "detail";
	}
	
	
	/* 2.
	@RequestMapping("/detail")
	public String detailView(@RequestParam(value="baordno") String bno,
							 @RequestParam(value="writer", defaultValue="홍길동") String w) {
		return "detail";
	}
	*/
	
//	@RequestMapping("/detail")
//	public String detailView(String boardno, Model model) {
//		//반드시 앞에서 넘겨준 키값과 동일하게 변수이름을 넣어야 함. default 사용 못함
//		model.addAttribute("detail", boardService.detailBoard(boardno));
//		return "detail";
//	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		String boardNo = request.getParameter("boardno");
		boardService.deleteBoard(boardNo);
		return "redirect:list";
	}
	
	@RequestMapping("/writerForm")
	public String writerForm() {
		
		return "writerForm";
	}
	
	/*
	 * 넘어온 값이 많아 객체로 받는 방식
	   - 커맨드 객체 방식
	   : 객체로 받을 때 사용
	   ** 요청시 전달값의 키(name속성의 값)을 객체에 담고자하는 필드명으로 작성
	   
	   스프링 컨테이너 해당 객체를 기본생성자로 생성 후 setter메소드를 호출하여 넣는다
	   
	   ex>
	   @RequestMapping("/writer")
	   public String write(@ModelAttribute("form") Board b){
	   		String title = b.getTitle();
	   }
	 */
	
   @RequestMapping("/write")
   public String write(@ModelAttribute("form") Board b){
   		boardService.insertBoard(b);
   		
   		
   		
   		return "redirect:list";
   }
	
	/*
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", writer);
		map.put("title", title);
		map.put("content", content);
		
		boardService.writeBoard(map);
		
		return "redirect:list";
	}
	*/
}
