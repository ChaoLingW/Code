package com.hpe.java3;

public abstract class Animal {

	private int age;
	private String sex;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public abstract void shout();
	
	
	
	
}
