package com.project.foodbook.controller.dto;

public class DeleteDTO {
	private Long id;

	public DeleteDTO(Long id) {
		super();
		this.id = id;
	}

	public DeleteDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
