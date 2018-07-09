package com.project.foodbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="Recepti")
public class Recept {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(unique = true, name= "Ime")
	private String name;
	
	@NotNull
	@Size(max=300)
	private String description;
	
	@NotNull
	private String createdBy;

	public Recept() {
		super();
	}
	
	

	public Recept(@NotNull String name, @NotNull @Size(max = 300) String description, @NotNull String createdBy) {
		super();
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
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
