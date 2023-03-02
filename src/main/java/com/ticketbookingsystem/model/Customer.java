package com.ticketbookingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int custId;

	@Column(name = "cust_name")
	private String custName;

	@Column(name = "cust_Age")
	private int custAge;

	@Column(name = "cust_email")
	private String custEmail;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonBackReference(value = "customer_seat")
	private Seat seat;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String custName, int custAge, String custEmail) {
		super();
		this.custName = custName;
		this.custAge = custAge;
		this.custEmail = custEmail;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

}
