package com.project.foodbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodbook.domain.Recept;
import com.project.foodbook.repository.ReceptRepository;

@Service
public class ReceptService {

	
	@Autowired
	private ReceptRepository receptRepository;
	
	public Recept createRecept(String name, String description, String createdBy){
		Recept recept = new Recept(name, description, createdBy);
		
		return receptRepository.save(recept); //ako ne uspe vratice null
	}
	
	public List<Recept> getAll(){
		return receptRepository.findAll();
	}
	
	public Recept getSingleRecept(Long id){
		Recept recept = receptRepository.findOneById(id);
		return recept;
	}
	
	public Recept deleteRecept(Long id) {
		Recept recept = receptRepository.findOneById(id);
		receptRepository.delete(recept);
		return recept;
	}
	
	public Recept editRecept(Long id, String name, String description, String createdBy){
		Recept recept = receptRepository.findOneById(id);
		recept.setName(name);
		recept.setDescription(description);
		recept.setCreatedBy(createdBy);
		
		
		return receptRepository.save(recept);
		
	}
}
