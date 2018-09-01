package com.hpe.java7;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午7:23:27
 * @Description
 */
/*建立一个学生类，其中成员变量为学号、姓名、及三门课的成绩（数组），另建立一个包含主方法的类，定义2个学生类的对象*/
public class Student {

	private String no;
	private String name;
	private float[] score;
	
	public Student(String no, String name, float[] score) {
		super();
		this.no = no;
		this.name = name;
		this.score = score;
	}


	public Student() {
		super();
	}

}
