package com.prasad.dto;

import java.util.List;

import com.prasad.models.Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRequestDTO {
	
	private Long gameId;
	private List<Player> players;
	private String winningStrategy;
}
