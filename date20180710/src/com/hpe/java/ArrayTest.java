package com.hpe.java;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
/**
 * 
 * @author chaoling
 * @date 2018年7月10日上午10:22:35
 * @Description
 */
public class ArrayTest {

	public static void main(String[] args) {
		
		//test1();
		//test2();
		//test3();
		test4();
		
		
	}
	
	//问题
	public static void test1(){
		
		int[] a = new int[5];
		
		//如何取到数组中第一个元素
		System.out.println(a[0]);
		
		//如何取到数组中最后一个元素
		System.out.println(a[a.length-1]);
		
		int[] b = new int[5];
		
		//==，可以比较基本数据类型也可以比较引用数据类型。
		//比较基本数据类型时比较的是数值是否相等
		//比较引用数据类型时比较的是地址值
		//equals是方法，只能比较引用数据类型
		System.out.println(a==b);//false
		System.out.println(a[0]==b[0]);//true
		
		b = a;
		
		System.out.println(a==b);//true
		
		b[0] = 1;
		
		System.out.println(a[0]);//a[0]=1
		
	}
	
	public static void test2(){
		
		//静态初始化：初始化的时候，指定数组中元素的值，由系统决定数组的长度
		int[] a = new int[]{1,2,3};//静态初始化
		
		//简写
		int[] b = {1,2,3};//静态初始化的简写
		
		int[] c;
		c = new int[3];
		
		int[] d;
		d = new int[]{1,2,3};
		
		//该情况非法
		/*int[] e;
		e = {1,2,3};*/
		
	}
	
	//思考
	public static void test3(){
		
		//1
		int[] a = {1,2,3};
		int[] b = {1,2,3};
		
		System.out.println(a==b);//false
		
		//2
		int[] c = new int[3];
		c = new int[4];//运行时不报错，重新分配了
		
		System.out.println(c[3]);
		
		//3
		/*int[] d = new int[4];
		d= new String[5];*/
		
		//4
		/*int[] e = new int[3];
		a[1] = 1.0;*/
		//数组中只能存储同一类型的元素
		
	}
	
	//数组常见异常：数组下标越界异常ArrayIndexOutOfBoundsException，空指针NullPointerException
	public static void test4(){
		
		//默认初始化：
		//基本数据类型
		// byte short int long --0
		//float doubel 		--0.0
		//char 			-- 空格
		//boolean      --false
		//引用数据类型 默认初始化为null
		
		
		//空指针NullPointerException
		/*int[] a = null;
		
		System.out.println(a.length);*/
		boolean[] c = new boolean[2];
		System.out.println(c[0]);
		
		String[] b = new String[3];
		System.out.println(b[1]);
		
		//b[1].trim();//空指针异常
		
	}
	
	
	
	
}