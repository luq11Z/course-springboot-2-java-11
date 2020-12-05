package com.lucaslearning.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaslearning.course.entities.Category;
import com.lucaslearning.course.repositories.CategoryRepository;

/* component registration, quando um objeto vai poder ser injetavel pelo mecanismo de injecao
 * de dependencia do spring, a classe desse objeto tem que estar registada no mecanismo de injecao
 * de dependencia.
 * Service por causa da semantica.
 * */
@Service
public class CategoryService {
	
	//injecao de dependencia do CategoryRepository
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id); //essa operacao retorna um obj do tipo Optional
		return obj.get(); //retorna o obj do tipo Category dentro do Optional
	}

}
