package com.prasad.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.prasad.models.Game;

@Service
public class GameStorageService {
	private Map<Long, Game> gamesMap = new ConcurrentHashMap<>();

    public void addGame(Long key, Game object) {
    	gamesMap.put(key, object);
    }

    public Game getGame(Long key) {
        return gamesMap.get(key);
    }

    public void removeGame(Long key) {
    	gamesMap.remove(key);
    }

}
