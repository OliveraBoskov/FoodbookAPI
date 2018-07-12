package com.project.foodbook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodbook.controller.dto.LogInDTO;
import com.project.foodbook.controller.dto.ReceptDTO;
import com.project.foodbook.controller.dto.ResponseMessageDTO;
import com.project.foodbook.controller.dto.UserDTO;
import com.project.foodbook.controller.dto.UserLogInDTO;
import com.project.foodbook.domain.Recept;
import com.project.foodbook.domain.User;
import com.project.foodbook.security.TokenProvider;
import com.project.foodbook.security.UserDetailsServiceImpl;
import com.project.foodbook.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenProvider tokenProvider;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
		User user = userService.addUser(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()), 
				userDTO.getEmail(), userDTO.getRole());
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/logIn")
	public ResponseEntity<UserLogInDTO> logIn(@RequestBody LogInDTO logInDTO) {
		UserDetails details = userDetailsServiceImpl.loadUserByUsername(logInDTO.getUsername());
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				logInDTO.getUsername(), logInDTO.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken(details);
		User u = userService.getUserByUsername(details.getUsername());
		UserLogInDTO response = new UserLogInDTO();
		response.setUsername(u.getUsername());
		response.setEmail(u.getEmail());
		response.setRole(u.getRole());
		response.setJwt(jwt);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
//	@PostMapping("/logIn")
//	public ResponseDTO logIn(@RequestBody LogInDTO logInDTO){
//		UserDetails details = userDetailsServiceImpl.loadUserByUsername(logInDTO.getUsername());
//		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//				logInDTO.getUsername(), logInDTO.getPassword());
//		
//		Authentication authentication = authenticationManager.authenticate(authenticationToken);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		String jwt = tokenProvider.generateToken(details);
//		
//		return new ResponseDTO(jwt, null);
//}
	
//	@PostMapping("")
//	public ResponseEntity<Recept> createRecept(@RequestBody ReceptDTO receptDTO) {
//		Recept recept = receptService.createRecept(receptDTO.getName(), receptDTO.getDescription(), 
//				receptDTO.getCreatedBy());
//		
//		return new ResponseEntity<>(recept, HttpStatus.CREATED);
//	}
	

}
