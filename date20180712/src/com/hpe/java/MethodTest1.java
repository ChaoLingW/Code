package com.hpe.java;
/**
 * 
 * @author chaoling
 * @date 2018年7月12日上午9:55:12
 * @Description
 */
public class MethodTest1 {
	
	//方法参数传递：值传递
	//参数是基本数据类型：传递的是数值
	//参数是引用数据类型：传递的是地址值      

	public static void main(String[] args) {

		int a = 1;
		int b = 2;
		
		System.out.println(a + " " + b);//1 2
		
		swap(a,b);
		
		System.out.println(a + " " + b);//1 2
		
		int[] arr = {1,2,3,4,5};
		
		//打印arr中所有的元素
		show(arr);//1 2 3 4 5 
		//调用intArrayPlus
		intArrayPlus(arr);
		//打印arr中所有的元素
		show(arr);// 2 3 4 5 6
		
		
	}
	
	//方法：交换两个int数据
	//参数 ：两个int
	//返回值: void
	public static void swap(int a,int b){
		
		/*
		a = a + b;
		b = a - b;
		a = a - b;*/
		
		//交换
		int temp = a;
		a = b;
		b = temp;
		
		System.out.println(a + " " + b);
		
	}
	
	//方法:传过来一个int[],将其中的元素+1
	//参数：int[]
	//返回值：void
	
	public static void intArrayPlus(int[] arr){
		
		//将数组中所有的元素+1
		for(int i = 0; i < arr.length;i++){
			arr[i] += 1;
		}
		
	}
	 
	//打印int[]中所有元素
	public static void show(int[] arr){
		
		//打印
		for(int i : arr)
			System.out.print(i + " ");
		
		System.out.println();
		
	}
}
