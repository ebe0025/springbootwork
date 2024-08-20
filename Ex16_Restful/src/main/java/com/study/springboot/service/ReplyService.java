package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Reply;
import com.study.springboot.repository.ReplyRepository;

@Service
public class ReplyService {
	@Autowired
	ReplyRepository replyRepository;

	public Reply insertReply(Reply reply) {
		
		return replyRepository.save(reply);
		
	}

	public List<Reply> getAllReplyWithBoard(Long bno) {
		return replyRepository.findByRefBno(bno);
	}
	
	
}
