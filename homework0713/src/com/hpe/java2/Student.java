package com.hpe.java2;

/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午6:00:02
 * @Description
 */
/*
 * 定义一个表示学生信息的类Student，要求如下： （1）类Student的成员变量： sNO
 * 表示学号；sName表示姓名；sSex表示性别；sAge表示年龄；sJava：表示Java课程成绩。 （2）类Student带参数的构造方法：
 * 在构造方法中通过形参完成对成员变量的赋值操作。 （3）类Student的方法成员： getNo（）：获得学号； getName（）：获得姓名；
 * getSex（）：获得性别； getAge（）获得年龄； getJava（）：获得Java 课程成绩
 * 根据类Student的定义，创建五个该类的对象，输出每个学生的信息，计算并输出这五个学生Java语言成绩的平均值，
 * 以及计算并输出他们Java语言成绩的最大值和最小值。（思路：对象数组）
 */
public class Student {

	private String sNO;
	private String sName;
	private String sSex;
	private int sAge;
	private int sJava;

	// 通过形参完成对成员变量的赋值操作
	public Student(String sNO, String sName, String sSex, int sAge, int sJava) {
		super();
		this.sNO = sNO;
		this.sName = sName;
		this.sSex = sSex;
		this.sAge = sAge;
		this.sJava = sJava;
	}

	public Student() {
		super();
	}

	public String getsNO() {
		return sNO;
	}

	public String getsName() {
		return sName;
	}

	public String getsSex() {
		return sSex;
	}

	public int getsAge() {
		return sAge;
	}

	public int getsJava() {
		return sJava;
	}

	@Override
	public String toString() {
		return "Student [sNO=" + sNO + ", sName=" + sName + ", sSex=" + sSex + ", sAge=" + sAge + ", sJava=" + sJava
				+ "]";
	}

	//计算并输出最大值和最小值与平均值
	public static void value(Student[] student) {

		double avg = 0.0;
		int sum = 0;
		int min;
		int max;
		min = max = student[0].getsJava();

		for (Student s : student) {
 
			// 比较获取最大值
			if (s.getsJava() > max)
				max = s.getsJava();
			// 比较获取最小值
			if (s.getsJava() < min)
				min = s.getsJava();
			// 求和
			sum += s.getsJava();
		}

		// 求平均分
		avg = sum /student.length;

		// 输出平均分，最大值，最小值
		System.out.println("平均分：" + avg + "  最大值：" + max + "  最小值" + min);
	}
}
