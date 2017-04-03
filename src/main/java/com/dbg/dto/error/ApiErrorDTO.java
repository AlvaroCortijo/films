package com.dbg.dto.error;

import java.io.Serializable;

public class ApiErrorDTO implements Serializable {

	private static final long serialVersionUID = -9005716600920644905L;

	private Integer code;
	private String msg;
	
	public ApiErrorDTO() {
		super();
	}

	public ApiErrorDTO(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
