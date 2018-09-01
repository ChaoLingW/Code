package com.hpe.java;

import java.util.Date;

public class HelloJava {

	int a = 1;//成员变量 （属性）
	
	public static void main(String[] args) {

		// 打印helloJava
		System.out.println("Hello Java!");

	}

	public void methood1() {

		// 定义变量的格式：类型 变量名 = 初始值
		
		int b = a + 1;//局部变量

	}

	public void methood2() {

		// 变量的作用范围：所在大括号内部有效
		a = 100;
		Date date = new Date();
	}

}