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
	
	@RequestMapping(method = RequestMethod.GET, params={"!name", "!title"})
	public List<EvaluationDTO> findAll(@RequestParam(value = "idUser", required = false) Integer idUser, 
			@RequestParam(value = "idFilm", required = false) Integer idFilm, @RequestParam(value = "idCategory", required = false) Integer idCategory){
		return evaluationService.findAll(idUser, idFilm, idCategory);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EvaluationDTO> findAll(@RequestParam(value = "name", required = false) String name, 
			@RequestParam(value = "title", required = false) String title){
		return evaluationService.findAll(name, title);
	}
}
