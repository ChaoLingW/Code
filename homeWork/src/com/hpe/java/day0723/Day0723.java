package com.hpe.java.day0723;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * @author chaoling
 * @date 2018年7月23日下午4:24:38
 * @Description
 */
public class Day0723 {

	@Test
	public void test(){
		
		List<String> list = new ArrayList<>();
		
		System.out.println("添加");
		list.add("laowang");
		list.add("小明");
		list.add("大头");
		list.add("xiaohong");
		
		System.out.println(list);
		System.out.println("删除小明");
		list.remove("小明");
		System.out.println(list);

		System.out.println("将laowang修改成老王");
		int indexOf = list.indexOf("laowang");
		list.set(indexOf, "老王");
		System.out.println(list);
		
		System.out.println("打印xiaohong");
		int index = list.indexOf("xiaohong");		
		
		System.out.println(list.get(index));
		
	}
	
	@Test
	public void duplicateRemova(){
		
		List list = new ArrayList<>();
		
		list.add(1);
		list.add(12);
		list.add(12);
		list.add(3);
		list.add(4);
		list.add(1);
		
		Set set = new HashSet<>();
		
		System.out.println("去重前");
		System.out.println(list);
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			
			Object object = iterator.next();
			set.add(object);
			
		}
		
		System.out.println(set);
		
	}
	
	@Test
	public void test2(){
		
		List<String> course = new ArrayList<>();
		
		System.out.println("向集合中添加三门课程：java、mysql、linux");
		course.add("java");
		course.add("mysql");
		course.add("linux");
		
		System.out.println("添加完成");
		System.out.println(course);
			
		System.out.println("第一种遍历方法");
		
		for(String str : course)
			System.out.println(str);

		System.out.println("第二种遍历方法");
		
		for(int i = 0; i < course.size();i++)
			System.out.println(course.get(i));
		
		System.out.println("第三中遍历方法");
		
		Iterator<String> iterator = course.iterator();
		
		while(iterator.hasNext())
			System.out.println(iterator.next());
				
				
	}
	
	
	
	
}
