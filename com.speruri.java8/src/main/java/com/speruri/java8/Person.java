package com.speruri.java8;

public class Person {

	private int age;
	private String name;

	public Person(int argAge, String argName) {
		super();
		this.age = argAge;
		this.name = argName;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int argAge) {
		this.age = argAge;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

	@Override
	public String toString() {
		return "Person [age=" + this.age + ", name=" + this.name + "]";
	}

	public static int comparePersonAges(Person p1, Person p2) {
		Integer age = p1.getAge();
		return age.compareTo(p2.getAge());
	}

}
