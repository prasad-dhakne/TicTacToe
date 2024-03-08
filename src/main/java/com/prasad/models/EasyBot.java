package com.prasad.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyBot extends Bot{

	public EasyBot(String id, String name, Symbol symbol, PlayerType playerType) {
		super(id, name, symbol, playerType);
	}

	@Override
	public Move makeMove(Board board, Integer row, Integer col) {
		List<Integer> emptyCells = new ArrayList<>();
		int size = board.getSize();
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				Cell cell = board.getBoard().get(i).get(j);
				if(cell.getCellState().equals(CellState.EMPTY)) {
					emptyCells.add((i * size) + j);
				}
			}
		}
		
		Random random = new Random();
		int index = random.nextInt(emptyCells.size());
		int selectedCell = emptyCells.get(index);
		row = selectedCell / size;
		col = selectedCell % size;
		
		Cell cell = board.getBoard().get(row).get(col);
		cell.setCellState(CellState.FILLED);
		cell.setPlayer(this);
		
		return new Move(cell);
	}

}
