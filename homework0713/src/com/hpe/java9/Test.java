package com.hpe.java9;

public class Test {
	public static void main(String[] args) {
		System.out.println("题十");
		Person person90 = new Person("zhangsan",20);
		Person person91 = new Person("lisi",20,"jining");
		Person person92 = new Person("wangwu",20,"jining","student");
		
		person90.show();
		person91.show();
		person92.show();	}
}
