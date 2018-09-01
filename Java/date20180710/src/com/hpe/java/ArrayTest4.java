package com.hpe.java;

import org.junit.Test;

public class ArrayTest4 {

	@Test
	public void test1(){
		
		int[] a = new int[]{1,2,3,4,5};
		//遍历a中的元素
		show(a);//1 2 3 4 5
		//调用test方法,將a做为参数
		test(a);
		//int[] arr = a;
		//遍历a中的元素
		show(a);//2 3 4 5 6
		
	}
	
	
	//方法
	//功能：将传递过来的int[]中的元素+1
	
	public void test(int[] arr){
		
		//将数组中的每个元素加一
		for(int i = 0;i < arr.length; i++)
			
			arr[i] += 1;
		
		//这种方法不可以，只是改变变量x的值，未修改数组中元素的值
		/*for(int x:arr)
			x+=1;*/
		
	}
	
	public void show(int[] arr){
		
		//遍历
		for(int i: arr)
			System.out.print(i + " ");
		
	}
	
	
}
