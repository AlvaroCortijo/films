package com.dbg.controller.evaluation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbg.dto.evaluation.EvaluationDTO;
import com.dbg.service.evaluation.EvaluationService;

@RestController
@RequestMapping(value="/evaluation")
public class EvaluationController {
	
	@Autowired
	private EvaluationService evaluationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EvaluationDTO> findByUserId(@RequestParam(value = "idUser", required = false) Integer idUser, 
			@RequestParam(value = "idFilm", required = false) Integer idFilm){
		return evaluationService.findAll(idUser, idFilm);
	}
}
