package com.hpe.java;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午7:37:52
 * @Description
 */

public class Min {
	//获取数组中的最小值并输出
	public static int min(int[] arr){
		
		int min;//存储最小值
		min = arr[0];
		
		for(int i : arr){
			if(min>i){
				min = i;
			}
		}
		
		return min;
	}

}
