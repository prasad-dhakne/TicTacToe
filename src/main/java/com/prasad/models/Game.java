package com.prasad.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.prasad.exceptions.BotCountException;
import com.prasad.exceptions.SymbolDuplicacyException;
import com.prasad.strategies.winningstrategies.WinningStrategy;

import lombok.Data;

@Data
public class Game {
	
	private Long gameId;
	private Board board;
	private Integer currentPlayerIndex;
	private WinningStrategy winningStrategy;
	private List<Player> players;
	private List<Move> moves;
	private GameStatus gameStatus;
	private Player winner;
	
	private Game(Long gameId, List<Player> players, WinningStrategy winningStrategy) {
		this.gameId = gameId;
		board = new Board(players.size() + 1);
		this.players = players;
		this.winningStrategy = winningStrategy;
		currentPlayerIndex = 0;
		moves = new ArrayList<>();
		gameStatus = GameStatus.INPROGRESS;
	}
	
	public Board getBoard() {
		return board;
	}

	public Integer getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	public void setCurrentPlayerIndex(Integer currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}

	public WinningStrategy getWinningStrategy() {
		return winningStrategy;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public static Builder getBuilder() {
		return new Builder();
	}
	
	public String toString() {
		return "Returned Game Object";
	}
	
	public static class Builder{
		
		private Long gameId;
		private List<Player> players;
		private WinningStrategy winningStrategy;
		
		public Builder setGameId(Long gameId) {
			this.gameId = gameId;
			return this;
		}
		
		public Builder setPlayers(List<Player> players) {
			this.players = players;
			return this;
		}
		
		public Builder setWinningStrategy(WinningStrategy winningStrategy) {
			this.winningStrategy = winningStrategy;
			return this;
		}
		
		public Builder addPlayer(Player player) {
			players.add(player);
			return this;
		}
		
		public Game build() {
			validate();
			return new Game(gameId, players, winningStrategy);
		}
		
		private void validate() {
			validateBotCount();
			validateSymbolDuplicacy();
		}
		
		private void validateBotCount() {
			Integer botCount = 0;
			for(Player player : players) {
				if(player.getPlayerType().equals(PlayerType.BOT)) {
					botCount++;
				}
				if(botCount > 1) {
					throw new BotCountException("The number of bot should not be greater than 1");
				}
			}
		}
		
		private void validateSymbolDuplicacy() {
			Set<String> symbolSet = new HashSet<>();
			for(Player player : players) {
				if(symbolSet.contains(player.getSymbol().getSymbolChar())) {
					throw new SymbolDuplicacyException("Please select different symbol for different player");
				}
				else {
					symbolSet.add(player.getSymbol().getSymbolChar());
				}
			}
		}
	}

	public void dispalyBoard() {
		this.board.displayBoard();
	}

	public void makeMove(Integer row, Integer col) {
		Player player = players.get(currentPlayerIndex);
		Move move = player.makeMove(board, row, col);
		
		moves.add(move);
		
		if(winningStrategy.isWinner(move, board)) {
			setWinner(player);
			setGameStatus(GameStatus.ENDED);
			board.displayBoard();
			System.out.println("Game Ended, " + player.getName() + " is the Winner!!");
			return;
		}
		
		int boardSize = board.getSize();
		if(moves.size() >= (boardSize * boardSize)) {
			setGameStatus(GameStatus.DRAW);
			System.out.println("Game Draw!!");
			return;
		}
		
		currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
	}
}
