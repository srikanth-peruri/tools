package com.speruri.spring.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.speruri.spring.model.Customer;

@Repository("customerRepository")
public class HardCodedCustomerRepositoryImpl implements CustomerRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.speruri.spring.repositories.CustomerRepository#findAll()
	 */
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();

		Customer cust1 = new Customer();
		cust1.setFirstName("Srikanth");
		cust1.setLastName("Peruri");

		Customer cust2 = new Customer();
		cust2.setFirstName("Jyothi");
		cust2.setLastName("Peruri");

		Customer cust3 = new Customer();
		cust3.setFirstName("Rishika");
		cust3.setLastName("Peruri");

		customers.add(cust1);
		customers.add(cust2);
		customers.add(cust3);

		return customers;
	}
}
