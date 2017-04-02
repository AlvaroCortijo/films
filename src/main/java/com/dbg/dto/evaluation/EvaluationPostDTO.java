package com.dbg.dto.evaluation;

import java.io.Serializable;

public class EvaluationPostDTO implements Serializable  {

	private static final long serialVersionUID = -8568423558531001380L;
	
	private Integer points;
	private Integer idFilm;
	private Integer idUser;
	
	public EvaluationPostDTO() {
		super();
	}

	public EvaluationPostDTO(Integer points, Integer idFilm, Integer idUser) {
		super();
		this.points = points;
		this.idUser = idUser;
		this.idFilm = idFilm;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(Integer idFilm) {
		this.idFilm = idFilm;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

}
