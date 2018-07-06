package com.hpe.java;

import java.util.Scanner;
/**
 * 
 * @author chaoling
 * @date 2018年7月6日下午3:49:57
 * @Description
 */
public class InputTest {

		public static void main(String[] args) {

			//从控制台输入一个整数，并把它保存起来，最后打印输出
			System.out.println("请输入一个整数");
			
			//1.创建Scanner对象
			Scanner sc = new Scanner(System.in);
			
			//2.获取从控制台输入的整数
			int num = sc.nextInt();
			
			//3.打印
			System.out.println(num);
			
			sc.nextLine();//接收换行符
			
			//接受控制台输入的文字并打印
			String content = sc.nextLine();
			
			System.out.println(content);
			System.out.println("结束");
			
		}

}
