package com.hpe.java;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author chaoling
 * @date 2018年7月11日上午9:34:50
 * @Description
 */
public class ArraySort {

	// 选择排序

	@Test
	public void test1() {

		int[] arr = { 3, 1, 0, 5, 2 };

		// 从小到大
		// 选择排序
		// 初始在序列中找到最小（大）元素，放到序列的起始位置作为已排序序列，
		// 然后，再从剩余元素中选择最小（大）的元素。

		for (int i = 0; i < arr.length - 1; i++) {// 选出几个最小的arr.length - 1

			// 定义一个变量保存最小元素的索引
			int minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {// j --> 要比较元素的索引
														// 比较length-1-i次
				// 将最小的元素与当前元素比较
				// 如果当前元素小于最小元素比较，那么这个元素的索引应该赋值给minIndex
				if (arr[minIndex] > arr[j])
					minIndex = j;

			}

			// minIndex就是当前这次最小的索引
			// 将minIndex与i对应的元素交换
			if (minIndex != i) {

				int temp;
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
				
			}

		}

		for (int i : arr) 
			System.out.println(i);

	}

	@Test
	public void test2(){
		
		//Arrays中sort方法使用
		
		int[] arr = { 2, 1, 3, 7, 0 };
		Arrays.sort(arr);
		for (int i : arr) 
			System.out.println(i);
		
		
	}
}
