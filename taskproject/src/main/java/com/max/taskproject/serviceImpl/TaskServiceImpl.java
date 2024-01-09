package com.max.taskproject.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.taskproject.entity.Task;
import com.max.taskproject.entity.Users;
import com.max.taskproject.exception.APIException;
import com.max.taskproject.exception.TaskNotFound;
import com.max.taskproject.exception.UserNotFound;
import com.max.taskproject.payload.TaskDto;
import com.max.taskproject.repository.TaskRepository;
import com.max.taskproject.repository.UserRepository;
import com.max.taskproject.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	public ModelMapper modelMapper;
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public TaskRepository taskRepository;

	@Override
	public TaskDto saveTask(long userId, TaskDto taskDto) {

		Users user = userRepository.findById(userId).orElseThrow(()-> new UserNotFound(String.format("user Id %d not presented", userId)));
		Task task=modelMapper.map(taskDto,Task.class);
		task.setUsers(user);
	Task saveTak	=taskRepository.save(task);

		return modelMapper.map(saveTak,TaskDto.class );
	}

	@Override
	public List<TaskDto> getAllTasks(long userId) {
		userRepository.findById(userId).orElseThrow(()-> new UserNotFound(String.format("user Id %d not presented", userId)));
		List<Task> tasks=taskRepository.findAllByUsersId(userId);

		return tasks.stream().map(task-> modelMapper.map(task, TaskDto.class)).collect(Collectors.toList());
	}

	@Override
	public TaskDto getByTask(long userId, long taskId) {
		// TODO Auto-generated method stub
		Users user = userRepository.findById(userId).orElseThrow(()-> new UserNotFound(String.format("user Id %d not presented", userId)));
		Task task = taskRepository.findById(taskId).orElseThrow(()-> new TaskNotFound(String.format("task id %id not presented ", taskId)));
		
		if(user.getId()!=task.getId()) {
			throw new APIException(String.format("task id %d is not belonging to user id %d ::", userId,taskId));
		}
		
		return modelMapper.map(task, TaskDto.class);


}

	@Override
	public void deleteTask(long userId, long taskId) {
		Users user = userRepository.findById(userId).orElseThrow(()-> new UserNotFound(String.format("user Id %d not presented", userId)));
		Task task = taskRepository.findById(taskId).orElseThrow(()-> new TaskNotFound(String.format("task id %id not presented ", taskId)));
		
		if(user.getId()!=task.getId()) {
			throw new APIException(String.format("task id %d is not belonging to user id %d ::", userId,taskId));
		}
		taskRepository.deleteById(taskId);
	}
}