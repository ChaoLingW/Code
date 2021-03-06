package com.hpe.java3;

/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午6:38:02
 * @Description
 */
/*
编写Addition类，
该类中应包含一组实现两数相加运算的重载方法。
实现加法运算的方法，应接受两个参数（即加数和被加数），
方法将两个参数进行加法运算后，返回相加结果。
考虑可能针对不同的数据类型进行计算，重载一组方法，
包括整型、长整型、浮点型、双精度浮点型、还有字符串。
在main方法中创建Addition类的实例，分别调用重载方法测试其效果。
应将Addition类打入到包中，以com.hpepm.java为包名。
*/
public class Addition {
	
	//int型
	public int add(int a, int b){
		return a+b;
	}
	//long型
	public long add(long a, long b){
		return a+b;
	}
	//float型
	public float add(float a, float b){
		return a+b;
	}
	//double
	public double add(double a, double b){
		return a+b;
	}
	//String
	public String add(String a, String b){
		return a+b;
	}

}
