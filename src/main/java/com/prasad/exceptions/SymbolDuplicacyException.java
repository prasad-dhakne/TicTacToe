package com.prasad.exceptions;

public class SymbolDuplicacyException extends RuntimeException {

	private static final long serialVersionUID = -5109052815857833756L;
	
	public SymbolDuplicacyException(String message) {
		super(message);
	}
}
