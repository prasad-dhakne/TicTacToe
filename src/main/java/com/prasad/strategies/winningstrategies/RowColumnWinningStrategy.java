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
public class RowColumnWinningStrategy implements WinningStrategy{
	
	private List<Map<Symbol, Integer>> rows;
	private List<Map<Symbol, Integer>> cols;
	
	public RowColumnWinningStrategy(int size) {
		
		rows = new ArrayList<>();
		cols = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			rows.add(new HashMap<>());
			cols.add(new HashMap<>());
		}
	}

	@Override
	public boolean isWinner(Move move, Board board) {
		int i = move.getCell().getRow();
		int j = move.getCell().getCol();
		Symbol symbol = move.getCell().getPlayer().getSymbol();
		
		rows.get(i).put(symbol, rows.get(i).getOrDefault(symbol, 0) + 1);
		cols.get(j).put(symbol, cols.get(j).getOrDefault(symbol, 0) + 1);
		
		if(rows.get(i).get(symbol) == board.getSize()
				|| cols.get(j).get(symbol) == board.getSize()) {
			return true;
		}
		return false;
	}

}
