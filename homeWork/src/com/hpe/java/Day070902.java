package com.hpe.java;

import java.util.Scanner;

/**
 * 
 * @author chaoling
 * @date 2018年7月9日下午6:54:22
 * @Description
 */
public class Day070902 {
	
	public static void test1() {

		// 使用for循环方式计算2+4+6+…+100的值
		int sum = 0;

		for (int i = 2; i <= 100; i += 2) {

			sum += i;

		}

		System.out.println("2+4+6+…+100的值:" + sum);

	}

	public static void test2() {

		// 打印九九乘法表
		// 第一种方式
		for (int row = 1; row <= 9; row++) {

			for (int col = 1; col <= 9; col++) {

				System.out.print(row + "*" + col + "=" + row * col + " ");

			}

			System.out.println();

		}

		// 第二种方式
		for (int row = 1; row <= 9; row++) {

			for (int col = 1; col <= row; col++) {

				System.out.print(row + "*" + col + "=" + row * col + " ");

			}

			System.out.println();

		}

	}

	public static void test3() {

		// 输入一个正整数，判断是否为素数。
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个正整数");

		int a = sc.nextInt();
		boolean flag = true;
		
		if (a > 2) {
			//判断>2的情况
			for (int i = 2; i <= Math.sqrt(a); i++) {

				if (a % i == 0) {

					flag = false;
					break;

				}

			}
			
			if (flag)
				System.out.println(a + "是素数");
			else
				System.out.println(a + "不是素数");
			
		}
		else if(a == 2){
			//2是素数
			System.out.println(a + "是素数");
		}
		else
			//1不是素数
			System.out.println(a + "不是素数");
		
	}

	public static void test4() {
		
		//打印出100以内的质数，一行显示5个，
		//（质数是只能被1跟自身整除的数，1不是质数）
		boolean flag = true;
		
		for(int i = 2,k = 1; i <= 100; i++){
			
			for(int j = 2; j <= i / 2; j++ ){
				
				if(i % j == 0){
					
					flag = false;
					break;
					
				}
				
			}
			
			if(flag){
				
				System.out.print(i + " ");
				k++;
				
			}
			
			flag = true;
			
			if(k == 6){
				k = 1;
				System.out.println();	
				
			}
				
		}
		
	}

	public static void test5() {

		/*
		 * 循环录入5个人的年龄，并计算平均年龄 如果录入的数据出现负数 或者大于130的数 立即停止输出报错
		 */

		int age;
		double sum = 0;//总年龄
		boolean flag = true;//标志
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i < 6; i++){
			
			System.out.println("请输入第" + i + "个人的年龄");
			
			age = sc.nextInt();
			
			//判断年龄是否合法：年龄小于0或或者年龄大于130
			//如果不合法——>结束整个for循环
			if(age < 0 || age > 130){
				
				//将标志位设置为false
				flag = false;
				//结束整个for循环
				break;
				
			}
			else{
				sum += age;
			}
			
		}
		
	}

	public static void test6() {

		//据用户输入的正整数n，求n!,即n!=n*(n-1)*(n-2)*…*1。
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个正整数");
		
		int n = sc.nextInt();
		int product  = 1;//积
		
		for( int i = 1; i <= n; i++){
			
			product *= i;
			
		}
		
		System.out.println(n + "!为:" + product);
		
	}

	public static void test7() {
		
		//输出以下
		//      *
		//     ***
		//    *****
		//   *******
		//  *********
		// ***********
		
		
		for (int h = 1; h <= 7; h++) {
			
            for (int n = 0; n <= 11-h; n++) {
                System.out.print(" ");
            }
            
            for (int n = 0; n < h * 2 - 1; n++) {
                System.out.print("*");
            }
            		
            System.out.println();
        }
	    
		
	}

	public static void test8() {
		
		//百鸡百钱
		for(int cockNo = 1; cockNo <= 20; cockNo++){
			for(int henNo = 1; henNo <= 33; henNo++){
				for(int chickNo = 1; chickNo <= 99; chickNo++){
					
					if(cockNo + henNo + chickNo == 100)
						if(cockNo * 15 + henNo * 9 + chickNo == 300)//三只小鸡一文钱，除不尽。因此整个乘3
							System.out.println("公鸡：" + cockNo +"只    " + "母鸡：" + henNo +"只    " + "小鸡：" + chickNo +"只");
				}
			}
		}
		
	}

	public static void test9() {
		
		//印出1000-9999之间所有的回文数。
		for(int i = 1000; i <= 9999; i++){
			
			int a = i / 1000;		//千位数
			int b = i / 100 % 10; 	//百位数
			int c = i / 10 % 10;	//十位数
			int d = i % 10;			//个位数
			
			if(a == d && c == b)
				System.out.print(i + " ");
				
		}
	}

	public static void main(String[] args) {

		// 练习一
		System.out.println("练习一");
		test1();

		// 练习二
		System.out.println("练习二");
		test2();

		// 练习三
		System.out.println("练习三");
		test3();

		// 练习四
		System.out.println("练习四");
		test4();

		// 练习五
		System.out.println("练习五");
		test5();

		// 练习六
		System.out.println("练习六");
		test6();

		// 练习七
		System.out.println("练习七");
		test7();

		// 练习八
		System.out.println("练习八");
		test8();

		// 练习九
		System.out.println("练习九");
		test9();
	}
}
