package com.lucaslearning.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslearning.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	
}
