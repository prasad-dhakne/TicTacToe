package com.prasad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prasad.factory.PlayerFactory;
import com.prasad.models.Player;
import com.prasad.models.PlayerType;

@Service
public class PlayerService {
	
	public List<Player> generateActualPlayerList(List<Player> players){
		List<Player> actualPlayers = new ArrayList<>();
		
		for(Player player : players) {
			PlayerType playerType = player.getPlayerType();
			Player actualPlayer = PlayerFactory.createPlayer(player.getId(), player.getName(), 
					player.getSymbol(), playerType.toString());
			actualPlayers.add(actualPlayer);
		}
		return actualPlayers;
	}
}
