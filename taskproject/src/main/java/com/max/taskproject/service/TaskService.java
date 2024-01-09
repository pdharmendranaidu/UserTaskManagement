package com.max.taskproject.service;

import java.util.List;

import com.max.taskproject.payload.TaskDto;

public interface TaskService {

	public TaskDto saveTask(long userId, TaskDto taskDto);

	public List<TaskDto> getAllTasks(long userId);

	public TaskDto getByTask(long userId, long taskId);

	public void deleteTask(long userId, long taskId);

}
