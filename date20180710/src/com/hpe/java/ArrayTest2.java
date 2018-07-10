package com.hpe.java;

public class ArrayTest2 {

	public static void main(String[] args) {

		// test1();
		// test2();
		// test3();
		int[] a = { 1, 2, 34, 3, 5 };

		int max = new ArrayTest2().getMax(a);

		System.out.println(max);

		int[] b = { 101, 2, 34, 3, 5 };

		int max2 = new ArrayTest2().getMax(b);

		System.out.println(max2);

	}

	// 数组最大值问题
	public static void test1() {

		int[] a = { 2, 1, 8, 9, 5 };// 静态初始化

		// 获取数组a中的最大的元素的值并打印
		// int max = 0;//会出现此时初始化的max的值就是最大的值
		int max = a[0];// 保存最大元素的变量，初始化假设最大的是a[0]

		// 遍历数组中的所有元素，与max比较。如果比max大，那么就将这个值赋值给max
		/*
		 * for(int i: a) //如果当前元素比max还大，那么就将这个值赋值给max if(max < i) max = i;
		 */
		// max已经是a[0]个，所以可以从a[1]开始比较
		for (int i = 1; i < a.length; i++) {

			if (max < a[i])
				max = a[i];

		}

		// max是数组中元素的最大值
		System.out.println(max);

	}

	// 数组最小值问题
	public static void test2() {

		int[] a = { 2, 1, 8, 9, 5 };// 静态初始化

		// 获取数组a中的最小的元素的值并打印
		// int min = 0;//会出现此时初始化的min的值就是最小的值
		int min = a[0];// 保存最小元素的变量，初始化假设最小的是a[0]

		// 遍历数组中的所有元素，与min比较。如果比min大，那么就将这个值赋值给min
		/*
		 * for(int i: a) //如果当前元素比min还小，那么就将这个值赋值给min if(min > i) min = i;
		 */
		// min已经是a[0]个，所以可以从a[1]开始比较
		for (int i = 1; i < a.length; i++) {

			if (min > a[i])
				min = a[i];

		}

		// max是数组中元素的最大值
		System.out.println(min);

	}

	// 数组求和
	public static void test3() {

	}

	// 方法：求数组中最大值
	// 1.参数：数组类型
	// 2.功能：求数组中的最大值
	// 3.返回值：数组类型

	public int getMax(int[] arr) {

		// 求数组中最大值
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (max < arr[i])
				max = arr[i];

		}

		return max;

	}
	
	

}
