package com.dbg.controller.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbg.dto.film.FilmDTO;
import com.dbg.service.film.FilmService;

@RestController
@RequestMapping(value="/film")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@RequestMapping(method = RequestMethod.POST)
	public FilmDTO create(@RequestBody FilmDTO filmDTO){
		return filmService.create(filmDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id){
		filmService.delete(id);
	}
}
