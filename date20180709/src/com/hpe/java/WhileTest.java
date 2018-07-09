package com.hpe.java;

import java.util.Scanner;

/**
 * 
 * @author chaoling
 * @date 2018年7月9日上午8:41:21
 * @Description  while,do-while语句的练习
 */
public class WhileTest {
	
	public static void main(String[] args) {
		
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		test7();
		
	}
	
	//课文打印10遍——顺序结构
	public static void test1(){
		
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土!");
		System.out.println("锄禾日当午，汗滴禾下土！");
		System.out.println("锄禾日当午，汗滴禾下土!");
			
	}
	
	//课文打印十遍——while
	public static void test2(){
		
		//1.条件 --> 什么时候执行循环体
		//次数小于10次
		int count = 0;//次数
		
		while(count < 10){
			
			//2.循环体是什么
			//2.1打印课文
			System.out.println("第" + (count + 1) +"遍 ：锄禾日当午，汗滴禾下土!");
			
			//2.2次数加一
			count ++;
			
		}
		
	}
	
	//从控制台输入打印的次数
	public static void test3(){
		
		//从控制台获取输入
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入需要打印的次数");
		
		int sumCount = sc.nextInt();
		int count = 0;
		
		while (count < sumCount) {
			
			System.out.println("第" + (count + 1) +"遍 ：锄禾日当午，汗滴禾下土!");
			
			count ++;
			
		}
		
	}
			
	//使用while循环方式打印100以内4的倍数
	public static void test4(){
		
		//方式一
		//打印1-100所有的数
		int num = 1;
		
		System.out.println("100以内4的倍数");
		
		while(num <= 100){
			
			//什么时候才打印
			if(num % 4 == 0)
				System.out.println(num);
			
			num ++;
			
		}
		
		
		//方式二
		/*int count = 4;
		
		System.out.println("100以内4的倍数");
		
		while(count <= 100){
			
			System.out.print(count + " ");
			
			count += 4;
		}*/
		
	}
	
	/*你向你女朋友求婚，
	女朋友满意的话，求婚成功
	女朋友不满意的话，继续求婚，直到满意为止*/
	public static void test5(){
		
		Scanner sc = new Scanner(System.in);
		String answer;
		
		do{
			
			//求婚
			System.out.println("嫁给我吧！同意输入y，不同意输入n");
			
			//接受从控制台输入的内容
			answer = sc.nextLine();
			
			//判断answer是否合法，是否是y或者n
			//answer既不是y也不是n
			while(!"y".equals(answer) && !"n".equals(answer)){
				
				//打印输入有误
				System.out.println("输入有误，请重新输入");
				//重新输入
				
				answer = sc.nextLine();
			}
			
		}while(answer.equals("n"));//输入内容为n,继续求婚
		
		//求婚成功
		System.out.println("求婚成功");
	}
	
	/*你向你女朋友求婚，
	女朋友满意的话，求婚成功
	女朋友不满意的话，继续求婚，直到满意为止*/
	public static void test6(){
		
		Scanner sc = new Scanner(System.in);
		String answer;
		boolean flag = true; //标志
		
		do {
			
			System.out.println("嫁给我吧！同意输入y,不同意输入其他");
			
			answer = sc.nextLine();
			
			//如果flag是y,将flag设置为false-->结束do-while循环
			if("y".equals(answer))
				flag = false;
					
		} while (flag);
		
		//求婚成功
		System.out.println("求婚成功");
		
	}
	
	/*要求用户输入用户名和密码，
	 * 只要不是admin和111就提示用户名或密码不正确，请重新输入。
	 * 正确时结束循环，提示登陆成功*/
	public static void test7(){
		
		//方式一
		//定义用户名与密码，分别接受用户名和密码
		String userName;		//用户名
		String passwd;			//密码
		boolean flag = true;	//标志   
		//boolean flag = false;
		Scanner sc = new Scanner(System.in);
		
		do{
			
			System.out.println("请输入用户名");
			
			userName = sc.nextLine();
			
			System.out.println("请输入密码");
			
			passwd = sc.nextLine();
			
			//什么时候让flag变成false-->用户名是admin,密码是111
			if("admin".equals(userName) && "111".equals(passwd))
				flag = false;
			else{
				//flag = false的情况下
				//flag = true;
				
				System.out.println("用户名或密码不正确，请重新输入");
			}
			
		}while(flag);
		
		System.out.println("成功登录");
		
		/*//方式二
		//定义用户名与密码，分别接受用户名和密码
		String userName;		//用户名
		String passwd;			//密码
		Scanner sc = new Scanner(System.in);
				
		do{
					
			System.out.println("请输入用户名");
					
			userName = sc.nextLine();
					
			System.out.println("请输入密码");
					
			passwd = sc.nextLine();
					
			if("admin".equals(userName) && "111".equals(passwd))
				System.out.println("成功登录");
			else
				System.out.println("用户名或密码不正确，请重新输入");
					
		}while(!"admin".equals(userName) || !"111".equals(passwd));
		*/	
		
		
	}
	
}
