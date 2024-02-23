package com.gastonfernandez.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account")
	private String account;

	@OneToMany(mappedBy = "account")
	private List<Shopping> shoppings;

	public Account() {
	}

	public Account(Long id, String account, List<Shopping> shoppings) {
		this.id = id;
		this.account = account;
		this.shoppings = shoppings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<Shopping> getShoppings() {
		return shoppings;
	}

	public void setShoppings(List<Shopping> shoppings) {
		this.shoppings = shoppings;
	}

}
