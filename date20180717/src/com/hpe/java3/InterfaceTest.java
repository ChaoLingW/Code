package com.hpe.java3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class InterfaceTest {

	//Java只支持单继承，一个子类只能有一个父类，一个父类可以有多个子类
	//接口是抽象方法和常量值的定义的集合
	//即接口中只能定义抽象方法和常量
	//从本质讲，接口是一种特殊的抽象函数，只包含常量和方法的定义，而没有变量和方法的实现
	//接口定义的抽象方法其实可以理解为功能，具体的实现由类来实现
	//无构造器
	
	//interface A()
	
	//使用类去实现接口    使用implements：class B implements A{}
	//一个类去实现一个接口，那么这个类叫做实现类。这个类就有了接口中定义的功能，
	//具体如何实现功能由实现类完成（重写/实现接口中定义佛如抽象方法）
	
	//接口没有构造器，不能实例化
	
	
	@Test
	public void test(){
		
		Dog dog = new Dog();
		
		dog.bite();
		dog.watchDor();
		dog.shout();
		
		//多态
		Animal animal = new Dog();
		//编译看左边，运行看右边
		animal.shout();
		//向下转型
		if(animal instanceof Dog){
			((Dog) animal).bite();
		}
		
		//接口的多态性(子类 父类 -- 实现类 接口)
		System.out.println("________________");
		IWatchDoor watchDoor = new Dog();
		watchDoor.watchDor();
		
		IBite bite = new Dog();
		bite.bite();
		
		//List ArrayList
		List list = new ArrayList();//多态
		//解耦
		Map map = new HashMap<>();
		
		
		
		
		
	}
	
	
	
}
