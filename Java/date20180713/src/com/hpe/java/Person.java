package com.hpe.java;

/**
 * 
 * @author chaoling
 * @date 2018年7月13日上午8:50:31
 * @Description
 */
public class Person {

	//属性私有化
	private int age;
	private String name;
	private String sex;
	
	//构造函数
	public Person(){
		
		System.out.println("自定义的无参构造函数");
		
		this.age = 1;
		
	}
	
	//有参构造函数
	//this:代表当前对象，谁调用方法，那么this就是谁
	public Person(int age, String name, String sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}
	
	public Person(int age) {
		super();
		this.age = age;
	}

	//公共的getXXX和setXXX方法
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
	
	//创建类，添加类的成员的步骤
	//1.创建类
	//2.添加private属性
	//3.提供public的get/set方法
	//4.构造器 写了有参构造器后，添加无参构造器
	
}
