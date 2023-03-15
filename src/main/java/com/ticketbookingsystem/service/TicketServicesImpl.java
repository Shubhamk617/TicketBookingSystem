/**
 * 
 */
package com.ticketbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbookingsystem.dao.TicketRepository;
import com.ticketbookingsystem.model.Ticket;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName TicketServicesImpl.java
 * @Description
 */
@Service
public class TicketServicesImpl implements TicketServices {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public Ticket saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public Optional<Ticket> getTicketById(int ticketId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(ticketId);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketRepository.save(ticket);

	}

	@Override
	public void deleteTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketRepository.delete(ticket);

	}

	@Override
	public void deleteTicketById(int ticketId) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(ticketId);
	}

	@Override
	public List<Ticket> saveTicketAll(List<Ticket> ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.saveAll(ticket);
	}

	@Override
	public List<Ticket> getTicketsByMovieId(int movieId) {
		// TODO Auto-generated method stub
		return ticketRepository.findAllByMovieId(movieId);
	}

}
