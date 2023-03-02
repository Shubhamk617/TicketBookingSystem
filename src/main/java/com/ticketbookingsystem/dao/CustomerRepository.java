/**
 * 
 */
package com.ticketbookingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbookingsystem.model.Customer;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName MovieRepository.java
 * @Description
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
