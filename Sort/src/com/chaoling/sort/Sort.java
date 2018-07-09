package com.chaoling.sort;

/**
 * 
 * @author chaoling
 * @date 2018年7月9日下午11:31:57
 * @Description
 */
public class Sort {

	public static void main(String[] args) {

	}
	
	public static void DirectInsertionSort(){
		//假设前i-1个元素是有序的，第i个元素依次从第i-1个元素比较，直到找到一个比第i个元素值小的元素，而后插入，插入位置及其后的元素依次向后移动
	}
	
	public static void ShellSort(){
		//将整个待排记录分割成若干子序列，然后分别进行直接插入排序，待整个序列中的记录基本有序时，在对全体记录进行一次直接插入排序
		//先分组，组内直接插入排序，之后在分组，在直接插入排序
		
	}

	public static void StraightSelectSort(){
		//简单选择/直接选择
		//每次选择出最小的元素进行交换，交换过程只有一次
	}
	
}
