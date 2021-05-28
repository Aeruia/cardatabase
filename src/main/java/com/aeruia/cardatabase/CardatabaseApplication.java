package com.aeruia.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.aeruia.cardatabase.domain.Car;
import com.aeruia.cardatabase.domain.CarRepository;
import com.aeruia.cardatabase.domain.Owner;
import com.aeruia.cardatabase.domain.OwnerRepository;
import com.aeruia.cardatabase.domain.User;
import com.aeruia.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {

	
	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean

	CommandLineRunner runner() {
		return args -> {
			// Add owner objects and save to db
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Yoyo");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			// Save demo data to database
			Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			repository.save(car1);
			Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			repository.save(car2);
			Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			repository.save(car3);

			// username: user, password; user
			userRepository
					.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));

			// username: admin, password; admin
			userRepository
					.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
		};
	}
}
