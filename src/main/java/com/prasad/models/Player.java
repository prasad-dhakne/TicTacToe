package com.prasad.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	
	private String id;
	private String name;
	private Symbol symbol;
	private PlayerType playerType;
	
	public Move makeMove(Board board, Integer row, Integer col) {
		return null;
	}
	
}
