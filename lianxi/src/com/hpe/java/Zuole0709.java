package com.hpe.java;

import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Zuole0709 {

	public static void main(String[] args) {

		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		
	}

	public static void test1() {

		//定义一个int[] a =｛4，2，0，-1，-8，23，9｝求数组元素的最大值、最小值、平均数、总和、数组的复制、反转
		int[] a = { 4, 2, 0, -1, -8, 23, 9 };
		int max = 0;
		int min = 0;
		double avg = 0;
		int sum = 0;

		for (int i = 0; i < a.length; i++) {

			if (max < a[i])
				max = a[i];

			if (min > a[i])
				min = a[i];

			sum += a[i];

		}

		avg = sum / a.length;

		System.out.println("最大值" + max);
		System.out.println("最小值" + min);
		System.out.println("平均数" + avg);
		System.out.println("总   和" + sum);

		int[] b = a.clone();

		System.out.println("数组的复制");
		
		for (int i = 0; i < b.length; i++) {
			
			System.out.print(b[i] + " ");
			
		}
		
		System.out.println();
		System.out.println("数组的反转");
		
		int[] c = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			
			c[a.length - i - 1] = a[i];
			
		}

		for (int i = 0; i < c.length; i++) {
			
			System.out.print(c[i] + " ");
			
		}

	}

	public static void test2() {

		// 数组元素的排序从键盘输入5个人的年龄，全部输入完后打印。
		Scanner sc = new Scanner(System.in);

		int arr[] = new int[5];
		int temp;

		for (int i = 0; i < 5; i++) {

			System.out.println("请输入第" + (i + 1) + "个人的年龄");

			arr[i] = sc.nextInt();
			
			//直接插入排序
			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j]) {
					
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;

				}
				
			}

		}
		
		System.out.println("排序后");

		for (int i = 0; i < 5; i++) {
			
			System.out.print(arr[i] + " ");
			
		}

	}

	public static void test3() {

		// 从键盘输入10个整数存入在一个数组中，计算所有元素之和及平均值，并找出最大值和最小值
		Scanner sc = new Scanner(System.in);
		double avg;
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			
			System.out.println("请输入第" + (i + 1) + "个数");

			arr[i] = sc.nextInt();
			
		}
		
		int max = arr[0];
		int min = arr[0];
		int sum = 0;
		
		for (int i = 0; i < 10; i++) {

			if (max < arr[i])
				max = arr[i];

			if (min > arr[i])
				min = arr[i];

			sum += arr[i];
			
		}

		avg = sum / 10;

		System.out.println("最大值" + max);
		System.out.println("最小值" + min);
		System.out.println("平均数" + avg);
		System.out.println("总   和" + sum);
		
	}
	
	public static void test4(){
		
		//将数组{4,0,5,8,2,0,6,8,3}中的0去掉后返回一个新数组。
		int[] arr = {4,0,5,8,2,0,6,8,3};
		int count = 0;
		
		for(int i = 0; i < arr.length; i++){
			
			//遍历数组，计算数组元素中0的个数
			if(arr[i] == 0){
				
				count ++;
				arr[i] = arr[i + 1];
				
			}
				
		}
		
		for(int i = 0; i < arr.length - count; i++ ){
			
			System.out.println(arr[i]);
			
		}
		
	}
	
	public static void test6(){
		
		//输出1 1 2 3 5 8 13……这样的Fibonacci数列，输出该数列的前20个数字
		int[] arr = new int[20];
		
		System.out.println("前20位的Fibonacci数列");
		
		for(int i = 0; i < 20; i++){
			
			if(i < 2)
				arr[i] = 1;
			else
				arr[i] = arr[i-1] + arr[i-2];
			
			System.out.print(arr[i] + " ");
			
		}
		
	}
	
	public static void test7(){
		
		/*歌手打分：在歌唱比赛中，共有10位评委进行打分
		    在计算歌手得分时，去掉一个最高分，去掉一个最低分，
		    然后剩余的8位评委的分数进行平均，就是该选手的最终得分。
		    输入每个评委的评分，求某选手的得分。*/
		//方式一
		/*int sum = 0;
		double avg;
		int max = 0;
		int min = -1;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++){
			
			System.out.println("请输入得分：");
			int score = sc.nextInt();
			
			if(i ==0){
				max = score;
				min = score;
			}
			if(max < score )
				max = score;
			
			if(min > score)
				min = score;
			
			sum += score;
			
		}
		System.out.println(sum);
		System.out.println(max);
		System.out.println(min);
		sum = sum - max - min;
		
		avg = sum / 8.0;
		
		System.out.println("选手的得分为：" + avg);*/
		
		//方式二
		int sum = 0;
		double avg;
		int[] score = new int[10];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++){
			
			System.out.println("请输入得分：");
			score[i] = sc.nextInt();
			
		}
		
		int max = score[0];
		int min = score[0];
		
		for (int i = 0; i < score.length; i++) {
			if(i ==0){
				max = score[i];
				min = score[i];
			}
			if(max < score[i] )
				max = score[i];
			
			if(min > score[i])
				min = score[i];
			
			sum += score[i];
			
		}
		
		System.out.println(sum);
		System.out.println(max);
		System.out.println(min);
		
		sum = sum - max - min;
		avg = sum / 8.0;
		
		System.out.println("选手的得分为：" + avg);
		
	}
	
	public static void test8(){
		
		int[] arr = {1,2,3,1,0};
		boolean flag = false;
		
		for(int i = 0; i < arr.length; i++){
			
			for(int j = 0; j < i; j ++){
				
				if(arr[i] == arr[j]){
					
					flag = true;
					break;
					
				}
				
			}
			
		}
		
		if(flag)
			System.out.println("重复");
		else
			System.out.println("不重复");
		
	}
	
	public static void test9(){
		
		int[] arr = new int[8];
		int num = 35;
		
		for(int i = 7; i > 0; i--){
			
			arr[i] = num %2;
			num /= 2;
			
		}
		
		boolean flag = false;
		
		for(int i = 0; i < 8; i++){
			
			if(arr[i] !=0)
				flag = true;
			
			if(flag)
				System.out.print(arr[i]);
			
		}
		
	}

}
