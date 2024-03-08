package com.prasad.strategies.winningstrategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prasad.models.Board;
import com.prasad.models.Move;
import com.prasad.models.Symbol;

import lombok.Data;

@Data
public class BothDiagonalAndRowColumnWinningStrategy implements WinningStrategy {
	
	private List<Map<Symbol, Integer>> rows;
	private List<Map<Symbol, Integer>> cols;
	private Map<Symbol, Integer> diagonal;
	private Map<Symbol, Integer> reverseDiagonal;
	
	public BothDiagonalAndRowColumnWinningStrategy(int size) {
		
		rows = new ArrayList<>();
		cols = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			rows.add(new HashMap<>());
			cols.add(new HashMap<>());
		}
		
		diagonal = new HashMap<>();
		reverseDiagonal = new HashMap<>();
	}

	@Override
	public boolean isWinner(Move move, Board board) {
		int i = move.getCell().getRow();
		int j = move.getCell().getCol();
		Symbol symbol = move.getCell().getPlayer().getSymbol();
		int size = board.getSize();
		
		rows.get(i).put(symbol, rows.get(i).getOrDefault(symbol, 0) + 1);
		cols.get(j).put(symbol, cols.get(j).getOrDefault(symbol, 0) + 1);
		
		if(rows.get(i).get(symbol) == size
				|| cols.get(j).get(symbol) == size) {
			return true;
		}
		
		if(i == j) {
			diagonal.put(symbol, diagonal.getOrDefault(symbol, 0) + 1);
		}
		else if((i + j) == size) {
			reverseDiagonal.put(symbol, reverseDiagonal.getOrDefault(symbol, 0) + 1);
		}
		
		return diagonal.getOrDefault(symbol, 0) == size || reverseDiagonal.getOrDefault(symbol, 0) == size;
	}

}
