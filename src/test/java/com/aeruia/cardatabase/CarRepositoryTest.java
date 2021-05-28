package com.aeruia.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.aeruia.cardatabase.domain.CarRepository;
import com.aeruia.cardatabase.domain.Owner;
import com.aeruia.cardatabase.domain.OwnerRepository;
import com.aeruia.cardatabase.domain.Car;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Test
	public void saveCar() {
		Owner owner1 = new Owner("John", "Johnson");
		ownerRepository.save(owner1);
		Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000, owner1);
		entityManager.persistAndFlush(car);
		
		assertThat(car.getId()).isNotNull();
	}
	
	@Test
	public void deleteCars() {

		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Yoyo");
		ownerRepository.save(owner1);
		ownerRepository.save(owner2);
		entityManager.persistAndFlush(new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000, owner1));
		entityManager.persistAndFlush(new Car("Mini", "Cooper", "Red", "DEF-5678", 2020, 24500, owner2));
		
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	}
    
}
