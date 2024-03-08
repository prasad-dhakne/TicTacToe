package com.prasad.strategies.winningstrategies;

import java.util.HashMap;
import java.util.Map;

import com.prasad.models.Board;
import com.prasad.models.Move;
import com.prasad.models.Symbol;

import lombok.Data;

@Data
public class DiagonalWinningStrategy implements WinningStrategy{
	
	private Map<Symbol, Integer> diagonal;
	private Map<Symbol, Integer> reverseDiagonal;
	
	public DiagonalWinningStrategy() {
		diagonal = new HashMap<>();
		reverseDiagonal = new HashMap<>();
	}

	@Override
	public boolean isWinner(Move move, Board board) {
		int i = move.getCell().getRow();
		int j = move.getCell().getCol();
		Symbol symbol = move.getCell().getPlayer().getSymbol();
		int size = board.getSize();
		
		if(i == j) {
			diagonal.put(symbol, diagonal.getOrDefault(symbol, 0) + 1);
		}
		if((i + j) == (size - 1)) {
			reverseDiagonal.put(symbol, reverseDiagonal.getOrDefault(symbol, 0) + 1);
		}
		return diagonal.getOrDefault(symbol, 0) == size || reverseDiagonal.getOrDefault(symbol, 0) == size;
	}

}
