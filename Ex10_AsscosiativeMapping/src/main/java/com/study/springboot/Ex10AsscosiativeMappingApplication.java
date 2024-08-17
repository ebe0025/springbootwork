package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //수정 insert를 관리해주는 역활 시간관련 저장 
@SpringBootApplication
public class Ex10AsscosiativeMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex10AsscosiativeMappingApplication.class, args);
	}

}
