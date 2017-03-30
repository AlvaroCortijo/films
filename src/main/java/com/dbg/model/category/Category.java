package com.dbg.model.category;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = -6850865486572251075L;

	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
