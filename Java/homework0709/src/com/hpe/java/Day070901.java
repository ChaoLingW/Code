package com.hpe.java;

import java.util.Scanner;
/**
 * 
 * @author chaoling
 * @date 2018年7月9日下午6:52:30
 * @Description
 */
public class Day070901 {

	public static void test1() {

		// 从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0师，结束程序
		int i = 0; //计数
		int fu = 0;
		int zheng = 0;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("请输入一个整数");
			i = sc.nextInt();
			
			if (i == 0)
				break;
			else if (i > 0)
				zheng++;
			else
				fu++;
		}

		System.out.println("正数的个数为：" + zheng);
		System.out.println("负数的个数为：" + fu);
	}

	public static void test2() {

		// 使用while循环方式打印100以内4的倍数（while中加if）
		int i = 1;	//计数

		System.out.println("100以内4的倍数");

		while (i <= 100) {
			
			if (i % 4 == 0)
				System.out.print(i + " ");
			i++;
		}

		System.out.println();
	}

	public static void test3() {

		// 用户输入用户名和密码
		// 只要不是admin和111就提示用户名或密码不正确，请重新输入
		// 正确结束循环，提示登录成功
		String userName;
		String passwd;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("请输入用户名");
			userName = sc.next();

			System.out.println("请输入密码");
			passwd = sc.next();

			if (userName.equals("admin") && passwd.equals("111")) {

				System.out.println("登录成功");
				break;
			} 
			else {
				
				System.out.println("用户名或密码不正确，请重新输入");
			}
		} while (true);
	}

	public static void test4() {

		// 打印从1990年到2050年期间所有的闰年
		int year = 1900;
		int line = 1;//换行标志符

		System.out.println("从1990到2050年期间所有的闰年");

		do {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				System.out.print(year + " ");
				line++;
			}
			if (line == 5) {
				System.out.println();
				line = 1;
			}
			year++;
		} while (year <= 2050);

	}

	public static void test5() {

		boolean flag = true;

		while (flag) {

			System.out.println("********************");
			System.out.println("1.管理员    2.顾客   3.退出");
			System.out.println("********************");
			System.out.println("请输入数字选择登录：");

			Scanner sc = new Scanner(System.in);
			int in = sc.nextInt();

			switch (in) {

			case 1:
				System.out.println("管理员登录过程省略");
				break;
			case 2:
				System.out.println("顾客登录过程省略");
				break;
			case 3:
				flag = false;
				System.out.println("系统退出");
				break;
			default:
				System.out.println("输入错误");
				break;
			}
		}
	}

	public static void test6() {

		// 求面积
		// 选择不同的图形输入数字计算面积，选择4退出程序
		boolean flag = true;

		System.out.println("计算面积");

		while (flag) {

			System.out.println("1.矩形 2.三角形 3.圆 4.退出 ");
			System.out.println("请选择数字对应的功能:");

			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();

			switch (input) {

			case 1:
				System.out.println("你选择了矩形");
				System.out.println("请输入矩形的宽");
				double kuan = sc.nextDouble();
				System.out.println("请输入矩形的长");
				double chang = sc.nextDouble();
				System.out.println("矩形的面积为：" + (chang * kuan));
				break;
			case 2:
				System.out.println("你选择了三角形");
				System.out.println("请输入三角形的高");
				double gao = sc.nextDouble();
				System.out.println("请输入三角形的底");
				double di = sc.nextDouble();
				System.out.println("三角形的面积为：" + (gao * di / 2));
				break;
			case 3:
				System.out.println("你选择了圆");
				System.out.println("请输入圆形的半径");
				double r = sc.nextDouble();
				System.out.println("该圆形的面积为：" + (Math.pow(r, 2) * Math.PI));
				break;
			case 4:
				System.out.println("系统退出");
				flag = false;
				break;
			default:
				System.out.println("输入错误");
			}
		}
	}

	public static void test7() {

		// 不断要求用户输入一个数字（假定用户输入的数字都是正整数）
		// 当用户输入end的时候显示刚才输入数字中的最大值
		int max = 0;
		
		while (true) {

			Scanner sc = new Scanner(System.in);
			String str = sc.next();

			if (str.indexOf("end") >= 0) {
				System.out.println(max);
				break;
			}

			int shu = Integer.parseInt(str);

			if (shu > max)
				max = shu;
		}
	}

	public static void test8() {

		// 有一只猴子摘了一堆桃子，
		// 每天吃掉一半桃子还不过瘾再多吃一个，
		// 吃到第十天的时候发现还剩下一个桃子，
		// 问猴子第一天一共摘了多少个桃子？。
		int day = 9;// 若桃子数为1 则循环次数为9次
		int sum = 1;

		while (day > 0) {

			sum = (sum + 1) * 2;
			day--;
		}
		System.out.println("第一天一共摘了" + sum + "个桃子");
	}

	
	public static void test9() {

		// 求int型数据在内存中存储时1的个数
		// 输入一个int型数据，计算出该int型数据在内存中存储时1的个数。
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个整数");

		int num = sc.nextInt();
		num = Math.abs(num);
		int count = 0;
		
		while (num > 0){

			//循环除2，如果不能整除就会出现1，计数变量++
			if (num % 2 != 1)
				count++;
			
			//这次的商作为下次的被除数
			num = num / 2;
		}
		System.out.println("在内存中存出时1的个数为：" + count);
	}

	public static void test10(){
		
		// 输入一个正整数，按照从小到大的顺序输出它的所有质数的因子
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数");
		
		int num = sc.nextInt();
		int i = 2;//除数
		
		System.out.print(num + "的质数因子为：");
		
		if(num == 1){
			System.out.print("无质数因子");
		}
		else if(num == 2){
			System.out.print("2");
		}
		else{
			
			/*
			 int i = 2;//除数
			 //num 输入的正整数
			 while(i <= num){
				while(num % i == 0){
					num = num/i;	
					System.out.print(i + " ");
				}
				i++;
			}*/
			while(num >=2){//num>1
				//如果num能被i整除，输出i,将num的值设置为num/i
				if(num % i == 0){
					num = num/i;
					/*if(num == i)
						break;*/
					System.out.print(i + " ");
				}
				//如果不能整除，i++
				else
					i++;
			}
		}
	}
	
	public static void test11() {

		// 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值
		// 设计一个算法，求输入A和B的最小公倍数。
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数");

		int a = sc.nextInt();
		System.out.println("请输入一个正整数");

		int b = sc.nextInt();
		int i = 1; // 计数
		int commonMultiple = 0; // 存储最小公倍数
		
		while (true) {
			commonMultiple = i * a;
			if (commonMultiple % b == 0)
				break;
			i++;
		}
		System.out.println(a + "和" + b + "的最小公倍数是：" + commonMultiple);
	}

	public static void test12() {
		// 计算一个数字的立方根，不使用Math方法
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数");
		
		int x = sc.nextInt();
		int y = 1;	//计数

		while (true) {
			if (x >= 0) {
				if (y * y * y == x) {
					System.out.println(x + "的立方根是：" + y);
					break;
				}
			} 
			else {
				if (y * y * y == -x) {
					System.out.println(x + "的立方根是：" + (-y));
					break;
				}
			}
			y++;
		}
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
		 
		// 练习十
		System.out.println();
		test10();

		// 练习十一
		System.out.println("练习十一");
		test11();

		//练习十二
		System.out.println("练习十二"); 
		test12();
	}
}
