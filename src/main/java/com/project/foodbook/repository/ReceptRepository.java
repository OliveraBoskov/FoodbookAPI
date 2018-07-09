package com.project.foodbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.foodbook.domain.Recept;

@Repository
public interface ReceptRepository extends JpaRepository<Recept, Long> {
	
	Recept findOneById(Long id);

}
