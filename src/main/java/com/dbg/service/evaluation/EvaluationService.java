package com.dbg.service.evaluation;

import java.util.List;

import com.dbg.dto.evaluation.EvaluationDTO;
import com.dbg.model.evaluation.Evaluation;

public interface EvaluationService {

	List<EvaluationDTO> findAll(Integer id, Integer idFilm);
	EvaluationDTO transform(Evaluation evaluation);
	Evaluation transform(EvaluationDTO evaluationDTO);
}
