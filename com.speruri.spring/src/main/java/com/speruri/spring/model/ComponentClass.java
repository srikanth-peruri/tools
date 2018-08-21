package com.speruri.spring.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")

public class ComponentClass {

	public void print() {
		System.out.println("This is Component");
	}

}
