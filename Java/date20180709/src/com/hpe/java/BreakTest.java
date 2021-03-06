package com.hpe.java;

import java.util.Scanner;

/**
 * 
 * @author chaoling
 * @date 2018年7月9日下午4:00:15
 * @Description
 */
public class BreakTest {

	public static void main(String[] args) {

		//test1();
		//test2();
		test3();
		
	}
	
	//break：跳出当前整个循环
	public static void test1(){
		
		for(int i = 0; i <3; i++){
			
			for(int j = 0; j < 3; j++){
				
				if(j == 1)
					break;
				
				System.out.println("i:" + i + "j:" + j);
				
			}
			
		}
		
	}
	
	/*循环录入5个人的年龄，
	并计算平均年龄，
	如果录入的数据出现负数
	或者大于130的数，
	立即停止输出报错*/
	public static void test2(){
		
		int age;
		int i;
		double sum = 0;//总年龄
		boolean flag = true;//标志
		Scanner sc = new Scanner(System.in);
		
		for(i = 1; i < 6; i++){
			
			System.out.println("请输入第" + i + "个人的年龄");
			
			age = sc.nextInt();
			
			//判断年龄是否合法：年龄小于0或或者年龄大于130
			//如果不合法——>结束整个for循环
			if(age < 0 || age > 130){
				
				flag = false;
				//结束整个for循环
				break;
				
			}
			else{
				sum += age;
			}
			
		}
		
		//是否打印平均年龄-->什么时候打印年龄？-->五个年龄没问题-->当i=5代表正常结束for循环
		if(i == 5){
			System.out.println("平均年龄为" + (sum/5));
		}else{
			System.out.println("输入错误");
		}
		
	}
	
	/*循环录入5个人的年龄，
	并计算平均年龄，
	如果录入的数据出现负数
	或者大于130的数，
	立即停止输出报错*/
	public static void test3(){
		
		int age;
		double sum = 0;//总年龄
		boolean flag = true;//标志
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i < 6; i++){
			
			System.out.println("请输入第" + i + "个人的年龄");
			
			age = sc.nextInt();
			
			//判断年龄是否合法：年龄小于0或或者年龄大于130
			//如果不合法——>结束整个for循环
			if(age < 0 || age > 130){
				
				//将标志位设置为false
				flag = false;
				//结束整个for循环
				break;
				
			}
			else{
				sum += age;
			}
			
		}
		
		//判断什么时候但因平均年龄，什么时候打印有误
		if(flag){
			//打印平均年龄
			System.out.println("平均年龄为" + (sum/5));
		}else{
			//打印有误
			System.out.println("输入错误");
		}
		
	}

}
