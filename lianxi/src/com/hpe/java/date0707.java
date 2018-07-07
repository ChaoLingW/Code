package com.hpe.java;

import java.util.Scanner;

/**
 * 
 * @author chaoling
 * @date 2018年7月7日下午3:16:19
 * @Description
 */
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
	
	public static void test7(){
		
		//键盘输入一个正整数n,计算1+2+……n,并输出和
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个正整数");
		
		int n = sc.nextInt();
		
		for(int i = 1; i < n; i++){
			
			sum += i;
			
		}
		
		System.out.println("1+2+……" + n +"的和为：" + sum);
	}
	
	public static void test8(){
		
		//利用for循环方式打印100以内4的倍数
		System.out.println("100以内的4的倍数");
		
		for(int i = 1,j = 0; i <= 100; i++){
			
			if(i % 4 == 0){
				
				System.out.print(i + " ");
				j++;
				
			}
				
			if(j == 5){
				
				System.out.println();
				j = 0;
				
			}
			
		}
		
		System.out.println();
		
	}
	
	public static void test9(){
		
		//输出100-999之间的水仙花数
		System.out.println("100-999之间的水仙花数");
		
		for(int i = 100; i <= 999; i++){
			
			int a = i/100;		//百位数
			int b = i%100/10; 	//十位数
			int c = i%10;		//个位数
			
			if(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) ==i)
				System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
	public static void test10(){
		
		//使用for循环方式计算2+4+6+…+100的值
		int sum = 0;
		
		for(int i = 2; i <= 100; i += 2){
			
			sum += i;
			
		}
		
		System.out.println("2+4+6+…+100的值:" + sum);
		
	}
	
	public static void test11(){
		
		//打印九九乘法表
		//第一种方式
		for(int row = 1; row <= 9; row++ ){
			
			for(int col = 1;col <= 9; col++){
				
				System.out.print(row + "*" + col + "=" + row * col + " ");
				
			}
			
			System.out.println();
			
		}
		
		//第二种方式
		for(int row = 1; row <= 9; row ++){
			
			for(int col = 1;col <= row; col++){
				
				System.out.print(row + "*" + col + "=" + row * col + " ");
				
			}
			
			System.out.println();
			
		}	
		
	}
	
	public static void test12(){
		
		//按顺序打印1-10，遇到3终止打印
		for(int i = 1; i <=10; i++){
		
			if(i == 3)
				break;
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
	}
	
	public static void test13(){
		
		/*循环录入5个人的年龄，
		并计算平均年龄，
		如果录入的数据出现负数
		或者大于130的数，
		立即停止输出报错*/
		
		int sum = 0;
		double avg = 0;
		for(int i = 1; i <= 5; i++){
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("请输入第" + i + "个人的年龄：");
			int age = sc.nextInt();
			
			if(age < 0 || age > 130){
				
				System.out.println("输入错误");
				break;
				
			}
			
			sum += age;
			
		}

		avg = sum / 5;
		
		System.out.println("平均年龄为：" + avg);
			
	}
	
	public static void test14(){
		
		//打印1-100不能被3整出的数
		System.out.println("1-100不能被3整出的数");
		
		for(int i = 1, j = 1; i <= 100; i++){
			
			if(i % 3 ==0){
				
				j++;
				continue;
				
			}
				
			System.out.print(i + " ");
			
			//输出控制
			if(j ==5){
				
				j = 1;
				System.out.println();
				
			}
		}
		
		System.out.println();
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
		
		//练习七
		System.out.println("练习七");
		test7();
		
		//练习八
		System.out.println("练习八");
		test8();
		
		//练习九
		System.out.println("练习九");
		test9();
			
		//练习十
		System.out.println("练习十");
		test10();
		
		//练习十一
		System.out.println("练习十一");
		test11();
		
		//练习十二
		System.out.println("练习十二");
		test12();
				
		//练习十三
		System.out.println("练习十三");
		test13();
		
		//练习十四
		System.out.println("练习十四");
		test14();
		
	}
	
}
