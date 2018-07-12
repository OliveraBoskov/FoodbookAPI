package com.project.foodbook.controller.dto;

public class LogInDTO {
	
	private String username;
	private String password;
	public LogInDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LogInDTO() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
