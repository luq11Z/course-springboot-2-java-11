package com.lucaslearning.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaslearning.course.entities.Order;
import com.lucaslearning.course.repositories.OrderRepository;

/* component registration, quando um objeto vai poder ser injetavel pelo mecanismo de injecao
 * de dependencia do spring, a classe desse objeto tem que estar registada no mecanismo de injecao
 * de dependencia.
 * Service por causa da semantica.
 * */
@Service
public class OrderService {
	
	//injecao de dependencia do OrderRepository
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id); //essa operacao retorna um obj do tipo Optional
		return obj.get(); //retorna o obj do tipo Order dentro do Optional
	}

}
