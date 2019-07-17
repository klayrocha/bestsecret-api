package com.ghostgame.api.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * Class with error information
 * 
 * @author Francis Klay Rocha
 *
 */
public class ApiError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;

	ApiError(HttpStatus status, String message, Throwable ex) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiError other = (ApiError) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApiError [status=" + status + ", message=" + message + "]";
	}
	
}