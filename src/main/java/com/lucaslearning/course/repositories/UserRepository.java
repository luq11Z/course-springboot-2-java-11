package com.lucaslearning.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslearning.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
