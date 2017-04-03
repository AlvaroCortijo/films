package com.dbg.exceptions;

public class FilmNotFoundException extends NotFoundException {

	private static final long serialVersionUID = 3547543502088728473L;

	private static final String MSG = "Film not found";

	public FilmNotFoundException() {
		super(MSG);
	}

}
