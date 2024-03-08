package com.prasad.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cell {
	
	private Integer row;
	private Integer col;
	private CellState cellState;
	private Player player;
	
}
