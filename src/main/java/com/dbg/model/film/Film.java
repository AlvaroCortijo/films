package com.dbg.model.film;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dbg.model.category.Category;
import com.dbg.model.evaluation.Evaluation;

@Entity
@Table(name = "film")
public class Film implements Serializable {

	private static final long serialVersionUID = -4020532299039261048L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true)
	private String title;

	@Column(nullable = false)
	private Integer year;

	@ManyToOne
	private Category category;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="film")
	private List<Evaluation> evaluations = new ArrayList<Evaluation>();
	
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
