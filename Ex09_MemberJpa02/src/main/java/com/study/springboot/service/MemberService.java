package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	// save() : insert할 때의 메소드(JPA에 API)
	public Member insert(Member member) {
		Member rMember = memberRepository.save(member);
		return rMember;
	}

	
	/*
	   Optional<T> : NullpointerException 발생을 방지하기 위해 사용
	   				 기존의 반환 값에 타입T를 Optional<T> Wrapping하여,
	   				  null대신 Optional 안에 빈 타입 개체를 돌려주는 기법
	   	ex) Member member = memberRepository.findById(id)
	   		member.getId(); => NullpointerException 발생
	 */
	public Optional<Member> select(Long id) {
		// findById() : Id는 @Id를 의미(primary key)
		Optional<Member> member = memberRepository.findById(id);
		return member;
	}


	public List<Member> selectAll() {

		return memberRepository.findAll();
	}
	
	public Member Update(Member m) {
		// save() : insert할 때의 메소드(JPA에 API)
		//			동일한 키가 있으면 update, 키가 없으면 insert
		
		Member member = memberRepository.save(m);
		return member;
	}


	public void delete(Long id) {
		memberRepository.deleteById(id);
	}


	public Optional<Member> selectByName(String name) {
		Optional<Member> member = memberRepository.findByUsername(name);
		return member;
	}


	public Optional<Member> selectByEmail(String email) {
		Optional<Member> member = memberRepository.findByEmail(email);
		return member;
	}


	public List<Member> selectByLikeName(String name) {
		List<Member> list = memberRepository.findByUsernameLike(name);
		return list;
	}


	public List<Member> selectByNameLikeDesc(String username) {
		List<Member> list = memberRepository.findByUsernameLikeOrderByUsernameDesc(username);
		return list;
	}


	public List<Member> selectByNameLikeSort(String username, Sort sort) {
		return memberRepository.findByUsernameLike(username, sort);
	}

}
