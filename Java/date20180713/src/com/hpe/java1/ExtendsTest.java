package com.hpe.java1;

import org.junit.Test;

public class ExtendsTest {
	
	//Java只支持单继承，不支持多继承
	//一个子类只能有一个父类，但一个父类可以有多个子类
	@Test
	public void test(){
		
		Dog dog = new Dog();
		
		dog.watchDoor();
		dog.shout();
		
	}

}
