package com.hpe.java;

public class Person {
	
	public String name;
	public int age;
	public String sex;

	public Person(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Person() {
		super();
	}

	public void study() {
		System.out.println("studying");
	}

	public void showAge() {
		System.out.println("age=" + this.age);
	}

	public void addAge(int i) {
		this.age += i;
	}

}
