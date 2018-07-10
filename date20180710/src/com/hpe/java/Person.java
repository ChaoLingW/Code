package com.hpe.java;
/**
 * 
 * @author chaoling
 * @date 2018年7月10日上午11:14:04
 * @Description
 */
public class Person {
	
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Person() {
		super();
	}
	
	
	
	

}
