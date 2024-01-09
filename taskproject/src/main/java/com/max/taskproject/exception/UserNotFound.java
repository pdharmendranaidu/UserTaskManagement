package com.max.taskproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{
	private String message;
	

	public UserNotFound(String message) {
		// TODO Auto-generated constructor stub
		super(message);
		this.message=message;
	}
}


