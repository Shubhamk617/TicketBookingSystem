package com.ticketbookingsystem.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_Id")
	private int ticketId;

	@Column(name = "ticket_price", nullable = false)
	@Positive
	private int ticketPrice;

	@Column(name = "movie_timings")
	private String movieTimings;

	@Column(name = "total_Number_Of_Seats", nullable = false)
	@Positive
	private int totalNumberOfSeats;

	// @ElementCollection
	// @CollectionTable(name = "ticket_seatNumber", joinColumns = @JoinColumn(name =
	// "ticket_Id"))
	@Column(name = "seat_Number")
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "ticket_seat")
	private List<Seat> seats;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticket_movie_Id", referencedColumnName = "movie_Id")
	@JsonBackReference(value = "movie_ticket")
	private Movie movie;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(@Positive int ticketPrice, String movieTimings, @Positive int totalNumberOfSeats, List<Seat> seats,
			Movie movie) {
		super();
		this.ticketPrice = ticketPrice;
		this.movieTimings = movieTimings;
		this.totalNumberOfSeats = totalNumberOfSeats;
		this.seats = seats;
		this.movie = movie;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getMovieTimings() {
		return movieTimings;
	}

	public void setMovieTimings(String movieTimings) {
		this.movieTimings = movieTimings;
	}

	public int getTotalNumberOfSeats() {
		return totalNumberOfSeats;
	}

	public void setTotalNumberOfSeats(int totalNumberOfSeats) {
		this.totalNumberOfSeats = totalNumberOfSeats;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
