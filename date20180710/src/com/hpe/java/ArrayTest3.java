package com.hpe.java;

import java.util.Scanner;

import org.junit.Test;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class ArrayTest3 {

	//数组元素逆序
	@Test
	public void test1(){
		
		int[] a = {1,2,3,4,5};
		int temp;
		
		/*//0-3
		temp = a[0];
		a[0] = a[3];
		a[3] = temp;
		
		//1-2
		temp = a[1];
		a[1] = a[2];
		a[2] = temp;
		
		//调用show(a)
		show(a);*/
		
		//交换几次 --> length/2
		
		for(int i = 0; i < a.length/2; i++){
			
			//交换
			temp = a[i];
			a[i] = a[a.length -1-i];
			a[a.length -1-i] = temp;
			
		}
		
		//遍历
		show(a);
	
	}
	
	//交换
	@Test
	public void test2(){
		
		int a = 1;
		int b = 2;
		
		System.out.println("a:" + a +",b" + b);
		
		//借助于第三个变量
		/*int temp = a;
		a = b;
		b = temp;
		*/
		
		//不借助第三个变量
		a = a + b;
		b = a - b;
		a = a -b;
		
		System.out.println("交换后");
		System.out.println("a:" + a +",b" + b);
		
	}
	
	//方法：遍历数组中的元素
	//参数：数组
	//返回值：void
	
	public void show(int[] arr){
		
		//遍历
		for(int i: arr)
			System.out.print(i + " ");
		
	}
	
	//数组元素逆序
	@Test
	public void test3(){
			
		int[] a = {1,2,3,4,5,8};
		int temp;
		
		//最前与最后交换，之后最前++，最后--，只要最前小于最后那么就接着循环
		for(int begin  = 0,end = a.length - 1;begin<end;begin ++,end--){
			
			temp = a[begin];
			a[begin] = a[end];
			a[end] = temp;
		}
			
		//遍历
		show(a);
		
		}
	
	//数组元素查找(查找指定元素第一次在数组中出现的索引)
	@Test
	public void test4(){
		
		int[] a = new int[]{3,2,1,3,2,1};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入要查找的数值");
		
		int num = sc.nextInt();
		int index = -1;
		
		for(int i = 0; i < a.length; i++){
			
			//判断num是否与数组中元素值相同，如果相等了，后面的就无需比较（break）
			if(num == a[i]){
				index = i;
				break;
			}
			
		}
		
		System.out.println(index);
	}
	
}
