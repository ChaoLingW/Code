package com.hpe.java;

/**
 * 
 * @author chaoling
 * @date 2018年7月16日上午9:44:04
 * @Description
 */
//super关键字
//super.属性，调用父类的属性
//super.方法，调用父类被覆盖的方法
//super(..)，调用父类的构造方法
//如果子类中构造器中没有super(...),默认会调用父类的无参构造器
//子类构造器中必然会调用父类的构造器
//在子类调用父类的构造器时，加载继承父类属性
//在调用完父类的构造器后，显示初始化
//若子类构造其中还有赋值语句，则进行赋值

public class Student extends Person{
	
	private String number = "1002";//学号,显示初始化

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public void study() {
		//打印父类study()
		super.study();
		
		System.out.println("好好学习");
		
	}

	public Student(String number) {
		super();
		//显示初始化
		System.out.println("Student");
		System.out.println(this.number);//1002
		this.number = number;
		System.out.println(this.number);//10001
	}

	public Student(int age, String sex, String name, String number) {
		super(age, sex, name);//给age/sex/name属性赋值
		this.number = number;
	}
	
	
	
	

}
