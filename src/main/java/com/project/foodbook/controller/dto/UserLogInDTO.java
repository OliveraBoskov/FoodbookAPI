package com.project.foodbook.controller.dto;

public class UserLogInDTO {
	
	private String username;
	private String email;
	private String role;
	private String jwt;
	public UserLogInDTO(String username, String email, String role, String jwt) {
		super();
		this.username = username;
		this.email = email;
		this.role = role;
		this.jwt = jwt;
	}
	public UserLogInDTO() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	

}
