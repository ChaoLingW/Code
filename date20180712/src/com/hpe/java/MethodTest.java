package com.hpe.java;

public class MethodTest {

	public static void main(String[] args) {
		/*
		//计算五个同学的平均成绩
		int s1 = 10;
		int s2 = 20;
		int s3 = 30;
		int s4 = 40;
		int s5 = 50;
		
		//1.求和n
		int sum = s1+s2+s3+s4+s5;
		
		//2.计算平均值
		int avg = sum/5;
		
		//3.打印
		System.out.println(avg);
		*/
		
		int i = 2;
		int j = 4;
		
		//计算i+j的值
		int sum = intSum(i, j);
		
		//打印
		System.out.println(sum);
		String s = " ";
		
	}
	
	//计算两个int类型数据的和，并返回
	//参数：两个，类型都是int
	//返回值：
	public static int intSum(int a, int b){
		
		//功能
		//1.求和
		int sum ;
		sum = a + b;
		
		//2.返回和
		return sum;
		
	}
	
	public void aaa(int a,String s){
		
	}
	
	

}
