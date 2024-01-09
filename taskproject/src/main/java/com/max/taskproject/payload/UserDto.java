package com.max.taskproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import lombok.Setter;


public class UserDto {
	
	
	
	@Override
	public String toString() {
		return "UserDto [Id=" + Id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private long Id;
	private String name;
	private String email;
	private String password;
	
}
