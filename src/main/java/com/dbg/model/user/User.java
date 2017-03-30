package com.dbg.model.user;

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
import com.dbg.model.evaluation.Evaluation;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1443030971354997994L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	private List<Evaluation> evaluations = new ArrayList<Evaluation>();

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
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
