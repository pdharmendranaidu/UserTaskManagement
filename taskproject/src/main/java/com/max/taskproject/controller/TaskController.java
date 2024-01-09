package com.max.taskproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max.taskproject.payload.TaskDto;
import com.max.taskproject.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	TaskService taskService;

	@PostMapping("/{userId}/task")
	public ResponseEntity<TaskDto> saveTask(@PathVariable(name = "userId") long userId, @RequestBody TaskDto taskDto) {
		return new ResponseEntity<>(taskService.saveTask(userId, taskDto), HttpStatus.CREATED);

	}

	@GetMapping("/{userId}/task")
	public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable(name="userId") long userId){
		return new ResponseEntity<>(taskService.getAllTasks(userId),HttpStatus.OK);
	}

	@GetMapping("/{userId}/task/{taskId}")
public ResponseEntity<TaskDto> getByTask(
		@PathVariable(name="userId") long userId,
        @PathVariable(name="taskId") long taskId		){
			return new ResponseEntity<>(taskService.getByTask(userId, taskId),HttpStatus.OK);
        	
        }
	@DeleteMapping("/{userId}/task/{taskId}")
	public ResponseEntity<String> deleteTask(
			@PathVariable(name="userId") long userId,
	        @PathVariable(name="taskId") long taskId		){
		taskService.deleteTask(userId, taskId);
				return new ResponseEntity<>("delete successfuly",HttpStatus.OK);
	        	
	        }
}
