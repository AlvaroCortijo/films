package com.dbg.dao.film;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dbg.model.film.Film;

@Repository
public interface FilmDao extends PagingAndSortingRepository<Film, String> {
	
	public List<Film> findByTitleContaining(String title);
}
