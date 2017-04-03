package com.dbg.controller.evaluation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbg.dto.evaluation.EvaluationDTO;
import com.dbg.dto.evaluation.EvaluationPostDTO;
import com.dbg.exceptions.EvaluationNotFoundException;
import com.dbg.exceptions.FilmNotFoundException;
import com.dbg.exceptions.InvalidDataException;
import com.dbg.exceptions.UserNotFoundException;
import com.dbg.service.evaluation.EvaluationService;

@RestController
@RequestMapping(value="/evaluation")
public class EvaluationController {
	
	@Autowired
	private EvaluationService evaluationService;
	
	private static final Logger log = LoggerFactory.getLogger(EvaluationController.class);
	
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EvaluationDTO findById(@PathVariable("id") Integer id) throws EvaluationNotFoundException{
		return evaluationService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public EvaluationDTO create(@RequestBody EvaluationPostDTO evaluationPostDTO) throws InvalidDataException, FilmNotFoundException, UserNotFoundException{
		return evaluationService.create(evaluationPostDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public EvaluationDTO update(@PathVariable("id") Integer id, @RequestBody EvaluationDTO evaluationDTO) throws EvaluationNotFoundException{
		log.debug(String.format("Vamos a actualizar evaluation con id %d y points %d", id, evaluationDTO.getPoints()));
		return evaluationService.update(id, evaluationDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) throws EvaluationNotFoundException{
		evaluationService.delete(id);
	}
	
}
