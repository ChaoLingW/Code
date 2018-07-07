package com.hpe.java;

import java.util.Scanner;

public class date0707 {
	
	public static void test1(){
		
		//使用while循环方式计算2+4+6+8+……100
		int i = 2;
		int sum = 0;
		
		while(i <= 100){
			sum += i;
			i +=2;
		}
		
		System.out.println(sum);
		
	}
	
	public static void test2(){
		
		//使用while循环方式打印100以内4的倍数（while中加if）
		int i = 1;
		
		System.out.println("100以内4的倍数");
		
		while(i <= 100){
			if(i % 4 == 0)
				System.out.print(i + " ");
			i++;
		}
		
		System.out.println();
		
		
		
		
	}
	
	public static void test3(){
		
		//从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0师，结束程序
		
		int i = 0;
		int fu = 0;
		int zheng = 0;
	
		while(true){
			Scanner sc = new Scanner(System.in);
			i = sc.nextInt();
			if(i == 0)
				break;
			if(i > 0)
				zheng++;
			else
				fu++;
		}
		
		System.out.println("正数的个数为：" + zheng);
		System.out.println("负数的个数为：" + fu);
	
	}
	
	public static void test4(){
		
		//计算1-100之间的和
		int i = 1;
		int sum = 0;
		
		do{
			sum += i;
			i++;
		}while(i <= 100);
		
		System.out.println("1-100之间的和位" + sum);
		
	}
	
	public static void test5(){
		
		//使用do-while打印100以内4的倍数
		int i = 1;
		
		System.out.println("100y以内4的倍数");
		do{
			if(i % 4 == 0)
				System.out.println(i + " ");
		}while(i <= 100);
		
	}
	
	public static void test6(){
		
		//用户输入用户名和密码
		//只要不是admin和111就提示用户名或密码不正确，请重新输入
		//正确结束循环，提示登录成功
		String userName;
		String passwd;
		do{
		
			Scanner sc = new Scanner(System.in);
			
			System.out.println("请输入用户名");
			
			userName = sc.next();
			
			System.out.println("请输入密码");
			
			passwd = sc.next();
			
			if(userName.equals("admin") && passwd.equals("111")){
				
				System.out.println("登录成功");
				break;
			
			}
			else{
				System.out.println("用户名或密码不正确，请重新输入");
			}
		}while(true);
	}
	
	public static void main(String[] args) {
		
		//练习一
		System.out.println("练习一");
		test1();
		
		//练习二
		System.out.println("练习二");
		test2();
		
		//练习三
		System.out.println("练习三");
		test3();
		
		//练习四
		System.out.println("练习四");
		test4();
		
		//练习五
		System.out.println("练习五");
		test5();
		
		//练习六
		System.out.println("练习六");
		test6();
		
		
	}
	
	

}
