package com.hpe.java.day0713;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午7:43:16
 * @Description
 */
/*
(1)定义Person类,有4个属性：String name; int age; String school; String major，
(2)定义Person类的3个构造方法:
		第一个构造方法Person(String n, int a)设置类的name和age属性；
		第二个构造方法Person(String n, int a, String s)设置类的name,   
        age 和school属性；
		第三个构造方法Person(String n, int a, String s, String m)设置类的name, age ,school和major属性；
(3)在main方法中分别调用不同的构造方法创建的对象，并输出其属性值
*/

public class PersonHomework9 {
	
	private String name; 
	private int age; 
	private String school; 
	private String major;
	
	public PersonHomework9(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public PersonHomework9(String name, int age, String school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}

	public PersonHomework9(String name, int age, String school, String major) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
		this.major = major;
	}

	public PersonHomework9() {
		super();
	}

	public void show() {
		System.out.println("name=" + name + ", age=" + age + ", school=" + school + ", major=" + major);
	}
	
	

}
