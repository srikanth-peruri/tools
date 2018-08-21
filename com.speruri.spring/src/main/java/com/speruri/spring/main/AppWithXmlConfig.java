package com.speruri.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speruri.spring.service.CustomerService;
import com.speruri.spring.service.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class AppWithXmlConfig {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
		System.out.println("Results we got is ");
		customerService.findAll().forEach(System.out::println);
		System.out.println("Db user name  " + ((CustomerServiceImpl) customerService).getDbUserName());

	}
}
