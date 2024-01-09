package com.max.taskproject.exception;

public class TaskNotFound extends RuntimeException {

	public String message;

	public TaskNotFound(String message) {
		// TODO Auto-generated constructor stub

		super(message);

		this.message = message;
	}

}
