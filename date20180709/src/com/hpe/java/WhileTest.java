package com.hpe.java;

import java.util.Scanner;

/**
 * 
 * @author chaoling
 * @date 2018年7月9日上午8:41:21
 * @Description  while,do-while语句的练习
 */
public class WhileTest {
	
	public static void main(String[] args) {
		
		test4();
		
	}
	
	//课文打印10遍——顺序结构
	public static void test1(){
		
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土！");
		System.out.println("锄禾日当午，汗滴禾下土!");
			
	}
	
	//课文打印十遍——while
	public static void test2(){
		
		//1.条件 --> 什么时候执行循环体
		//次数小于10次
		int count = 0;//次数
		
		while(count < 10){
			
			//2.循环体是什么
			//2.1打印课文
			System.out.println("第" + (count + 1) +"遍 ：锄禾日当午，汗滴禾下土!");
			
			//2.2次数加一
			count ++;
			
		}
		
	}
	
	//从控制台输入打印的次数
	public static void test3(){
		
		//从控制台获取输入
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入需要打印的次数");
		
		int sumCount = sc.nextInt();
		int count = 0;
		
		while (count < sumCount) {
			
			System.out.println("第" + (count + 1) +"遍 ：锄禾日当午，汗滴禾下土!");
			
			count ++;
			
		}
		
	}
			
	//使用while循环方式打印100以内4的倍数
	public static void test4(){
		
		int count = 4;
		
		System.out.println("100以内4的倍数");
		
		while(count <= 100){
			
			System.out.println(count + " ");
			
			count += 4;
		}
		
		
	}
			
			
	
	
}
