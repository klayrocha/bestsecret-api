package com.ghostgame.api.exception;

/**
 * Class for exception handling for numbers
 * 
 * @author Francis Klay Rocha
 *
 */
public class IsNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	public IsNumberException(String msg) {
		super(msg);
	}

	public IsNumberException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
