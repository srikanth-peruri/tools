package com.speruri.latest.algorithms.java.practice;

public class Animal {

	private int id;
	private String gender;
	private String type;
	private int foodQuantityPerday;

	public Animal(int id, String gender, String type, int foodQuantityPerday) {
		super();
		this.id = id;
		this.gender = gender;
		this.type = type;
		this.foodQuantityPerday = foodQuantityPerday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFoodQuantityPerday() {
		return foodQuantityPerday;
	}

	public void setFoodQuantityPerday(int foodQuantityPerday) {
		this.foodQuantityPerday = foodQuantityPerday;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", gender=" + gender + ", type=" + type + ", foodQuantityPerday="
				+ foodQuantityPerday + "]";
	}

}
