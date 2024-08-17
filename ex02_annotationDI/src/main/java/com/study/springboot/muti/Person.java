package com.study.springboot.muti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 이름을 명시하지 않으면 빈의 이름 소문자로 등록(person 등록)
@Component
public class Person {
	@Value("홍길동")
	private String name;
	@Value("협객도적")
	private String nickName;
	@Autowired
	@Qualifier("printerA")
	private Printer printer;
	
	public Person() {
	}
	public Person(String name, String nickName, Printer printer) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.printer = printer;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		printer.print("Hello " + name + " : " + nickName);
	}
}
