package com.hpe.java;

import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * @author chaoling
 * @date 2018年7月14日上午8:39:51
 * @Description
 */
public class Day0714 {

	@Test
	public void fibonacci() {

		/*
		 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子， 假如兔子都不死，问每个月的兔子总数为多少？
		 * 分析，第一个月有1对，第二个月2对，第三个月
		 */

		int[] arr = new int[10];
		arr[0] = arr[1] = 1;

		for (int i = 0; i < arr.length; i++) {
			if (i > 1)
				arr[i] = arr[i - 1] + arr[i - 2];

			System.out.printf("第%d月兔子的个数为：%d\n", (i + 1), arr[i] * 2);
		}
	}

	@Test
	public void distance() {
		// 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
		float height = 100; // 存储当前高度
		float returnHeight = 0;// 存储反弹高度
		int num = 10; // 存储次数
		float distance = 0; // 存储距离

		for (int i = 0; i < num; i++) {
			// 记录距离=下落高度+反弹高度
			distance += (height + returnHeight);
			// 下次高度等于本次高度/2
			height = height / 2;
			// 反弹高度=下次高度
			returnHeight = height;
		}

		System.out.printf("第%d次落地时，共经过%f米 \n", num, distance);
		System.out.printf("第%d次反弹%f米\n", num, returnHeight);
	}

	/*
	 * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
	 */
	@Test
	public void isTotalSquare() {

		long i = 0;
		double temp;
		int num = 5;// 保存输出的个数
		int count = 0;

		while (count < num) {

			// 对i+100开平方
			temp = Math.sqrt(i + 100);
			// 判断是否是整数
			if (temp % 1 == 0) {
				// 对i+100+168开平方
				temp = Math.sqrt(i + 100 + 168);
				// 判断是否是整数
				if (temp % 1 == 0) {
					// 计数
					count++;
					// 输出 ，结束循环
					System.out.println(i);
				}
			}
			// 条件不满足 自增
			i++;
		}
	}

	/*
	 * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
	 */
	@Test
	public void fractionSum() {

		// 分析，满足斐波那契数列
		int num = 20; // 定义需要计算的项数
		double[] arr = new double[num + 2]; // 定义数组，保存斐波那契数列

		arr[0] = arr[1] = 1;// 赋值
		double sum = 0;// 保存和

		for (int i = 0, j = 2; i < num && j < arr.length; i++, j++) {
			// i控制输出的项数，j表示是斐波那契数列的第几个
			arr[j] = arr[j - 1] + arr[j - 2];
			// 计算arr[j]/arr[j-1]
			sum += arr[j] / arr[j - 1];
			// 优化输出
			if (i > 0)
				System.out.print("+");

			System.out.print((int) arr[j] + "/" + (int) arr[j - 1]);
		}
		// 输出结果
		System.out.println("=" + sum);
	}

	// 求1+2!+3!+...+20!的和
	@Test
	public void factorialSum() {

		int num = 20;// 次数
		long sum = 0;// 和

		for (int i = 1; i <= num; i++) {
			int temp = 1;// 保存i!
			// 求i!
			for (int j = 1; j <= i; j++)
				temp *= j;

			// 1！+……+i!
			sum += temp;
			// 输出
			if (i > 1)
				System.out.print("+");

			System.out.print(i + "!");
		}
		// 输出结果
		System.out.println("=" + sum);
	}

	@Test
	public void age() {
		/*
		 * 有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人
		 * ，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？
		 */
		int age = 10;// 存储第一个年龄
		int num = 5;// 第num个人的年龄 循环的次数

		// age = (num-1)*2 + 10;
		for (int i = 1; i < num; i++) {
			age += 2;
		}
		// 输出结果
		System.out.printf("第%d个人的年龄为%d岁", num, age);
	}

	// 求0—7所能组成的奇数个数
	@Test
	public void oddNum() {

		int count = 0;
		int num = 4;
		int begin = 0;
		int end = 7;
		int longth = end - begin + 1;
		// 判断个位中的奇数个数
		for (begin = 0; begin <= end; begin++)
			if (begin % 2 != 0)
				count++;

		for (int i = 0; i < num; i++) {

			if (i == 0)
				System.out.println("组成" + (i + 1) + "位数是" + count + "个");
			else {
				System.out.print("组成" + (i + 1) + "位数是" + end + "*");
				
				for (int j = 0; j < i - 1; j++) 
					System.out.print(longth + "*");

				System.out.println(count + "个");
			}
		}
	}

	// 判断一个整数能被几个9整除
	@Test
	public void number() {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数");

		int num = sc.nextInt();
		// 取绝对值
		num = Math.abs(num);
		int count = 0;

		while (num >= 9) {
			// 判断是否能被九整除
			if (num % 9 == 0) {
				// num除九
				num = num / 9;
				count++;
			}
		}
		System.out.println(count);
	}

	/*
	 * 两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比，
	 * c说他不和x,z比，请编程序找出三队赛手的名单。
	 */
	@Test
	public void pingpang() {

		char[] nail = { 'a', 'b', 'c' };
		char[] B = { 'x', 'y', 'z' };
		char i, j, k;
		i = j = k = 'X';

		// 本质还是一个排序的问题
		for (i = 'X'; i <= 'Z'; i++) {
			for (j = 'X'; j <= 'Z'; j++) {
				if (i != j) {// 减少循环次数
					for (k = 'X'; k <= 'Z'; k++) {
						if (i != k && k != j) {// 减少循环次数
							// 判断条件，满足输出
							if (i != 'X' && k != 'X' && k != 'z') {
								System.out.println("A" + "——" + i);
								System.out.println("B" + "——" + j);
								System.out.println("C" + "——" + k);
							}
						}
					}
				}
			}
		}
	}

	// 对10个数进行排序
	@Test
	public void sort() {

		int[] arr = { 1, 2, 0, 6, 3, 4, 5, 9, 8, 7 };
		// 冒泡排序
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		// 遍历输出
		for (int i : arr) 
			System.out.print(i + " ");
	}

	// 求一个3*3矩阵对角线元素之和
	@Test
	public void diagonal() {

		int num = 3;
		int sum = 0;
		int[][] arr = new int[num][num];
		// 对矩阵赋值
		for (int i = 0; i < num; i++) 
			for (int j = 0; j < num; j++) 
				arr[i][j] = j;
			
		
		// 求和
		for (int i = 0; i < num; i++) 
			for (int j = 0; j < num; j++) 
				// 在对角线的元素满足i==j或者i+j==num
				if (i == j || i + j == num)
					sum += arr[i][j];

		System.out.println("对角线上元素的和为：" + sum);
	}

	// 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
	@Test
	public void countChar() {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一行字符");
		
		String str = sc.nextLine();
		char[] arr = str.toCharArray();

		int numCount, otherCount, spaceCount, letterCount;
		numCount = otherCount = spaceCount = letterCount = 0;

		for (int i = 0; i < arr.length; i++) {
			// 自动类型转换为int,使用ASCII
			int num = arr[i];
			// 空格
			if (num == 32)
				spaceCount++;
			// 数字
			else if (num >= 38 && num <= 57)
				numCount++;
			// 字母
			else if ((num >= 65 && num <= 90) || (num >= 97 && num <= 122))
				letterCount++;
			// 其它
			else
				otherCount++;
		}

		System.out.println("空格的个数：" + spaceCount);
		System.out.println("数字的个数：" + numCount);
		System.out.println("其他的个数：" + otherCount);
		System.out.println("中英文的个数：" + letterCount);
	}

	// 给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
	// 使用了长整型最多输入18位
	@Test
	public void analysisNumber() {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数");
		// 接收为字符串
		String str = sc.nextLine();
		// 转换为数组
		char[] arr = str.toCharArray();
		int index = -1;
		// 去除左边的零
		for (int i = 0; i < arr.length - 1; i++) {
			// 从左到右第一个不为0的数的前一位的位置
			if (arr[i] == '0' && arr[i + 1] != '0') {
				index = i;
				break;
			}
		}
		// 数组的长度减去左边0的个数就是它的位数
		System.out.println("它是一个" + (arr.length - index - 1) + "位数");
		// 输出
		for (int i = arr.length - 1; i > index; i--) {
			System.out.print(arr[i] + " ");
		}
	}

	@Test
	// 有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
	public void againSort() {

		int[] arr = { 4, 2, 1 };
		int a = 3;
		int[] newArr = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++) 
			newArr[i] = arr[i];
		
		newArr[arr.length] = a;

		boolean flag = true;
		// 判断由小达大还是由大到小，默认为由小到大
		if (arr[0] > arr[1])
			flag = false;

		// 冒泡排序
		for (int i = 0; i < newArr.length - 1; i++) {
			for (int j = 0; j < newArr.length - i - 1; j++) {
				if (flag) {
					if (newArr[j] > newArr[j + 1]) {
						int temp = newArr[j];
						newArr[j] = newArr[j + 1];
						newArr[j + 1] = temp;
					}
				} else {
					if (newArr[j] < newArr[j + 1]) {
						int temp = newArr[j];
						newArr[j] = newArr[j + 1];
						newArr[j + 1] = temp;
					}
				}
			}
		}
		// 遍历输出
		for (int i : newArr) 
			System.out.print(i + " ");
	}
}
