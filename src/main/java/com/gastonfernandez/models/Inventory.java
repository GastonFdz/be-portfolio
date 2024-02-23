package com.gastonfernandez.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "inventories")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "last_update_date")
	private LocalDate lastUpdateDate;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "unit_value")
	private Double unitValue;

	@ManyToOne
	@JoinColumn(name = "description_article")
	private Product product;

	public Inventory() {
	}

	public Inventory(Long id, LocalDate date, LocalDate lastUpdateDate, Integer quantity, Double unitValue,
			Product product) {
		this.id = id;
		this.date = date;
		this.lastUpdateDate = lastUpdateDate;
		this.quantity = quantity;
		this.unitValue = unitValue;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDate lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(Double unitValue) {
		this.unitValue = unitValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
