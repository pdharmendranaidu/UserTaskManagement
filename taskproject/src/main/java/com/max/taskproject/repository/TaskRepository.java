package com.max.taskproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.max.taskproject.entity.Task;

public interface TaskRepository  extends JpaRepository<Task, Long>{

	List<Task> findAllByUsersId(long userId);

	//List<Task> findAllByUsersId(long userId);

}
