package com.speruri.spring.repositories;

import java.util.List;

import com.speruri.spring.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}