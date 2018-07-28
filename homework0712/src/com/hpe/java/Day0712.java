package com.hpe.java;

import org.junit.Test;

/**
 * 
 * @author chaoling
 * @date 2018年7月12日下午5:51:55
 * @Description
 */
public class Day0712 {

	public static void main(String[] args) {

		Circle circle = new Circle(10);
		circle.show();

		Person person = new Person("zhangsan", 20, "nan");

		person.addAge(2);
		person.showAge();
		person.study();

		Person p = new Person("lisi", 18, "nv");

		p.addAge(2);
		p.showAge();
		p.study();
		
		calculate(2);
		calculate(2,3);
		calculate("calculate");
		
		fibonacci(7);
	}
	
	//两个数据之和的方法
	//仅考虑int类型的情况
	public int add(int a,int b){
		return a+b;
	}
	
	//判断两个数据是否相等的方法
	public boolean isEqual(int a,int b){
		//如果相等，返回true，否者返回false
		if(a == b)
			return true;
		else
			return false;
	}
	
	//)获取两个数中较大的值的方法
	public int max1(int a,int b){
		return (a > b) ? a : b;
	}
	
	//打印m行n列的星形矩形的方法
	public void rectangle(int a,int b){
		//控制输出的行数
		for(int i = 0; i < a; i++){
			//控制输出的列数
			for(int j = 0; j < b; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//打印nxn乘法表的方法
	public void multiplicationTable( int n){
		//控制输出的行数
		for(int i =1; i <= n; i++){
			//控制输出的列数
			for(int j = 1; j <= i;j++){
				System.out.printf("%d * %d = %d ",j,i,i*j);
			}
			System.out.println();
		}
	}
	
	/*
	定义三个重载方法并调用。方法名为calculate。
	三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
	在main方法中分别调用三个方法。
	 */
	
	public static void calculate(int a){
		System.out.println((int)Math.pow(a, 2));
	}
	
	public static void calculate(int a,int b){
		System.out.printf("%d * %d = %d \n",a,b,a*b);
	}
	
	public static void calculate(String str){
		System.out.println(str);
	}
	
	/*
	定义三个重载方法max，第一个方法求两个int值中的最大值，第二个方法求两个double值中的最大值，第三个方法求三个double值中的最大值，并分别调用三个方法。
	二、之前作业改称方法
	 */
	public static int max(int a,int b){
		return (a>b)?a:b;
	}
	
	public static double max(double a,double b){
		return (a>b)?a:b;
	}
	public static double max(double a,double b,double c){
		return (a>b) ? ((a>c)? a : c):((b > c) ? b : c);
	}
	
	//输出1 1 2 3 5 8 13……这样的Fibonacci数列，输出该数列的前20个数字
	public static void fibonacci(int n){
		
		int temp;//用于交换
		int front=0;//用于保存第i-1位Fibonacci数列的值
		int current = 1;//用于保存第i位Fibonacci数列的值
		for(int i = 0; i< n; i++){
			//记录第i位Fibonacci数列的值
			temp = current; 
			//输出记录第i位Fibonacci数列的值
			System.out.print(current + " ");
			//计算第i+1位Fibonacci数列的值
			current += front;
			//后移，即第i+1位Fibonacci数列元素前面的值是第i位
			front = temp;
		}
	}
	
	//判断一个数组中是否存在相同的元素，如果存在相同的元素则输出“重复”，否则输出“不重复”
	public static void isEqual(int[] arr){
		//遍历数组，从前到后
		//首先用第i个元素与之后的元素比较，需要比较arr.length-1次
		for(int i = 0; i < arr.length-1; i++){
			//从第i+1个元素开始比较，一直到最后一个
			for(int j = i+1; j <arr.length;j++){
				//如果arr[i]与它之后的元素（假设为arr[j]有相等的，输出相等，结束函数
				if(arr[i]==arr[j]){
					System.out.println("重复");
					return;
				}
			}
		}
		//能执行到这，表示不存在重复的元素
		System.out.println("不重复");
	}

	@Test
	public void christmasTree(int n){
		//控制输出的行数，n表示输出的行数
		for(int i = 0; i < n; i++){
			//控制输出的空格数 第i行需要输出的空格n-i
			for(int j = 0; j < n-i; j++)
				System.out.print(" ");
			//控制输出的*数 第i行需要输出的*n-i
			for(int j =0; j< i*2+1;j++)
				System.out.print("*");
			//外层循环每执行一次，换行
			System.out.println();
		}
	}	
}