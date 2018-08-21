package com.speruri.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.speruri.spring.model.Customer;
import com.speruri.spring.repositories.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Value("${dbUserName}")
	private String dbUserName;

	@Override
	public List<Customer> findAll() {
		return this.customerRepository.findAll();
	}

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("SEtter injection");
		this.customerRepository = customerRepository;
	}

	public String getDbUserName() {
		return dbUserName;
	}
}
