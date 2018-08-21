package com.speruri.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.speruri.spring.model.ComponentClass;
import com.speruri.spring.service.CustomerService;
import com.speruri.spring.service.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class AppWithJavaConfig {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
		System.out.println("Results we got is ");
		customerService.findAll().forEach(System.out::println);
		System.out.println("Db user name  " + ((CustomerServiceImpl) customerService).getDbUserName());

		System.out.println(customerService);

		ComponentClass componentClass = applicationContext.getBean(ComponentClass.class);
		componentClass.print();
		ComponentClass componentClass1 = applicationContext.getBean(ComponentClass.class);
		componentClass1.print();
		System.out.println(componentClass);
		System.out.println(componentClass1);
	}
}
