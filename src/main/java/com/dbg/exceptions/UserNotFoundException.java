package com.dbg.exceptions;

public class UserNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -5420951557102289463L;

	private static final String MSG = "User not found";

	public UserNotFoundException() {
		super(MSG);
	}
}
