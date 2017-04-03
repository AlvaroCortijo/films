package com.dbg.controller.fails;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dbg.dto.error.ApiErrorDTO;
import com.dbg.exceptions.EvaluationNotFoundException;
import com.dbg.exceptions.FilmNotFoundException;
import com.dbg.exceptions.InvalidDataException;
import com.dbg.exceptions.UserNotFoundException;

@ControllerAdvice(basePackages={"com.dbg.controller"})
public class ControllerFails {

	@ResponseBody
	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorDTO error(InvalidDataException e) {
		return new ApiErrorDTO(400, e.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler({EvaluationNotFoundException.class, UserNotFoundException.class, FilmNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorDTO error(Exception e) {
		return new ApiErrorDTO(404, e.getMessage());
	}
	
}
