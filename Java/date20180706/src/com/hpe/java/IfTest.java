package com.hpe.java;

import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * 
 * @author chaoling
 * @date 2018年7月6日下午3:49:45
 * @Description
 */
public class IfTest {

	public static void main(String[] args) {

		test8();

	}

	public static void test1() {

		// 接收控制台输入的整数，如果大于0，就打印?大于0
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个整数");

		// 结束控制台输入的整数并保存
		String strNum = sc.nextLine();
		int num = Integer.parseInt(strNum);

		// 如果num大于0，就打印num大于0
		if (num > 0)
			System.out.println(num + "大于0");

	}

	public static void test2() {

		// 从控制台输入两个整数，如果相等打印相等，否则打印不相等
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入第一个数");

		int num1 = sc.nextInt();

		System.out.println("请输入第二个数");

		int num2 = sc.nextInt();

		if (num1 == num2)
			System.out.println("相等");
		else
			System.out.println("不相等");

		// 等价于三元运算符
		String res = (num1 == num2) ? "相等" : "不相等";
		System.out.println(res);
	}

	public static void test3() {

		// if-else if-else
		// 从控制台输入两个整数，并保存到a,b中。如果a>b，打印a大于b,如果a=b,打印a等于b,否者打印a小于b
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入第一个数");

		int a = sc.nextInt();

		System.out.println("请输入第二个数");

		int b = sc.nextInt();

		if (a > b)
			System.out.println(a + "大于" + b);
		else if (a == b)
			System.out.println(a + "等于" + b);
		else
			System.out.println(a + "小于" + b);

	}

	public static void test4() {

		Scanner input = new Scanner(System.in);
		System.out.println("请输入成绩");
		int score = input.nextInt();

		if (score >= 80)
			System.out.println("成绩优秀");
		else if (score >= 60)
			System.out.println("成绩合格");
		else if (score < 60)
			System.out.println("成绩不合格");
		else
			System.out.println("输入不正确");
	}

	public static void test5() {

		// if嵌套
		// 从控制台输入两个整数，并保存到a,b中。如果a>b，打印a大于b,如果a=b,打印a等于b,否者打印a小于b
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入第一个数");

		int a = sc.nextInt();

		System.out.println("请输入第二个数");

		int b = sc.nextInt();

		if (a >= b) {

			// a大于或等于b
			if (a > b) {

				// a>b
				System.out.println(a + "大于" + b);

			} else {

				// a=b
				System.out.println(a + "等于" + b);
			}

		} else {
			System.out.println(a + "小于" + b);
		}
	}

	public static void test6() {

		// 由键盘输入三个整数分别存入变量num1,num2,num3,对它们进行排序，并且从大到小输出

		Scanner input = new Scanner(System.in);

		System.out.println("请输入");

		int num1 = input.nextInt();

		System.out.println("请输入");

		int num2 = input.nextInt();

		System.out.println("请输入");
		int num3 = input.nextInt();

		/*
		 * if(num1 > num2){ if(num1 > num3){ if(num2 > num3){
		 * System.out.println(num1); System.out.println(num2);
		 * System.out.println(num3); } else{ System.out.println(num1);
		 * System.out.println(num3); System.out.println(num2); } } else{
		 * System.out.println(num3); System.out.println(num1);
		 * System.out.println(num2); } } else{ if(num1 > num3){
		 * System.out.println(num2); System.out.println(num1);
		 * System.out.println(num3); } else if(num2 < num3){
		 * System.out.println(num3); System.out.println(num2);
		 * System.out.println(num1); } else{ System.out.println(num2);
		 * System.out.println(num3); System.out.println(num1); }
		 * 
		 * }
		 */

		/*
		 * int temp; //设置临时变量，将最大值存入num1,最小值存入num3 //比较num1与num2将大值存入num1
		 * if(num1 < num2){ temp = num1; num1 = num2; num2 = temp; }
		 * 
		 * //比较num1与num3将大值存入num1 if(num3 > num1){ temp = num1; num1 = num3;
		 * num3 = temp; } if(num3 > num2){ temp = num2; num2 = num3; num3 =
		 * temp; }
		 * 
		 * System.out.println(num1); System.out.println(num2);
		 * System.out.println(num3);
		 */

		// 首先比较前两个，之后用第三个数比较插入，位置有三个
		if (num1 > num2) {

			// 1 2
			if (num3 > num1) {

				// 3 1 2
				System.out.println(num3 + "_" + num1 + "_" + num2);

			} else if (num3 < num2) {

				// 1 2 3
				System.out.println(num1 + "_" + num2 + "_" + num3);

			} else {

				// 1 3 2
				System.out.println(num1 + "_" + num3 + "_" + num2);

			}

		} else {

			// 2 1
			if (num3 > num2) {

				// 3 2 1
				System.out.println(num3 + "_" + num2 + "_" + num1);

			} else if (num3 < num1) {

				// 2 1 3
				System.out.println(num2 + "_" + num1 + "_" + num3);

			} else {

				// 2 3 1
				System.out.println(num2 + "_" + num3 + "_" + num1);

			}

		}

	}

	public static void test7() {

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个整数");

		int a = sc.nextInt();
		int x = 100;

		// 利用switch语句改写以下代码
		/*
		 * if(a == 1) x += 5; else if(a == 2) x += 10; else if(a == 3) x += 16;
		 * else if(a == 4) x += 34; else x += 100;
		 */

		switch (a) {

		case 1:
			x += 5;
			break;
		case 2:
			x += 10;
			break;
		case 3:
			x += 16;
			break;
		case 4:
			x += 34;
			break;
		default:
			x += 100;
			break;

		}

		System.out.println(x);

	}

	public static void test8() {

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入成绩");

		int score = sc.nextInt();
		char grade = 0;
		
		//需要除10,否则case需要100个
		switch(score/10){
		
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
		case 7:
			grade = 'B';
			break;
		case 6:
			grade = 'C';
			break;
		default:
			grade = 'D';
			break;
			
		}
		System.out.println(grade);

	}

}
