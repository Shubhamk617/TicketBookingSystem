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
import com.ticketbookingsystem.exceptions.CustomerNotFoundException;
import com.ticketbookingsystem.model.Customer;
import com.ticketbookingsystem.service.CustomerServices;

import jakarta.validation.Valid;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName CustomerController.java
 * @Description
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServices customerServices;

	/*
	 * @GetMapping("/getAllCustomersWithHateoas") private CollectionModel<Customer>
	 * getAllCustomersWithHateoas() { // TODO Auto-generated method stub
	 * List<Customer> customers = customerServices.getCustomers();
	 * customers.forEach(customer -> { Link withSelfRel =
	 * linkTo(methodOn(CustomerController.class).getCustomerById(customer.
	 * getCustomerId())). withSelfRel(); customer.add(withSelfRel); }); return
	 * CollectionModel.of(customers); }
	 */

	@GetMapping("/getAllCustomers")
	private List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerServices.getCustomers();
	}

	@GetMapping("/getAllFilteredDataCustomers")
	private MappingJacksonValue getAllFilteredDataCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerServices.getCustomers();

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(customers);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("customerName", "budgetInCrores",
				"boxOfficeCollectionInCrores");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("customerBeanFilters", filter);
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;
	}

	@GetMapping("/getCustomerById")
	private Optional<Customer> getCustomerById(@RequestParam int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerServices.getCustomerById(customerId);

		if (customer.isEmpty())
			throw new CustomerNotFoundException("Customer with ID:" + customerId + " does not exist.");

		return customer;

	}

	@GetMapping("/getCustomerByIdPathVar/{customerId}")
	private Optional<Customer> getCustomerByIdPathVar(@PathVariable int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerServices.getCustomerById(customerId);

		if (customer.isEmpty())
			throw new CustomerNotFoundException("Customer with ID:" + customerId + " does not exist.");

		return customer;
	}

	@PostMapping("/saveCustomer")
	private ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		// TODO Auto-generated method stub
		Customer savedCustomer = customerServices.saveCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getCustId()).toUri();
		return ResponseEntity.created(location).build();
		// customerServices.saveCustomer(customer);
	}

	@PostMapping("/saveAllCustomers")
	private ResponseEntity<List<Customer>> saveAllCustomers(@RequestBody List<Customer> customer) {
		// TODO Auto-generated method stub
		List<Customer> savedCustomer = customerServices.saveCustomerAll(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCustomer)
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/updateCustomer")
	private void updateCustomer(@RequestBody Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer> existingCustomer = customerServices.getCustomerById(customer.getCustId());
		if (existingCustomer.isEmpty())
			throw new CustomerNotFoundException("Customer with ID:" + customer.getCustId() + " does not exist.");

		customerServices.saveCustomer(customer);
	}

	@DeleteMapping("/deleteCustomer")
	private void deleteCustomer(@RequestBody Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer> existingCustomer = customerServices.getCustomerById(customer.getCustId());
		if (existingCustomer.isEmpty())
			throw new CustomerNotFoundException("Customer with ID:" + customer.getCustId() + " does not exist.");
		customerServices.deleteCustomer(customer);
	}

	@DeleteMapping("/deleteCustomerById")
	private void deleteCustomer(@RequestParam int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> existingCustomer = customerServices.getCustomerById(customerId);
		if (existingCustomer.isEmpty())
			throw new CustomerNotFoundException("Customer with ID:" + customerId + " does not exist.");
		customerServices.deleteCustomerById(customerId);
	}

}
