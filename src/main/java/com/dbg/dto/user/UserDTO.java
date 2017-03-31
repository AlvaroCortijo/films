package com.dbg.dto.user;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -6608062330490381145L;

	private Integer Id;
	
	private String name;

	public UserDTO() {
		super();
	}

	public UserDTO(Integer id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
