package com.hpe.java1;
/**
 * 
 * @author chaoling
 * @date 2018年7月17日上午10:46:46
 * @Description
 */
//抽象类：使用abstract修饰
//特点：可以被继承，不能实例化（与final类相反）

//抽象类中包含?抽象类也是类，普通类里面有的抽象类里面也都有：属性、方法、代码块、构造器，抽象类中可以包含抽象方法

//抽象方法：使用关键字abstract修饰的方法，只有方法的声明（定义），没有功能

//抽象类与抽象方法的关系：抽象类不一定包含抽象方法，但是包含抽象方法的类，一定是抽象类
//子类中必须要有的，而且子类还有自己的实现的方法，即必须重写的方法
//为什么要定义抽象方法：
//一个类继承抽象类就必须重写抽象类中的抽象方法，否则这个类就是抽象类


//抽象类与一般类的比较
//相同点：都是用来描述事物的，都在内部定义成员
//不同
	//一般类有足够的星系描述事物，抽象类描述事物的信息可能不足
	//一般类中不能定义抽象方法们只能定义非抽象方法。抽象类中可定义抽象方法，同时也可以定义非抽象方法
	//一般类可以被实例化。抽象类不可以被实例化
//不能用abstract修饰属性，构造器，private,final,static
//凡是类都有构造器
public abstract class Animal {
	
	//属性
	private int age;
	private String sex;
	
	//方法
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	//抽象方法：只有方法的定义，没有具体的功能
	public abstract void shout();
	
}
