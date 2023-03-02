/**
 * 
 */
package com.ticketbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbookingsystem.dao.CustomerRepository;
import com.ticketbookingsystem.model.Customer;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName CustomerServicesImpl.java
 * @Description
 */
@Service
public class CustomerServicesImpl implements CustomerServices {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);

	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.delete(customer);

	}

	@Override
	public void deleteCustomerById(int customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerId);
	}

	@Override
	public List<Customer> saveCustomerAll(List<Customer> customer) {
		// TODO Auto-generated method stub
		return customerRepository.saveAll(customer);
	}

}
