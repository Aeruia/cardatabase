package com.aeruia.cardatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ownerId;
	private String firstName, lastName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@JsonIgnore
	private List<Car> cars;

	/**
	 * @return the cars
	 */
	public List<Car> getCars() {
		return cars;
	}

	/**
	 * @param cars the cars to set
	 */
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Owner() {
	}

	/**
	 * @return the ownerId
	 */
	public long getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerid the ownerId to set
	 */
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstname the firstName to set
	 */
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastname the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Owner(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
