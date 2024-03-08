package com.prasad.strategies.winningstrategies;

import com.prasad.models.Board;
import com.prasad.models.Move;

public interface WinningStrategy {
	
	boolean isWinner(Move move, Board board);
}
