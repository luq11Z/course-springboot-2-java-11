package com.lucaslearning.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaslearning.course.entities.Product;
import com.lucaslearning.course.repositories.ProductRepository;

/* component registration, quando um objeto vai poder ser injetavel pelo mecanismo de injecao
 * de dependencia do spring, a classe desse objeto tem que estar registada no mecanismo de injecao
 * de dependencia.
 * Service por causa da semantica.
 * */
@Service
public class ProductService {
	
	//injecao de dependencia do ProductRepository
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id); //essa operacao retorna um obj do tipo Optional
		return obj.get(); //retorna o obj do tipo Product dentro do Optional
	}

}
