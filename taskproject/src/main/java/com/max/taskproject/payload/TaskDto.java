package com.max.taskproject.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class TaskDto {
	

@Override
	public String toString() {
		return "TaskDto [id=" + id + ", taskname=" + taskname + "]";
	}
public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
private long id;
private String taskname;
}
