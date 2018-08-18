package com.speruri.spring.main;

import com.speruri.spring.service.CustomerService;
import com.speruri.spring.service.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		CustomerService customerService = new CustomerServiceImpl();
		System.out.println("Results we got is ");
		customerService.findAll().forEach(System.out::println);

	}
}
