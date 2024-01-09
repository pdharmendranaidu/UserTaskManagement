package com.max.taskproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class APIException extends RuntimeException{

	
	public String message;
	public APIException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
		this.message=message;
		
	}
}
