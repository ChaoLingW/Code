package com.hpe.java;

import java.util.Scanner;

import org.junit.Test;

public class ArraySort {

	// 冒泡排序
	// 原理：比较相邻的元素，如果第一个比第二个大，就交换他们两个
	// 对每一个相邻元素做同样的工作，从开始第一队到结尾的最后一堆
	@Test
	public void test1() {

		int[] arr = new int[] { 4, 1, 3, 6, 2, 5 };

		/*非冒泡排序
		 * for (int i = 0; i < arr.length - 1; i++) {// 选出几个最大的 length-1

			for (int j = i + 1; j < arr.length; j++) {// 比较几次：length-i-1
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

		}*/
		//n个元素排序，外层小于length-1，内层小于arr.length -i -1
		for (int i = 0; i < arr.length - 1; i++) {// 选出几个最大的 length-1

			for (int j = 0; j < arr.length -i -1; j++) {// 比较几次：length-i-1
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}

		}

		for (int i : arr)
			System.out.println(i);

	}

	// 从控制台 输入三个数，从小到大排列
	@Test
	public void test() {

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入第一个数");

		int a = sc.nextInt();

		System.out.println("请输入第二个整数");

		int b = sc.nextInt();

		System.out.println("请输入第三个整数");

		int c = sc.nextInt();

		// 如果a比b大，交换a,b，
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}

		// 如果b比c大，交换b,c; 此时c最大
		if (b > c) {
			int temp = b;
			b = c;
			c = temp;
		}

		// 如果a比b大，交换a,b，

		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}

		System.out.println("a:" + a + " b:" + b + " c:" + c);
	}

}
