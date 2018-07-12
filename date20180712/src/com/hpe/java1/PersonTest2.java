package com.hpe.java1;

import org.junit.Test;

public class PersonTest2 {
	
	@Test
	public void test(){
		
		Person p = new  Person();
		
		System.out.println(p);
		
		Person p1 = new Person();
		
		//问题
		System.out.println(p == p1);//false 比较的是地址值
		
		Person p2 = p1;
		p2.age = 10;
		
		System.out.println(p2.age);//10
		System.out.println(p1.age);//10
		System.out.println(p2 == p1); //true
		
		Person p3 = new Person();
		System.out.println(p3.age);//0
		
		p3 = p2;
		System.out.println(p3.age);
	}
	
	@Test
	public void test2(){
		
		Person p = new Person();
		//打印age属性值
		System.out.println(p.age);//0
		//调用changeAge方法，将p作为参数
		changeAge(p);
		//打印age属性值
		System.out.println(p.age);//1
		
	}
	
	//方法：修改Person对象的age属性
	public void changeAge(Person p){
		
		p.age = p.age + 1;
		
	}
	
	//封装
	@Test
	public void test3(){
		
		Person person =  new Person();
		
		//设置age属性值
		person.setAge(-10);
		
		
		System.out.println(person);
		System.out.println(person.getAge());
	}
	
	

}
