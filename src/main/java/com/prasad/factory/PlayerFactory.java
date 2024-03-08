package com.prasad.factory;

import com.prasad.models.EasyBot;
import com.prasad.models.Human;
import com.prasad.models.Player;
import com.prasad.models.PlayerType;
import com.prasad.models.Symbol;

public class PlayerFactory {
	public static Player createPlayer(String id, String name, Symbol symbol, String playerType) {
		switch (playerType) {
	        case "HUMAN":
	            return new Human(id, name, symbol, PlayerType.HUMAN);
	        case "BOT":
	            return new EasyBot(id, name, symbol, PlayerType.BOT);
	        default:
	            throw new IllegalArgumentException("Invalid Player Type: " + playerType);
	    }
	}
}
