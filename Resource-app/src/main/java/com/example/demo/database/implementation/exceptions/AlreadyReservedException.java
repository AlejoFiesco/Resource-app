package com.example.demo.database.implementation.exceptions;

public class AlreadyReservedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1370061339595885286L;

	public AlreadyReservedException(String string) {
		super(string);
	}
}
