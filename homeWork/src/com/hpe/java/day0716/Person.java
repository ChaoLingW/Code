package com.hpe.java.day0716;
/**
 * 
 * @author chaoling
 * @date 2018年7月16日下午7:29:56
 * @Description
 */
public class Person {
	
	private String name;	//姓名
	private int age;		//年龄
	private String sex;		//性别
	
	
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	//无参构造函数
	public Person() {
		super();
	}
	//有参构造函数
	public Person(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	//输出属性值
	public void showInfo() {
		System.out.println("Person [name=" + this.getName() + ", age=" + this.getAge() + ", sex=" + this.getSex() + "]");
	}
	
	
	
	
	
	
	

}
