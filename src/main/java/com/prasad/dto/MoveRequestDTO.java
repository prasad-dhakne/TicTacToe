package com.prasad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoveRequestDTO {
	
	private Long gameId;
	private Integer row;
	private Integer col;
	
}
