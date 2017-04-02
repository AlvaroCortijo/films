package com.dbg.exceptions;

public class NotFoundException extends Exception{

	private static final long serialVersionUID = 4313423847570665050L;

	private static final String MSG = "Entity not found";

	public NotFoundException() {
		super(MSG);
	}

	public NotFoundException(String message) {
		super(message);
	}
	
}
