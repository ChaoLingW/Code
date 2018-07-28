package com.hpe.java4;

public class Test {

	public static void main(String[] args) {
		System.out.println("题五");

		Student s1 = new Student("zhangsan", 20, "nan", "001");
		Student s2 = new Student("lisi", 20, "nan", "002");
		Student s3 = new Student("wangzu", 20, "nan", "003");

		s1.showInfo();
		s2.showInfo();
		s3.showInfo();
	}
}
