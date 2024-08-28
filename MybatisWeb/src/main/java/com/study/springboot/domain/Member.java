package com.study.springboot.domain;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String id;
	private String pass;
	private String gender;
	private String regDate;
	private String birthDay;
	
	public Member() {
	}

	public Member(String id, String pass, String gender, String regDate, String birthDay) {
		super();
		this.id = id;
		this.pass = pass;
		this.gender = gender;
		this.regDate = regDate;
		this.birthDay = birthDay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pass=" + pass + ", gender=" + gender + ", regDate=" + regDate + ", birthDay="
				+ birthDay + "]";
	}
	
	
	
	
}
