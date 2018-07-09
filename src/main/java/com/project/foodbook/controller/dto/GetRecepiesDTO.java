package com.project.foodbook.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.project.foodbook.domain.Recept;

public class GetRecepiesDTO {
	
	private List<Recept> recepies = new ArrayList<Recept>();
	private String message;
	
	public GetRecepiesDTO(List<Recept> recepies, String message) {
		super();
		this.recepies = recepies;
		this.message = message;
	}

	public GetRecepiesDTO() {
		super();
	}

	public List<Recept> getRecepies() {
		return recepies;
	}

	public void setRecepies(List<Recept> recepies) {
		this.recepies = recepies;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
