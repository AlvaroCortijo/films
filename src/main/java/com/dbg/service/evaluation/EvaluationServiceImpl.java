package com.dbg.service.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbg.dao.evaluation.EvaluationDao;
import com.dbg.dto.evaluation.EvaluationDTO;
import com.dbg.model.evaluation.Evaluation;

@Service
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationDao evaluationDao;

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
	public EvaluationDTO transform(Evaluation evaluation) {
		final EvaluationDTO evaluationDTO = 
				new EvaluationDTO(evaluation.getPoints(), evaluation.getUser().getName(), evaluation.getFilm().getTitle());
		return evaluationDTO;
	}

	@Override
	public Evaluation transform(EvaluationDTO evaluationDTO) {
		final Evaluation evaluation = new Evaluation();
		evaluation.setPoints(evaluationDTO.getPoints());
		return evaluation;
	}

}
