package com.dbg.service.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbg.dao.film.FilmDao;
import com.dbg.dto.film.FilmDTO;
import com.dbg.model.film.Film;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDao filmDao;
	
	@Override
	public FilmDTO create(FilmDTO filmDTO) {
		final Film film = transform(filmDTO);
		return transform(filmDao.save(film));
	}

	@Override
	public FilmDTO findById(Integer id) {
		return transform(filmDao.findOne(id));
	}
	
	@Override
	public void delete(Integer id) {
		filmDao.delete(id);
	}
	
	@Override
	public FilmDTO transform(Film film) {
		final FilmDTO filmDTO = new FilmDTO(film.getId(), film.getTitle(), film.getYear());
		return filmDTO;
	}

	@Override
	public Film transform(FilmDTO filmDTO) {
		final Film film = new Film();
		film.setId(filmDTO.getId());
		film.setTitle(filmDTO.getTitle());
		film.setYear(filmDTO.getYear());
		return null;
	}

}
