package com.hpe.java2;

import org.junit.Test;

public class StaticTest {

	//static修饰的属性：静态变量或者类变量，所有对象共享一份，一个对其修改，其它的也受影响
	//类变量随着类的加载而产生，实例变量随着对象的创建而创建
	@Test
	public void test(){
		
		Person p1 = new Person();
		p1.setAge(10);
		
		Person p2 = new Person();
		p2.setAge(20);

		System.out.println(p1.getAge());//10
		System.out.println(p2.getAge());//20
	
		//每个对象都有自己的一套副本，互不干扰
		
		p1.setLegs(2);
		p2.setLegs(4);
		
		System.out.println(p1.getLegs());//4
		System.out.println(p2.getLegs());//4
		
	}
}
