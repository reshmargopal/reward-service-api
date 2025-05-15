package com.rewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.model.Customer;
import com.rewards.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/saveCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
}
