package com.prasad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prasad.dto.GameRequestDTO;
import com.prasad.dto.MoveRequestDTO;
import com.prasad.factory.WinningStrategyFactory;
import com.prasad.models.Game;
import com.prasad.models.GameStatus;
import com.prasad.models.Player;
import com.prasad.service.GameIdService;
import com.prasad.service.GameStorageService;
import com.prasad.service.PlayerService;
import com.prasad.strategies.winningstrategies.WinningStrategy;

@RestController
public class GameController {
	
	@Autowired
	GameStorageService gameStorageService;
	
	@Autowired
	GameIdService gameIdService;
	
	@Autowired
	PlayerService playerService;
	
	@GetMapping("/startgame")
	public ResponseEntity<Game> startGame(@RequestBody GameRequestDTO gameRequestDTO) throws Exception {
		Long gameId = gameIdService.generateGameId();
		if(gameStorageService.getGame(gameId) == null){
			int size = gameRequestDTO.getPlayers().size();
			WinningStrategy winningStrategy = WinningStrategyFactory
					.createStrategy(gameRequestDTO.getWinningStrategy(), size);
			List<Player> players = playerService.generateActualPlayerList(gameRequestDTO.getPlayers());
			Game game = Game.getBuilder()
					.setGameId(gameId)
					.setPlayers(players)
					.setWinningStrategy(winningStrategy)
					.build();
			gameStorageService.addGame(gameId, game);
			return ResponseEntity.ok(game);
		}else {
			throw new Exception("Game Id already exists");
		}
	}
	
	@GetMapping("/getname")
	public String getName() {
		return "TicTacToe";
	}
	
	public void displayBoard(Game game) {
		game.dispalyBoard();
	}
	
	@GetMapping("/makemove")
	public ResponseEntity<Game> makeMove(@RequestBody MoveRequestDTO moveRequestDTO) {
		Long gameId = moveRequestDTO.getGameId();
		Game game = gameStorageService.getGame(gameId);
		if(game != null) {
			game.makeMove(moveRequestDTO.getRow(), moveRequestDTO.getCol());
			if(game.getGameStatus().equals(GameStatus.ENDED) ||
					game.getGameStatus().equals(GameStatus.DRAW)) {
				gameStorageService.removeGame(gameId);
			}
		}
		return ResponseEntity.ok(game);
	}
}
