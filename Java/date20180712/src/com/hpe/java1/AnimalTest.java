package com.hpe.java1;

import org.junit.Test;

public class AnimalTest {

	@Test
	public void test(){
		
		
		Animal animal = new Animal();
		
		//设置age属性
		animal.setAge(10);
		
		//设置sex属性
		animal.setSex("公");
		
		System.out.println(animal.getAge());
	}

}
