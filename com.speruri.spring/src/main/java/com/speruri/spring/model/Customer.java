package com.speruri.spring.model;

public class Customer {

	private String lastName;
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [lastName=" + lastName + ", firstName=" + firstName + "]";
	}

}
