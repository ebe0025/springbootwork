package com.study.springboot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@NonNull
	private int boardno;
	private String title;
	private String writer;
	private String content;
}
