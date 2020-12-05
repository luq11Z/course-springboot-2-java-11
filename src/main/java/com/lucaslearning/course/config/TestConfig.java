package com.lucaslearning.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucaslearning.course.entities.User;
import com.lucaslearning.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	//injetar dependencia
	@Autowired
	private UserRepository userRepository;
	
	//instanciar objetos quando o programa for executado, dai o CammandLineRunner
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		User u3 = new User(null, "Lucas Silva", "lucas@gmail.com", "999999999", "123456");
		User u4 = new User(null, "Nelio Alves", "nelio@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
	}
	
}
