package com.gastonfernandez.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "currencies")
public class Currency {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "date")
    private LocalDate date;
    
    @Column(name = "purchase")
    private Double purchase;
    
    @Column(name = "selling")
    private Double selling;

    public Currency() {
    	
    }

	public Currency(Long id, String currency, LocalDate date, Double purchase, Double selling) {
		this.id = id;
		this.currency = currency;
		this.date = date;
		this.purchase = purchase;
		this.selling = selling;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getPurchase() {
		return purchase;
	}

	public void setPurchase(Double purchase) {
		this.purchase = purchase;
	}

	public Double getSelling() {
		return selling;
	}

	public void setSelling(Double selling) {
		this.selling = selling;
	}
    
    
}
