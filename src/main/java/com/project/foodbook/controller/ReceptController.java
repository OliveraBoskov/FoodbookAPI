package com.project.foodbook.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodbook.controller.dto.GetRecepiesDTO;
import com.project.foodbook.controller.dto.GetSingleRecepieDTO;
import com.project.foodbook.controller.dto.ReceptDTO;
import com.project.foodbook.controller.dto.ResponseMessageDTO;
import com.project.foodbook.domain.Recept;
import com.project.foodbook.security.SecurityUtils;
import com.project.foodbook.service.MailService;
import com.project.foodbook.service.ReceptService;
import com.project.foodbook.service.UserService;

@RestController
@RequestMapping("/api/recepti")
public class ReceptController {

	@Autowired
	private ReceptService receptService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private SecurityUtils securityUtils;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public ResponseEntity<Recept> createRecept(@RequestBody ReceptDTO receptDTO) throws MessagingException {
		String username = securityUtils.getCurrentUserLoginByUsername().get();
		Recept recept = receptService.createRecept(receptDTO.getName(), receptDTO.getDescription(), 
				username);
		System.out.println(securityUtils.getCurrentUserLoginByUsername().get()); //daje username
		mailService.sendRecepieToAll(userService.getAllUsers(), recept);
		return new ResponseEntity<>(recept, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<GetRecepiesDTO> getAllRecepies(){
		List<Recept> tempList = receptService.getAll();
		System.out.println(securityUtils.getCurrentUserLoginByUsername().get());
		return new ResponseEntity<>(new GetRecepiesDTO(tempList, "uspesno"), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GetSingleRecepieDTO> getSingleRecepie(@PathVariable("id") Long id) {
		Recept recept = receptService.getSingleRecept(id);
		System.out.println(securityUtils.getCurrentUserLoginByUsername().get());
		return new ResponseEntity<>(new GetSingleRecepieDTO(recept.getId(), recept.getName(),
				recept.getDescription(), recept.getCreatedBy()), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessageDTO> deleteRecept(@PathVariable("id") Long id){
		Recept recept = receptService.deleteRecept(id);
		System.out.println(securityUtils.getCurrentUserLoginByUsername().get());
		if(recept == null){
			return new ResponseEntity<>(new ResponseMessageDTO("Neuspesno brisanje"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ResponseMessageDTO("Uspesno ste obrisali recept"), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessageDTO> editRecepie(@PathVariable("id") Long id, @RequestBody ReceptDTO receptDTO){
		Recept recept = receptService.editRecept(id, receptDTO.getName(), receptDTO.getDescription(), 
				receptDTO.getCreatedBy());
		System.out.println(securityUtils.getCurrentUserLoginByUsername().get());
		if(recept == null){
			return new ResponseEntity<>(new ResponseMessageDTO("Neuspesna izmena recepta"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ResponseMessageDTO("Uspesno ste izmenili podatke recepta"), HttpStatus.OK);
	}

	
	
}
