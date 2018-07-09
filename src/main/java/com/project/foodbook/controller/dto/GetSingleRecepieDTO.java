package com.project.foodbook.controller.dto;

public class GetSingleRecepieDTO {
	
	private Long id;
	private String name;
	private String description;
	private String createdBy;
	
	public GetSingleRecepieDTO(Long id, String name, String description, String createdBy) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
	}
	public GetSingleRecepieDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	

}
