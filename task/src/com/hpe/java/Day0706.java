package com.hpe.java;

import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * 
 * @author chaoling
 * @date 2018年7月6日下午5:55:38
 * @Description
 */
public class Day0706 {

	public static void question1() {

		// 求面积
		// 提示求哪种图形的面积

		System.out.println("1 矩形 2 三角形 3 圆 ");
		System.out.println("请选择图形:");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		switch (input) {

		case 1:
			System.out.println("请输入矩形的宽");
			double kuan = sc.nextDouble();
			System.out.println("请输入矩形的长");
			double chang = sc.nextDouble();
			System.out.println("该矩形的面积为：" + (chang * kuan));
			break;
		case 2:
			System.out.println("请输入三角形的高");
			double gao = sc.nextDouble();
			System.out.println("请输入三角形的底");
			double di = sc.nextDouble();
			System.out.println("该三角形的面积为：" + (gao * di / 2));
			break;
		case 3:
			System.out.println("请输入圆形的半径");
			double r = sc.nextDouble();
			System.out.println("该圆形的面积为：" + (Math.pow(r, 2) * Math.PI));
			break;
		default:
			System.out.println("输入错误");
		}

	}

	public static void question2() {

		// 简易计算器
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入算式(逐个输入)");
		double a = sc.nextDouble();
		String fuHao = sc.next();
		double b = sc.nextDouble();
		double result = 0;

		switch (fuHao) {

		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			if (b != 0)
				result = a / b;
			else
				System.out.println("除数不能为0");
			break;
		default:
			System.out.println("输入错误");
			break;

		}

		System.out.println("result=" + result);

	}

	public static void question3() {

		// 输入分数，打印等级（使用switch结构） 90-100 A 80-89 B 70-79 C 60-69 D <60 E
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入成绩");

		int score = sc.nextInt();
		char grade = 0;

		switch (score / 10) {

		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'E';
			break;

		}
		System.out.println(grade);

	}

	public static void question4() {

		/*
		 * 某城市出租车计费问题：  每日06:00-21:00，起步价6元，当日22:00-次日05:00，起步价7元。 
		 * 起步价包含2公里，超出部分按照每公里1.5元收费。  每次乘车加收1元的燃油附加税。 输入打车的时间和距离，计算本次打车的费用。
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入打车时间(格式为xx:xx)");
		
		String strTime = sc.next();
		
		System.out.println("请输入打车距离");
		
		int distance = sc.nextInt();
		
		int startingPrice = 0;
		int fuelAdditionalFollow = 1;
		double charge = 0;
		
		/*
		//对time中的:进行替换处理,之后将利用Integer类将String转换为int
		strTime = strTime.trim();
		strTime = strTime.replace(":", "");
		int  time = Integer.parseInt(strTime);
		
		//判断起步价
		if(time >= 600 && time <= 2100)
			startingPrice = 6;
		else
			startingPrice = 7;*/
		
		//截取strTime中的前两位，判断第二位是否位数字，若是，则时间位前两位，若不是，则时间是第一位
		strTime = strTime.trim();
		String x = strTime.substring(0,1);
		String y = strTime.substring(1,2);
		
		if((int)y.charAt(0) >= 48 && (int)y.charAt(0) <= 57)
			strTime = x + y;
		else
			strTime = x;
		int  time = Integer.parseInt(strTime);
		
		if(time >= 6 && time <= 21)
			startingPrice = 6;
		else
			startingPrice = 7;
		
		if(distance > 2)
			charge = startingPrice + fuelAdditionalFollow + 1.5 * (distance - 2);
		else
			charge = startingPrice + fuelAdditionalFollow;
		
		System.out.println("本次打车费用为：" + charge);
		

	}

	public static void question5() {

		// 已知判断闰年的规则是：
		// 能被4整除，但是不能被100整除。或者能被400整除。
		// 从控制台输入一个年份，并打印输入的年份是不是闰年。
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入年份");

		int year = sc.nextInt();
		String b = "不是";

		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
			b = "是";

		System.out.println(year + "年" + b + "闰年");
	}

	public static void question6() {

		// 由键盘输入三个整数分别存入变量num1、num2、num3，对它们进行排序,并且从小到大输出。
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个整数");

		int num1 = sc.nextInt();
		
		System.out.println("请输入一个整数");

		int num2 = sc.nextInt();
		
		System.out.println("请输入一个整数");

		int num3 = sc.nextInt();
		int temp;
		
		//利用临时变量，两两比较，将较大的值存放在靠后的位置
		if(num1 > num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}

		if(num1 > num3 ){
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		
		if(num2 > num3){
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		System.out.println(num1 + "-" +num2+ "-" + num3);
		
	}

	public static void question7() {

		// 取近似值
		// （不使用库方法）写出一个程序，接受一个浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个浮点数");

		double before = sc.nextDouble();
		int y = (int)before;
		double difference;
		difference = before - y;
		int after;
		if(before >= 0){
			if(difference >= 0.5)
				after = y + 1;
			else
				after = y;
		}
		else{
			if(difference <= 0.5)
				after = y - 1;
			else
				after = y;
		}
		System.out.println(before + "的近似整数为：" + after);
		
		

	}

	public static void main(String[] args) {
		
		System.out.println("练习一");
		question1();
		System.out.println("练习二");
		question2();
		System.out.println("练习三");
		question3();
		System.out.println("练习四");
		question4();
		System.out.println("练习五");
		question5();
		System.out.println("练习六");
		question6();
		System.out.println("练习七");
		question7();
		
	}

}
