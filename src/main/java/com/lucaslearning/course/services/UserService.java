package com.lucaslearning.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lucaslearning.course.entities.User;
import com.lucaslearning.course.repositories.UserRepository;
import com.lucaslearning.course.services.exceptions.DatabaseException;
import com.lucaslearning.course.services.exceptions.ResourceNotFoundException;

/* component registration, quando um objeto vai poder ser injetavel pelo mecanismo de injecao
 * de dependencia do spring, a classe desse objeto tem que estar registada no mecanismo de injecao
 * de dependencia.
 * Service por causa da semantica.
 * */
@Service
public class UserService {

	// injecao de dependencia do UserRepository
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); // essa operacao retorna um obj do tipo Optional
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // retorna o obj do tipo User dentro do
																			// Optional
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		try {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	// atualiza o entity com base no obj
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
