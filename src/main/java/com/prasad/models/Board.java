package com.prasad.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Board {
	
	private Integer size;
	private List<List<Cell>> board;
	
	public Board(Integer size) {
		this.size = size;
		
		board = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			List<Cell> row = new ArrayList<>();
			for(int j = 0; j < size; j++) {
				Cell cell = new Cell();
				cell.setRow(i);
				cell.setCol(j);
				cell.setCellState(CellState.EMPTY);
				row.add(cell);
			}
			board.add(row);
		}
	}

	public void displayBoard() {
		for(int i = 0; i < size; i++) {
			List<Cell> row = board.get(i);
			for(int j = 0; j < size; j++) {
				Cell cell = row.get(j);
				if(cell.getCellState().equals(CellState.EMPTY)) {
					System.out.print("- ");
				}
				else {
					System.out.print(cell.getPlayer().getSymbol().getSymbolChar() + " ");
				}
			}
			System.out.println();
			board.add(row);
		}
		System.out.println();
	}
}
