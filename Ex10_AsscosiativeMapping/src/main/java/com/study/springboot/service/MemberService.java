package com.study.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;

	public Member minsert(Member member) {
		
		return memberRepository.save(member);
	}






	public Member mupdate(Member member) {
		//member에는 찾아내야하는 id와 바꿀 이름의 정보가 들어있음	
		Optional<Member> m = memberRepository.findById(member.getId());
		Member uMember = m.get();
		uMember.setName(member.getName());
		return memberRepository.save(uMember);
	}
}
