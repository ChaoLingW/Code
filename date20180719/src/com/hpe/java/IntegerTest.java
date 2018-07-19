package com.hpe.java;

import org.junit.Test;

public class IntegerTest {

	@Test
	public void test1(){
		
		//八种基本数据类型对应着都有其引用类（包装类、封装类）
		//byte short int  long float double char boolean
		//Byte Short Integer Long Float Double Character	Boolean
		
		int a = 1;
		
		Integer b = new Integer(2);
		
		System.out.println(b);
		
		b = a;//可以将基本数据类型转换为他所对应的包装类型（自动的装箱）Integer.valueOf(a);
		
		Integer c = new Integer(3);
		
		int d = c;//将包装类型转换为其所对应的基本数据类型（自动的拆箱）c.intValue();
		
		Person p = new Person();
		
		p.equals(1);//1在这个位置自动的装箱了p.equals(Integer.valueOf(1));
		
	}
	
	@Test
	public void test2(){
		
		//如何将一个String的数值转换为int
		String str = "1";
		int a = Integer.parseInt(str);
		
	}
	
	@Test
	public void test3(){
		
		//如何将一个int的数值转换为其所对应的字符串
		int a = 1;
		//1.使用String类中的toString(..)方法
		String str1 = String.valueOf(a);
	
		//2.使用其包装类的toString方法
		String str2 = Integer.toString(a);
		
		//3.字符串拼接
		String str3 = a + "";//"1"+""
		String str4 = Integer.valueOf(a).toString() + "";
		
	}
	
	
	
}
