package com.dbg.service.evaluation;

import java.util.List;

import com.dbg.dto.evaluation.EvaluationDTO;
import com.dbg.exceptions.EvaluationNotFoundException;
import com.dbg.exceptions.InvalidDataException;
import com.dbg.model.evaluation.Evaluation;

public interface EvaluationService {

	List<EvaluationDTO> findAll(Integer id, Integer idFilm, Integer idCategory);
	List<EvaluationDTO> findAll(String name, String title);
	EvaluationDTO findById(Integer id) throws EvaluationNotFoundException;
	EvaluationDTO create(EvaluationDTO evaluationDTO) throws InvalidDataException;
	EvaluationDTO update(Integer id, EvaluationDTO evaluationDTO) throws EvaluationNotFoundException;
	void delete(Integer id) throws EvaluationNotFoundException;
	EvaluationDTO transform(Evaluation evaluation);
	Evaluation transform(EvaluationDTO evaluationDTO);
}
