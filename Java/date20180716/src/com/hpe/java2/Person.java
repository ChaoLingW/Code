package com.hpe.java2;

//多态：同一种事物的多种形态

//Java中多态主要体现在以下两个方面
//1.方法的重载和方法的重写
//2.对象的多态性：一个对象的多种形态，子类的对象可以代替父类的对象使用
public class Person {

	private int age;//非静态变量、非static变量、实例变量
	
	//static关键字，修饰符
	//1.属性  2.方法  3.类  4.代码块
	
	//修饰属性：静态变量、static变量、类变量
	//
	private static int legs;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static int getLegs() {
		return legs;
	}

	public static void setLegs(int legs) {
		Person.legs = legs;
	}

	public void eat(){
		System.out.println("eating");
	}
	
	
	
}
