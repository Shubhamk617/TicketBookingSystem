/**
 * 
 */
package com.ticketbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ticketbookingsystem.model.Ticket;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName TicketServices.java
 * @Description
 */
@Service
public interface TicketServices {

	public Ticket saveTicket(Ticket ticket);

	public List<Ticket> saveTicketAll(List<Ticket> ticket);

	public List<Ticket> getTickets();

	public Optional<Ticket> getTicketById(int ticketId);

	public void updateTicket(Ticket ticket);

	public void deleteTicket(Ticket ticket);

	public void deleteTicketById(int ticketId);

	public List<Ticket> getTicketsByMovieId(int movieId);

}
