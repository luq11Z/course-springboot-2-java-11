package com.lucaslearning.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucaslearning.course.entities.Category;
import com.lucaslearning.course.entities.Order;
import com.lucaslearning.course.entities.User;
import com.lucaslearning.course.entities.enums.OrderStatus;
import com.lucaslearning.course.repositories.CategoryRepository;
import com.lucaslearning.course.repositories.OrderRepository;
import com.lucaslearning.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	//injetar dependencia
	@Autowired
	private CategoryRepository catRepository;
	
	//injetar dependencia
	@Autowired
	private UserRepository userRepository;
	
	//injetar dependencia
	@Autowired
	private OrderRepository OrderRepository;
	
	//instanciar objetos quando o programa for executado, dai o CammandLineRunner
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		User u3 = new User(null, "Lucas Silva", "lucas@gmail.com", "999999999", "123456");
		User u4 = new User(null, "Nelio Alves", "nelio@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u3);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u4);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u3);
		Order o4 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u1);
		Order o5 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u2);
		
		catRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		OrderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
		
	}
	
}
