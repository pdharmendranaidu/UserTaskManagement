package com.max.taskproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.max.taskproject.entity.Users;
import com.max.taskproject.payload.UserDto;
import com.max.taskproject.repository.UserRepository;
import com.max.taskproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		

		Users users = userDtoToEntity(userDto);
		Users userSaved = userRepository.save(users);

		return entityToUserDto(userSaved);

	}

	private UserDto entityToUserDto(Users userSaved) {
		UserDto userDto = new UserDto();
		userDto.setName(userSaved.getName());
		userDto.setEmail(userSaved.getEmail());
		userDto.setPassword(userSaved.getPassword());
		return userDto;
	}

	private Users userDtoToEntity(UserDto userDto) {
		// TODO Auto-generated method stub

		Users users = new Users();
		users.setId(userDto.getId());
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		return users;
	}

}
