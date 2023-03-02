/**
 * 
 */
package com.ticketbookingsystem.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ticketbookingsystem.exceptions.TicketNotFoundException;
import com.ticketbookingsystem.model.Ticket;
import com.ticketbookingsystem.service.TicketServices;

import jakarta.validation.Valid;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName TicketController.java
 * @Description
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketServices ticketServices;

	/*
	 * @GetMapping("/getAllTicketsWithHateoas") private CollectionModel<Ticket>
	 * getAllTicketsWithHateoas() { // TODO Auto-generated method stub List<Ticket>
	 * tickets = ticketServices.getTickets(); tickets.forEach(ticket -> { Link
	 * withSelfRel =
	 * linkTo(methodOn(TicketController.class).getTicketById(ticket.getTicketId())).
	 * withSelfRel(); ticket.add(withSelfRel); }); return
	 * CollectionModel.of(tickets); }
	 */

	@GetMapping("/getAllTickets")
	private List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketServices.getTickets();
	}

	@GetMapping("/getAllFilteredDataTickets")
	private MappingJacksonValue getAllFilteredDataTickets() {
		// TODO Auto-generated method stub
		List<Ticket> tickets = ticketServices.getTickets();

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(tickets);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("ticketName", "budgetInCrores",
				"boxOfficeCollectionInCrores");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("ticketBeanFilters", filter);
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;
	}

	@GetMapping("/getTicketById")
	private Optional<Ticket> getTicketById(@RequestParam int ticketId) {
		// TODO Auto-generated method stub
		Optional<Ticket> ticket = ticketServices.getTicketById(ticketId);

		if (ticket.isEmpty())
			throw new TicketNotFoundException("Ticket with ID:" + ticketId + " does not exist.");

		return ticket;

	}

	@GetMapping("/getTicketByIdPathVar/{ticketId}")
	private Optional<Ticket> getTicketByIdPathVar(@PathVariable int ticketId) {
		// TODO Auto-generated method stub
		Optional<Ticket> ticket = ticketServices.getTicketById(ticketId);

		if (ticket.isEmpty())
			throw new TicketNotFoundException("Ticket with ID:" + ticketId + " does not exist.");

		return ticket;
	}

	@PostMapping("/saveTicket")
	private ResponseEntity<Ticket> saveTicket(@Valid @RequestBody Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket savedTicket = ticketServices.saveTicket(ticket);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTicket.getTicketId()).toUri();
		return ResponseEntity.created(location).build();
		// ticketServices.saveTicket(ticket);
	}

	@PostMapping("/saveAllTickets")
	private ResponseEntity<List<Ticket>> saveAllTickets(@RequestBody List<Ticket> ticket) {
		// TODO Auto-generated method stub
		List<Ticket> savedTicket = ticketServices.saveTicketAll(ticket);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTicket)
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/updateTicket")
	private void updateTicket(@RequestBody Ticket ticket) {
		// TODO Auto-generated method stub
		Optional<Ticket> existingTicket = ticketServices.getTicketById(ticket.getTicketId());
		if (existingTicket.isEmpty())
			throw new TicketNotFoundException("Ticket with ID:" + ticket.getTicketId() + " does not exist.");

		ticketServices.saveTicket(ticket);
	}

	@DeleteMapping("/deleteTicket")
	private void deleteTicket(@RequestBody Ticket ticket) {
		// TODO Auto-generated method stub
		Optional<Ticket> existingTicket = ticketServices.getTicketById(ticket.getTicketId());
		if (existingTicket.isEmpty())
			throw new TicketNotFoundException("Ticket with ID:" + ticket.getTicketId() + " does not exist.");
		ticketServices.deleteTicket(ticket);
	}

	@DeleteMapping("/deleteTicketById")
	private void deleteTicket(@RequestParam int ticketId) {
		// TODO Auto-generated method stub
		Optional<Ticket> existingTicket = ticketServices.getTicketById(ticketId);
		if (existingTicket.isEmpty())
			throw new TicketNotFoundException("Ticket with ID:" + ticketId + " does not exist.");
		ticketServices.deleteTicketById(ticketId);
	}

}
