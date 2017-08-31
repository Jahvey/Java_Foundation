package com.wh.invoke;

public class User {
	private String name;
	private int age;
	private String place;
	public User(String name, int age, String place) {
		super();
		this.name = name;
		this.age = age;
		this.place = place;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", place=" + place + "]";
	}
	

}
