package com.project.foodbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.foodbook.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findOneByUsername(String username);

}
