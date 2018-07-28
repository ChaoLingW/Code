package com.hpe.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

public class CommonException {

	//常见的异常
	
	@Test
	public void test1(){
		
		//
		int a = 10;
		int b = 0;
		
		System.out.println(a/b);//算术异常java.ArithmwticException
		
		System.out.println(123);//异常不处理的话，其后代码不执行
	}
	
	@Test
	public void test2(){
		
		int[] arr = new int[3];
		System.out.println(arr[3]);//数组下标越界异常 java.long.ArrayIndexOutOfBoundsException
		
	}
	
	@Test
	public void test3(){
		
		String str = null;
		str.trim();//空指针异常 java.long.NullPointerException
		
	}
	
	@Test
	public void test4(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("输入一个数字");
		
		int num = sc.nextInt();//输入不匹配异常 java.util.InputMismathcException
		
		System.out.println(num);
	}
	
	@Test
	public void test5(){
		
		Object obj  = "11";//多态
		//int num = (int) obj;
		Date date = (Date)obj;//类型转化异常java.lang.ClassCastException
		
	}
	
	//编译时异常
	//必须处理才可以运行
	
	@Test
	public void test6(){
		
		//io
		//FileInputStream
		try {
			FileInputStream fis = new FileInputStream("111.txt");//java.io.FileFoundException
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
