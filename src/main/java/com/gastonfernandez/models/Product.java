package com.gastonfernandez.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "product")
    private String product;
    
    @OneToMany(mappedBy = "product")
    private List<Inventory> inventories;
    
    @OneToMany(mappedBy = "product")
    private List<Shopping> shoppings;
    
	public Product() {

	}

	public Product(Long id, String product, List<Inventory> inventories, List<Shopping> shoppings) {
		this.id = id;
		this.product = product;
		this.inventories = inventories;
		this.shoppings = shoppings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public List<Shopping> getShoppings() {
		return shoppings;
	}

	public void setShoppings(List<Shopping> shoppings) {
		this.shoppings = shoppings;
	}

	
}
