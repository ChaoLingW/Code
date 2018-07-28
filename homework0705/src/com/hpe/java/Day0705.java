package com.hpe.java;

import java.util.Scanner;

/**
 * 
 * @author chaoling
 * @date 2018年7月5日下午7:53:25
 * @Description 作业
 */
public class Day0705 {

	public static void tisk1() {

		// 任务一：对个人信息进行输出
		String name = "王朝令";
		char sex = '男';
		int age = 22;
		String subject = "Java语言编程基础及应用";

		System.out.println("我的姓名是：" + name);
		System.out.println("性别为：" + sex);
		System.out.println("年龄为：" + age);
		System.out.println("所学课程为：" + subject);
	}

	public static void tisk2() {

		// 任务二：购物运算
		int shritPrice = 245;
		int shoesPrice = 570;
		int racketPrice = 320;
		int shritNo = 2;
		int shoesNo = 1;
		int racketNo = 1;
		double discount = 0.8;

		// 计算消费总金额
		double finalPay = (shritNo * shritPrice + shoesPrice * shoesNo + racketPrice * racketNo) * discount;

		System.out.println("消费总金额：" + finalPay);
	}

	public static void tisk3() {

		// 任务三：比较运算符的使用
		int shritPrice = 245;
		int shoesPrice = 570;
		int racketPrice = 320;
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入折扣：");
		double discount = input.nextDouble();

		// 计算折扣
		shritPrice *= discount;
		racketPrice *= discount;
		shoesPrice *= discount;

		// 判断商品折后价格是否低于100
		char shritPriceDisBool = shritPrice < 100 ? '是' : '否';
		char racketPriceDisBool = racketPrice < 100 ? '是' : '否';
		char shoesPriceDisBool = shoesPrice < 100 ? '是' : '否';

		System.out.println("T恤折扣价低于100元吗？" + shritPriceDisBool);
		System.out.println("网球鞋折扣价低于100元吗？" + racketPriceDisBool);
		System.out.println("网球拍折扣价低于100元吗？" + shoesPriceDisBool);
	}

	public static void main(String[] args) {

		System.out.println("任务一：对个人信息进行输出");
		tisk1();
		System.out.println("任务二：购物运算");
		tisk2();
		System.out.println("任务三：比较运算符的使用");
		tisk3();	
	}
}
