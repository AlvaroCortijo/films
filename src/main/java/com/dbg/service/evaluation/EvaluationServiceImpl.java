package com.dbg.service.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbg.dao.evaluation.EvaluationDao;
import com.dbg.dao.film.FilmDao;
import com.dbg.dao.user.UserDao;
import com.dbg.dto.evaluation.EvaluationDTO;
import com.dbg.exceptions.EvaluationNotFoundException;
import com.dbg.exceptions.InvalidDataException;
import com.dbg.model.evaluation.Evaluation;
import com.dbg.model.film.Film;
import com.dbg.model.user.User;

@Service
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationDao evaluationDao;
	
	@Autowired
	private FilmDao filmDao;
	
	@Autowired
	private UserDao userDao;
	
	private static final Logger log = LoggerFactory.getLogger(EvaluationServiceImpl.class);

	@Override
	public List<EvaluationDTO> findAll(Integer idUser, Integer idFilm, Integer idCategory) {
		final List<Evaluation> evaluations = evaluationDao.findByUserIdAndFilmIdAndCategoryId(idUser, idFilm, idCategory);
		final List<EvaluationDTO> evaluationsDTO = new ArrayList<EvaluationDTO>();
		evaluations.forEach(e -> evaluationsDTO.add(transform(e)));
		return evaluationsDTO;
	}
	
	@Override
	public List<EvaluationDTO> findAll(String name, String title) {
		final List<Evaluation> evaluations = evaluationDao.findByUserNameAndFilmTitle(name, title);
		final List<EvaluationDTO> evaluationsDTO = new ArrayList<EvaluationDTO>();
		evaluations.forEach(e -> evaluationsDTO.add(transform(e)));
		return evaluationsDTO;
	}
	
	@Override
	public EvaluationDTO findById(Integer id) throws EvaluationNotFoundException{
		final Evaluation evaluation = evaluationDao.findById(id);
		if(evaluation != null)
			return transform(evaluation);
		throw new EvaluationNotFoundException();
	}
	
	@Override
	public EvaluationDTO create(EvaluationDTO evaluationDTO) throws InvalidDataException{
		if(validate(evaluationDTO)){
			log.debug(String.format("create - evaluationDTO con points %d",evaluationDTO.getPoints()));
			final Evaluation evaluation = transform(evaluationDTO);
			log.debug(String.format("create - evaluation con points %d",evaluation.getPoints()));
			return transform(evaluationDao.save(evaluation));
		}
		throw new InvalidDataException("Invalid evaluation data");
	}

	@Override
	public EvaluationDTO update(Integer id, EvaluationDTO evaluationDTO) throws EvaluationNotFoundException {
		final Evaluation evaluation = evaluationDao.findById(id);
		if(evaluation != null){
			evaluation.setPoints(evaluationDTO.getPoints());
			log.debug(String.format("Actualizando evaluation con id %d y points %d", evaluation.getId(), evaluation.getPoints()));
			return transform(evaluationDao.save(evaluation));
		}
		throw new EvaluationNotFoundException();
	}

	@Override
	public void delete(Integer id) throws EvaluationNotFoundException{
		if(evaluationDao.findById(id) != null)
			evaluationDao.delete(id);
		else throw new EvaluationNotFoundException();
	}
	
	@Override
	public EvaluationDTO transform(Evaluation evaluation) {
		final EvaluationDTO evaluationDTO = new EvaluationDTO();
		if(evaluation.getPoints() != null)
			evaluationDTO.setPoints(evaluation.getPoints());
		if(evaluation.getUser() != null)
			evaluationDTO.setName(evaluation.getUser().getName());
		if(evaluation.getFilm() != null)
			evaluationDTO.setTitle(evaluation.getFilm().getTitle());

		return evaluationDTO;
	}

	@Override
	public Evaluation transform(EvaluationDTO evaluationDTO) {
		log.debug(String.format("transform - evaluationDTO con points %d",evaluationDTO.getPoints()));
		final Evaluation evaluation = new Evaluation();
		evaluation.setPoints(evaluationDTO.getPoints());
		final Film film = filmDao.findByTitle(evaluationDTO.getTitle());
		evaluation.setFilm(film);
		final User user = userDao.findByName(evaluationDTO.getName());
		evaluation.setUser(user);
		log.debug(String.format("transform - evaluation con points %d",evaluation.getPoints()));
		return evaluation;
	}

	private Boolean validate(EvaluationDTO evaluationDTO){
		return evaluationDTO != null && evaluationDTO.getPoints() != null;
	}
	
}
