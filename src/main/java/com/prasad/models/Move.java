package com.prasad.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Move {
	private Cell cell;
	
	public Move(Cell cell) {
		this.cell = cell;
	}

}
