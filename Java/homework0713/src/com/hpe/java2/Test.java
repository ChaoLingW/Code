package com.hpe.java2;

public class Test {
	public static void main(String[] args) {
		System.out.println("题三");
		Student[] student = new Student[5];
		student[0] = new Student("001", "刘一", "男", 10, 88);
		student[1] = new Student("002", "陈二", "女", 11, 65);
		student[2] = new Student("003", "张三", "男", 12, 33);
		student[3] = new Student("004", "李四", "女", 13, 75);
		student[4] = new Student("005", "王五", "男", 14, 95);
		//输出每个学生的信息		
		for (Student s : student) 
			System.out.println(s.toString());
		//计算并输出这五个学生Java语言成绩的平均值，以及计算并输出他们Java语言成绩的最大值和最小值。（思路：对象数组）
		Student.value(student);
	}
}
