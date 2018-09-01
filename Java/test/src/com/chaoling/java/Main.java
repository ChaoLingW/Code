package com.chaoling.java;

import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * @author chaoling
 * @date 2018年7月11日上午9:33:26
 * @Description
 */
public class Main {

	void speak(int old){
		System.out.println("我今年"+old+"岁了");
		old=12;
		
	}
	@Test
	public void show(){
		int old = 22;
		speak(old);
	}
}
