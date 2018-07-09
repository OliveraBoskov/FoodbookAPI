package com.project.foodbook.controller.dto;

public class ReceptDTO {
	
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String name;
	private String description;
	private String createdBy;
	public ReceptDTO() {
		super();
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
	public ReceptDTO(String name, String description, String createdBy) {
		super();
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
	}
	
	

}
