package com.gastonfernandez.models;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "shoppings")
public class Shopping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "refund")
	private Double refund;

	@Column(name = "unit_price_kilo")
	private Double unitPriceKilo;

	@Column(name = "weighing")
	private Double weighing;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	@ManyToOne
	@JoinColumn(name = "commerce_id")
	private Business business;

	@ManyToOne
	@JoinColumn(name = "payment_method_id")
	private PaymentMethod paymentMethod;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Shopping() {
	}

	public Shopping(Long id, LocalDate date, Integer quantity, Double refund, Double unitPriceKilo, Double weighing,
			Account account, Business business, PaymentMethod paymentMethod, Product product) {
		this.id = id;
		this.date = date;
		this.quantity = quantity;
		this.refund = refund;
		this.unitPriceKilo = unitPriceKilo;
		this.weighing = weighing;
		this.account = account;
		this.business = business;
		this.paymentMethod = paymentMethod;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getRefund() {
		return refund;
	}

	public void setRefund(Double refund) {
		this.refund = refund;
	}

	public Double getUnitPriceKilo() {
		return unitPriceKilo;
	}

	public void setUnitPriceKilo(Double unitPriceKilo) {
		this.unitPriceKilo = unitPriceKilo;
	}

	public Double getWeighing() {
		return weighing;
	}

	public void setWeighing(Double weighing) {
		this.weighing = weighing;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
