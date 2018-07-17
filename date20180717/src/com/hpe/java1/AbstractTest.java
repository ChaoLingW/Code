package com.hpe.java1;

import org.junit.Test;

public class AbstractTest {
	
	@Test
	public void test(){
		/*
		Animal a1 = new Horse();//多态性
		a1.shout();*/
		
		shout(new Horse());
		shout(new Cat());
		shout(new TaiDi());
	}
	
	public void shout(Animal animal){
		animal.shout();
	}

}
