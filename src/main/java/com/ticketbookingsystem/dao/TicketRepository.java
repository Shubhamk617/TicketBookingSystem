/**
 * 
 */
package com.ticketbookingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbookingsystem.model.Ticket;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName MovieRepository.java
 * @Description
 */

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	List<Ticket> findAllByMovieId(int movieId);

}
