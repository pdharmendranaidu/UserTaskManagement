package com.max.taskproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.max.taskproject.payload.UserDto;
import com.max.taskproject.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
	}

}
