package com.dbg.exceptions;

public class EvaluationNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -5420951557102289463L;
	
	private static final String MSG = "Evaluation not found";

	public EvaluationNotFoundException() {
		super(MSG);
	}

}
