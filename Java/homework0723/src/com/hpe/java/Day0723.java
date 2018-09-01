package com.hpe.java;

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

	/*
	 * 1.创建一个容器
	 * 添加一些字符串  laowang 小明 大头 xiaohong 
	 *  删除 小明
	 * 将laowang修改成老王 
	 * 打印这个xiaohong
	 */
	@Test
	public void test() {

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

	/*
	 * 2.ArrayList容器元素去重(元素为字符串) 一个容器中有重复的元素，写一个方法去掉容器中的重复元素
	 */
	@Test
	public void duplicateRemova() {

		//利用set给list去重
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
		while (iterator.hasNext()) {

			Object object = iterator.next();
			set.add(object);
		}
		
		List newList = new ArrayList<>();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			newList.add(iterator.next());
		}
		list = newList;
		//去重后
		System.out.println(list);
	}

	/*
	 * 3.有一个存放课程的集合List<String> course = new ArrayList<>()，完成以下功能：
	 * a．向集合中添加三门课程：java、mysql、linux b．使用3种方法遍历集合中的内容并打印
	 */
	@Test
	public void test2() {

		List<String> course = new ArrayList<>();

		System.out.println("向集合中添加三门课程：java、mysql、linux");
		course.add("java");
		course.add("mysql");
		course.add("linux");

		System.out.println("添加完成");
		System.out.println(course);

		//方式一
		System.out.println("第一种遍历方法");
		for (String str : course)
			System.out.println(str);

		//方式二
		System.out.println("第二种遍历方法");
		for (int i = 0; i < course.size(); i++)
			System.out.println(course.get(i));

		//方式三
		System.out.println("第三中遍历方法");
		Iterator<String> iterator = course.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());

	}

}
