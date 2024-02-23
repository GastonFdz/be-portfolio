package com.gastonfernandez.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "businesses")
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "business")
	private String business;

	@OneToMany(mappedBy = "business")
	private List<Shopping> shoppings;

	public Business() {

	}

	public Business(Long id, String business, List<Shopping> shoppings) {
		this.id = id;
		this.business = business;
		this.shoppings = shoppings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public List<Shopping> getShoppings() {
		return shoppings;
	}

	public void setShoppings(List<Shopping> shoppings) {
		this.shoppings = shoppings;
	}
	
	
}
