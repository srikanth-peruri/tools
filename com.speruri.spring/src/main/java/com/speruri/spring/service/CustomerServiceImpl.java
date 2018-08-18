package com.speruri.spring.service;

import java.util.List;

import com.speruri.spring.model.Customer;
import com.speruri.spring.repositories.CustomerRepository;
import com.speruri.spring.repositories.HardCodedCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {

	CustomerRepository customerRepository = new HardCodedCustomerRepositoryImpl();

	@Override
	public List<Customer> findAll() {
		return this.customerRepository.findAll();
	}

}
