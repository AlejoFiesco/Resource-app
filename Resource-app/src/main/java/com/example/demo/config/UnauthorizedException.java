package com.example.demo.config;

public class UnauthorizedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3168577339767609102L;

	public UnauthorizedException(String message) {
		super(message);
	}
}
