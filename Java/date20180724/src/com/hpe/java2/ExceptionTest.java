package com.hpe.java2;

import java.awt.Transparency;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

public class ExceptionTest {

	// 捕获异常：
	// 1.try-catch-finally
	// 2.向上抛出，使用throws

	// try-->可能出现异常的代码块
	// catch--> 处理异常的代码
	// finall-->必然会执行的代码

	@Test
	public void test1() {

		int a = 10;
		int b = 0;

		try {
			int c = a / b;// jvm创建了一个异常类的对象(ArithmeticExceptioin类的对象)
			System.out.println(2);
		} catch (Exception e) {
			System.out.println(1);
			System.out.println(10/0);
		}finally{
			//必然会执行
			System.out.println(4);
		}

		System.out.println(3);

	}

	@Test
	public void test2(){
		
		Scanner sc = new Scanner(System.in);
		
		int c = 0;
		
		try{
			System.out.println("请输入被除数");
		
			int a = sc.nextInt();
		
			System.out.println("请输入被除数");
		
			int b = sc.nextInt();
		
			c = a/b;
		}
		catch(InputMismatchException e){
			
			System.out.println("输入不匹配");
			
		}
		catch(ArithmeticException e){
			System.out.println("除数不匹配");
		}
		
		System.out.println(c);
		
	}

}
