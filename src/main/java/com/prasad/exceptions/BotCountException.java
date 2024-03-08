package com.prasad.exceptions;

public class BotCountException extends RuntimeException{
	
	private static final long serialVersionUID = 5214515159417018984L;

	public BotCountException(String message) {
		super(message);
	}
}
