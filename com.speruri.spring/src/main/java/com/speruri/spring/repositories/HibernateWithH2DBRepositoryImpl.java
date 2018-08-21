package com.speruri.spring.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.speruri.spring.model.Customer;

@Repository
public class HibernateWithH2DBRepositoryImpl {

//	@Override
	public List<Customer> findAll() {
		System.out.println("Getting the results from the H2 DB");
		Customer customer = new Customer();
		customer.setFirstName("H2DB");
		customer.setLastName("In memory Data base");
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		return customers;
	}

}
