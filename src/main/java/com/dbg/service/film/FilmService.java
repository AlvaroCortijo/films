package com.dbg.service.film;

import com.dbg.dto.film.FilmDTO;
import com.dbg.model.film.Film;

public interface FilmService {
	
	FilmDTO create(FilmDTO filmDTO);
	void delete(Integer id);
	FilmDTO transform(Film film);
	Film transform(FilmDTO filmDTO);
}
