package com.hpe.java;

import java.sql.Date;

/**
 * 
 * @author chaoling
 * @date 2018年7月9日下午4:36:46
 * @Description
 */
public class ArrayTest {

	public static void main(String[] args) {

		test2();
		
	}
	
	public static void test1(){
		
		//数组的声明：格式：类型 数组名[] 或者 类型[] 数组名
		int a[];
		int[] b;
		
		Date[] c;
		//int[5] d; 非法
	}
	
	public static void test2(){
		
		//动态初始化-->在初始化的时候只指定数组的长度（数组中元素的个数），由系统来分配初始值
		int[] a = new int[5];
		
		//输出数组名/对象名时。输出的时地址
		System.out.println(a.toString());
		
		//获取数组的长度（数组中元素的个数）length属性
		System.out.println(a.length);
		
		//使用数组名[下标]得到指定位置的元素，下标的取值范围 0 - 数组长度-1 -->数组名.length-1
		int a0 = a[0];
		
		System.out.println(a0);
		
		System.out.println(a[5]);
	}

}
