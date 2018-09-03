package com.speruri.latest.algorithms.sorting;

public class Student implements Comparable<Student> {

	private int rollNumber;
	private String name;
	private String place;

	public Student(int rollNumber, String name, String place) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.place = place;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", place=" + place + "]";
	}

	public int compareTo(Student o) {
		return this.name.compareTo(o.getName());
	}

}
