package com.dbg.service.evaluation;

import java.util.List;

import com.dbg.dto.evaluation.EvaluationDTO;
import com.dbg.dto.evaluation.EvaluationPostDTO;
import com.dbg.exceptions.EvaluationNotFoundException;
import com.dbg.exceptions.FilmNotFoundException;
import com.dbg.exceptions.InvalidDataException;
import com.dbg.exceptions.UserNotFoundException;
import com.dbg.model.evaluation.Evaluation;

public interface EvaluationService {

	List<EvaluationDTO> findAll(Integer id, Integer idFilm, Integer idCategory);
	List<EvaluationDTO> findAll(String name, String title);
	EvaluationDTO findById(Integer id) throws EvaluationNotFoundException;
	EvaluationDTO create(EvaluationPostDTO evaluationPostDTO) throws InvalidDataException, FilmNotFoundException, UserNotFoundException;
	EvaluationDTO update(Integer id, EvaluationDTO evaluationDTO) throws EvaluationNotFoundException;
	void delete(Integer id) throws EvaluationNotFoundException;
	EvaluationDTO transform(Evaluation evaluation);
	Evaluation transform(EvaluationPostDTO evaluationPostDTO) throws FilmNotFoundException, UserNotFoundException;
}
