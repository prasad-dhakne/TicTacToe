package com.prasad.models;

public class Human extends Player{

	public Human(String id, String name, Symbol symbol, PlayerType playerType) {
		super(id, name, symbol, playerType);
	}
	
	@Override
	public Move makeMove(Board board, Integer row, Integer col) {
		Cell cell = board.getBoard().get(row).get(col);
		cell.setCellState(CellState.FILLED);
		cell.setPlayer(this);

		return new Move(cell);
	}

}
