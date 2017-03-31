package com.dbg.dto.film;

import java.io.Serializable;

public class FilmDTO implements Serializable {

	private static final long serialVersionUID = -4400443452602956572L;

	private Integer id;
	private String title;
	private Integer year;
	
	public FilmDTO() {
		super();
	}

	public FilmDTO(Integer id, String title, Integer year) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
}
