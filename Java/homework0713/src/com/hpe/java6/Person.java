package com.hpe.java6;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午7:24:30
 * @Description
 */
/*定义Person类,
 * 有3个属性：String name; int age; String school; 	
 * 定义Person类的2个构造方法
 * */
public class Person {
	
	private String name;
	private int age;
	private String school;
	
	public Person(String name, int age, String school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}

	public Person() {
		super();
	}
	
}
