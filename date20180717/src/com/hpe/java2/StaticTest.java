package com.hpe.java2;

import org.junit.Test;
/**
 * 
 * @author chaoling
 * @date 2018年7月17日上午9:53:34
 * @Description
 */
public class StaticTest {

	//static修饰的属性：静态变量或者类变量，所有对象共享一份，一个对其修改，其它的也受影响
	//类变量随着类的加载(只加载一次)而产生，实例变量随着对象的创建而创建
	//先加载类后创建对象-->类变量的加载要早于对象
	//类变量，可以使用类名.属性名的方式设置值（访问权限允许）
	//不能使用类名.的方式去访问实例变量
	//静态方法也是随着类的加载而加载，早于对象的加载
	//先有的不能调用后有的，后有的可以调用先有的
	//在静态方法中，不能调用非静态的属性、方法，只能调用静态的属性、方法
	//在非静态方法中，能调用非静态的属性、方法以及静态的属性、方法
	//在静态方法中，不能出现this和super
	//不因对象的不同而改变的属性设为类属性
	//方法与调用者无关，这种方法声明为类方法
	@Test
	public void test(){
		
		Person p1 = new Person();
		p1.setAge(10);
		
		Person p2 = new Person();
		p2.setAge(20);

		System.out.println(p1.getAge());//10
		System.out.println(p2.getAge());//20
	
		//每个对象都有自己的一套副本，互不干扰
		
		//p1.setLegs(2);
		Person.setLegs(2);
		//p2.setLegs(4);
		Person.setLegs(4);
		
		System.out.println(Person.getLegs());//4
		System.out.println(Person.getLegs());//4
		
		Person.legs = 10;
		System.out.println(Person.legs);//10
		
	}
	
	@Test
	public void test2(){
		
		Person p1 = new Person();
		
		p1.staticTest();
		
		//静态的方法，使用类名.方法名的方式调用静态的方法
		Person.staticTest();
		
		//非静态的方法，只能用对象名.方法名的方式来调用
		
	}
	
	@Test
	public void test3(){
		
		Person p1 = new Person();
		Person p2 = new Person();
		
		
	}
}
