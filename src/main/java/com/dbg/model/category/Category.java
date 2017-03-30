package com.dbg.model.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dbg.model.film.Film;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = -6850865486572251075L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="category")
	private List<Film> films = new ArrayList<Film>();

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

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
