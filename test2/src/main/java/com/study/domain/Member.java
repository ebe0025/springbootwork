package com.study.domain;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Member1")
public class Member {
	@Id
	private String id;
	@NonNull
	private String pass;
	@NonNull
	private String name;
	private String email;
}
