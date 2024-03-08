package com.prasad.service;

import org.springframework.stereotype.Service;

@Service
public class GameIdService {
	
	private Long gameId = 0l;
	
	public Long generateGameId() {
		return gameId++;
	}
}
