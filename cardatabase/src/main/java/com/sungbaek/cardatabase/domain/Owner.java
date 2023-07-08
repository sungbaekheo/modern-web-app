package com.sungbaek.cardatabase.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ownerId;
	private String firstname, lastname;
	
//	// 일대다일 경우
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private List<Car> cars;
	
	// 다대다일 경우
//	@ManyToMany(cascade=CascadeType.PERSIST)
//	@JoinTable(name="car_owner", joinColumns= {@JoinColumn(name="ownerId")}, inverseJoinColumns= {@JoinColumn(name="`id`")})
//	private Set<Car> cars = new HashSet<Car>();
	
	public Owner() {}

	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	// 일대다일 경우
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	// 다대다일 경우
//	public Set<Car> getCars() {
//		return cars;
//	}
//
//	public void setCars(Set<Car> cars) {
//		this.cars = cars;
//	}
	
}
