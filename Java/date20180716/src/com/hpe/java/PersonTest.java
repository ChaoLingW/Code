package com.hpe.java;



import java.util.Date;

import org.junit.Test;

public class PersonTest {
	
	@Test
	public void test(){
		
		//创建Person类的对象
		Person p1 = new Person();
		
		Person p2 = new Person(11, "男", "张三");
		
	}
	
	@Test
	public void test1(){
		
		Student s1 = new Student("10001");
	}
	
	@Test
	public void test2(){
		//全类名 唯一指定类 -->带着包名的类名（全限定名）
		com.hpe.java1.Person p1 = new com.hpe.java1.Person();
		p1.eat();
		
		Person p2 = new Person();
		p2.study();
		
		//Date
		Date date = new Date();
		
		//创建sql.Date的对象
		
		java.sql.Date date1 = new java.sql.Date(1000000);
	
	}

}
