package com.hpe.java;
/**
 * 
 * @author chaoling
 * @date 2018年7月16日上午9:38:12
 * @Description
 */
public class Person {
	
	//属性私有化private
	
	//this关键字
	//1.this.属性名
	//2.this.方法名
	//3.this(..)，在一个构造器中来调用本类中其他的构造器，只能在第一行出现最多有总个数减一个
	private int age;
	private String sex;
	private String name;
	
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Person(int age, String sex, String name) {
		
		this.age = age;
		this.sex = sex;
		this.name = name;
	}
	
	public Person(int age, String sex) {
		
		super();
		this.age = age;
		this.sex = sex;
	}

	public Person() {
		System.out.println("无参构造函数");
	}
	
	//学习
	public void study(){
		
		System.out.println("studying...");
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", sex=" + sex + ", name=" + name + "]";
	}
	
}
