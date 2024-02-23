package com.gastonfernandez.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "payment_methods")
public class PaymentMethod {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "payment_method")
    private String paymentMethod;
    
    @OneToMany(mappedBy = "paymentMethod")
    private List<Shopping> shoppings;

	public PaymentMethod() {
	}

	public PaymentMethod(Long id, String paymentMethod, List<Shopping> shoppings) {
		this.id = id;
		this.paymentMethod = paymentMethod;
		this.shoppings = shoppings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<Shopping> getShoppings() {
		return shoppings;
	}

	public void setShoppings(List<Shopping> shoppings) {
		this.shoppings = shoppings;
	}	
    
	
    
}
