/**
 * 
 */
package com.ticketbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ticketbookingsystem.model.Customer;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName CustomerServices.java
 * @Description
 */
@Service
public interface CustomerServices {

	public Customer saveCustomer(Customer customer);

	public List<Customer> saveCustomerAll(List<Customer> customer);

	public List<Customer> getCustomers();

	public Optional<Customer> getCustomerById(int customerId);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

	public void deleteCustomerById(int customerId);

}
