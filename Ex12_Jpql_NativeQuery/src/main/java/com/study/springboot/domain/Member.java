package com.study.springboot.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "jpapaging")
public class Member {
	@Id
	@SequenceGenerator(
			name = "pagingseq",
			sequenceName = "jpaPaging_seq",
			initialValue = 1,
			allocationSize = 1
			)
	@GeneratedValue (generator="pagingseq")
	private Long id;
	private String name;
	private String email;
	
	public Member(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	
}
