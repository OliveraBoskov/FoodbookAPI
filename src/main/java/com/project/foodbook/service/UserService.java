package com.project.foodbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodbook.domain.User;
import com.project.foodbook.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(String username, String password, String email, String role) {
		User user = new User(username, password, email, role);
		
		return userRepository.save(user); //ako ne uspe vratice null
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
