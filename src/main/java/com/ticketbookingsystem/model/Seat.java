package com.ticketbookingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Seat")
public class Seat {

	@Id
	@Column(name = "seat_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatId;

	@Column(name = "seat_Number")
	private String seatNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seat_ticket_Id", referencedColumnName = "ticket_Id")
	@JsonBackReference(value = "ticket_seat")
	private Ticket ticket;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seat_cust_id", referencedColumnName = "cust_id")
	@JsonManagedReference(value = "customer_seat")
	private Customer customer;

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(String seatNumber, Ticket ticket) {
		super();
		this.seatNumber = seatNumber;
		this.ticket = ticket;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
