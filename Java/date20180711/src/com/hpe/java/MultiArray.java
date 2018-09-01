package com.hpe.java;

import org.junit.Test;

public class MultiArray {

	@Test
	public void test1() {

		// 二维数组
		int[][] arr = new int[5][];// 第一维不能为空

		System.out.println(arr.length);

		arr[0] = new int[5];
		arr[1] = new int[5];
		arr[2] = new int[5];
		arr[3] = new int[5];
		arr[4] = new int[5];

		int[][] arr1 = new int[5][4];

	}

	@Test
	public void test2() {

		// 动态数组
		int[][] arr = new int[4][];

		arr[0] = new int[3];
		arr[1] = new int[2];
		arr[2] = new int[2];

		System.out.println(arr.length);// 3

		System.out.println(arr[2].length);// 2

		// System.out.println(arr[3].length);//空指针异常 arr[3] == null;

		// 给二维数组中的第一个元素赋值
		arr[0][0] = 1;

		// 静态初始化
		int[][] arr1 = { { 1, 2 }, { 2, 1, 3 }, { 3, 2, 1 } };

	}

	@Test
	public void test3() {

		//利用for循环嵌套实现二维数组的遍历
		int[][] arr = { { 1, 2 }, { 2, 1, 3 }, { 3, 2, 1 } };

		for(int i = 0; i < arr.length; i++){
			
			//arr1[i]--二维数组中指定位置的元素，支部哦这个元素还是数组
			for(int j = 0; j < arr[i].length; j++){
				
				System.out.print(arr[i][j] + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	@Test
	public void test4(){
		
		//利用foreach实现二维数组的遍历
		int[][] arr = { { 1, 2 }, { 2, 1, 3 }, { 3, 2, 1 } };
		
		for(int[] i : arr){
			
			for(int j : i){
				
				System.out.print(j + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	@Test
	public void test5(){
		
		int[] arr = {1,2,3};
		//元素的类型(数组中所存放的元素的类型) 变量名 : 数组名
		for(int x : arr){
			
			System.out.print(x + " ");
			
		}
		
	}

}
