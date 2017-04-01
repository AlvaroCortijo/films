package com.dbg.dto.evaluation;

import java.io.Serializable;

public class EvaluationDTO implements Serializable {

	private static final long serialVersionUID = 6547927655556011477L;

	private Integer points;
	private String name;
	private String title;
	
	public EvaluationDTO() {
		super();
	}

	public EvaluationDTO(Integer points, String name, String title) {
		super();
		this.points = points;
		this.name = name;
		this.title = title;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
