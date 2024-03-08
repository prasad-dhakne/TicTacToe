package com.prasad.factory;

import com.prasad.strategies.winningstrategies.BothDiagonalAndRowColumnWinningStrategy;
import com.prasad.strategies.winningstrategies.DiagonalWinningStrategy;
import com.prasad.strategies.winningstrategies.RowColumnWinningStrategy;
import com.prasad.strategies.winningstrategies.WinningStrategy;

public class WinningStrategyFactory {
	
    public static WinningStrategy createStrategy(String winningStrategy, int size) {
        switch (winningStrategy) {
            case "RowColumn":
                return new RowColumnWinningStrategy(size);
            case "Diagonal":
                return new DiagonalWinningStrategy();
            case "Both":
            	return new BothDiagonalAndRowColumnWinningStrategy(size);
            default:
                throw new IllegalArgumentException("Invalid winning strategy: " + winningStrategy);
        }
    }

}
