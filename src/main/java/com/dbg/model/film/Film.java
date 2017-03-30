package com.dbg.model.film;

import java.io.Serializable;

public class Film implements Serializable {

	private static final long serialVersionUID = -4020532299039261048L;

	private Integer id;

	private String title;

	private Integer year;

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
