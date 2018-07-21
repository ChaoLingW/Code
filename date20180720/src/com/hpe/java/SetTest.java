package com.hpe.java;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetTest {

	//set:Set存放的元素是无序(不是随机的)的，不可重复的
	//set没有get()函数
	//遍历只有两种方式，foreach与Iterator方式
	@Test
	public void test(){
		
		Set set = new HashSet<>();
		
		set.add("abc");
		set.add("bcd");
		set.add("cde");
		set.add("def");
		set.add("def");
		
		Person p1 = new Person();
		Person p2 = new Person();
		//若没有重写equals,则set中下列两个对象都会添加进去（这两个对象地址不同）
		//若重写equals,则set只会添加一个，此时两个对象内容相同
		set.add(p1);
		set.add(p2);
		
		//调用equals方法判断
		
		System.out.println(set);
		
		
		
		
	}
	
	
}
