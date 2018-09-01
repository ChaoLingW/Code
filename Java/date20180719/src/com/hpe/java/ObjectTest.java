package com.hpe.java;

import org.junit.Test;

public class ObjectTest {
	
	@Test
	public void test(){
		
		//Object类是所有类的父类(不是直接继承就是间接继承)
		//所有类都继承了Object类的方法
		Person p1 = new Person();
		
		//toString如果不重写，调用的就是Object的toString
		System.out.println(p1);//com.hpe.java.Person@5f4da5c3
		//System.out.println(p1.toString());
		
		String str = new String("abc");
		
		
	}
	
	//==&equals
	@Test
	public void test1(){
		
		String str1 = new String("123");
		String str2 = new String("123");
		
		System.out.println(str1.equals(str2));//true
		
		Person p1 = new Person();
		Person p2 = new Person();
		System.out.println(p1.equals(p2));//false，重写equals后为true
		
		//==既可以比较基本数据类型也可以计较引用数据类型
		//比较基本数据类型时比较的是数值是否一致
		//比较引用数据累心时比较的是地址值是否一致
		//equals 只能比较引用数据类型，比较的是地址值是否一致,但有些类会重写Object的equals用于比较内容是否一致，比如String
		int a = 1;
		int b = 1;
		
		System.out.println(a == b);//true
		System.out.println(p1==p2);//false
		
		
		
		
		
	}
	
}
