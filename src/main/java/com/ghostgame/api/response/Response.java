package com.ghostgame.api.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used in return on controllers
 * 
 * @author Francis Klay Rocha
 *
 * @param <T>
 */
public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private T data;
	private List<String> errors;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
