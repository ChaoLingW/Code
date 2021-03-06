package com.hpe.java4;

/**
 * 
 * @author chaoling
 * @date 2018年7月16日下午7:33:14
 * @Description
 */
public class Student extends Person{
	
	private String number;	//学号

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student(String number) {
		super();
		this.number = number;
	}

	public Student(String name, int age, String sex, String number) {
		super(name, age, sex);
		this.number = number;
	}

	public Student() {
		super();
	}

	public Student(String name, int age, String sex) {
		super(name, age, sex);
	}

	@Override
	public void showInfo() {
		System.out.println("Student [name=" + this.getName() + ", age=" + this.getAge() + ", sex=" + this.getSex() + ", number=" + this.getNumber() + "]");
	}
	
	

}
