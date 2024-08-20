package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	BoardRepository boardRepository;


	public Board insertBoard(Board b) {
		return boardRepository.save(b);
	}

	public Page<Board> list(PageRequest of) {
		
		return boardRepository.findAll(of);
	}

	public Board SelectBoard(Board board) {
		
		Optional<Board> b = boardRepository.findById(board.getBno());
		Board changeBoard = b.get();
		changeBoard.setCount(changeBoard.getCount() + 1);
		boardRepository.save(changeBoard);
		return changeBoard;
	}

	public void deleteBoard(Board board) {
		Optional<Board> b = boardRepository.findById(board.getBno());
		
		boardRepository.delete(b.get());
		
	}
	
	
}
