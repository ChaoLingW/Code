package com.hpe.java8;

import java.util.Scanner;

import com.hpe.java.Min;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入需要比较的整数的个数");

		int num = sc.nextInt();
		int[] arr8 = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.printf("请输入第%d个整数\n", (i + 1));
			arr8[i] = sc.nextInt();
		}
		System.out.println("最小的整数是：" + Min.min(arr8));
	}
}
