package com.hpe.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class ListTest {

	// List是一个接口，其中可以存放的是有序的，可重复的元素，集合中的每个元素都有其对应的索引
	// 常用ArrayList、LinkedList
	// ArrayList是对象引用的一个变长数组
	// LiskedList采用链表的方式存储。插入、删除元素时效率比较高
	// ArrayList 遍历元素和随机访问元素的效率比较高，插入、删除等操作频繁时性能低下
	// LinkedList 插入、删除元素时效率较高，查找效率低
	// 索引取值范围：0-list.size()-1
	
	@Test
	public void test1() {

		List list = new ArrayList<>();

		// 添加元素
		list.add("abc");
		list.add("abc");
		list.add(1);

		System.out.println(list);

		// 插入add(int,Object)
		list.add(1, "bcd");
		System.out.println(list);

		// 删除指定位置的元素，删除索引是1的元素remove(int)
		Object removeRes = list.remove(1);

		System.out.println(removeRes);
		System.out.println(list);

		// 修改
		// 将某索引位置对应的元素改为一个新的元素set(int,Object)abc abc 1
		Object updateRes = list.set(1, "bcd");

		System.out.println(updateRes);
		System.out.println(list);

		// 查询(查询指定位置的元素)get(int)//abc abc 1
		Object object = list.get(0);

		System.out.println(object);

	}

	@Test
	public void test2() {

		List list = new ArrayList<>();

		// 添加元素
		list.add("abc");
		list.add("bcd");
		list.add(1);

		// 遍历
		// 方式一:增强for循环
		for (Object o : list)
			System.out.println(o + "!");

		// 方式二：迭代器
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {

			Object object = iterator.next();
			System.out.println(object + "@");
		}

		// 方式三:
		for (int i = 0; i < list.size(); i++) {

			Object object = list.get(i);
			System.out.println(object + "#");
		}

	}

	@Test
	public void test3() {

		// 泛型:用于指定集合中可以存储的元素类型
		List<Person> list = new ArrayList<>();

		Person p1 = new Person(1, "zhangsan");
		Person p2 = new Person(2, "lisi");
		Person p3 = new Person(3, "wangwu");
		Person p4 = new Person(4, "zhaoliu");

		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);

		showList(list);

		// 删除（从控制台输入一个名字，并删除此人，如果没有打印无此人，如果存在就删除）
		System.out.println("请输入要删除人的姓名：");

		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		//调用findPersonByName
		int index = findPersonByName(list, name);
		
		if(index != -1){
			//
			System.out.println(list.get(index));
			list.remove(index);
			System.out.println("删除成功");
		}
		else{
			//打印无此人
			System.out.println("无此人");
		}

		showList(list);
		
		//修改
		System.out.println("请输入要修改人的姓名：");

		name = sc.nextLine();
		index = findPersonByName(list, name);
		
		if(index!=-1){
			//修改
			System.out.println("请输入新的名字");
			String newName = sc.nextLine();
			
			System.out.println("请输入新的年龄");
			int newAge = sc.nextInt();
			
			//方式一：set(int,Person)

			//list.set(index, new Person(newAge, newName));
			
			//方式二: 获取地址值，修改
			Person person = list.get(index);
			person.setAge(newAge);
			person.setName(newName);
			
			
		}
		else{
			System.out.println("不存在");
		}

		showList(list);
	}

	//根据名字查找此元素的索引
	//参数：名字，list
	//返回：此名字元素的索引
	public int findPersonByName(List<Person> list,String name) {
		
		for (int i = 0; i < list.size(); i++) {

			// 得到当前的Person
			Person person = list.get(i);
			// 得到当前Person的name
			String name1 = person.getName();
			// 得到当前Person的name与输入的name进行比较，如果相同，就删除
			if (name.equals(name1)) {
				//返回索引
				return i;
			}

		}
		
		return -1;
		
	}

	// 遍历List<person>打印元素的name
	public void showList(List<Person> list) {

		// 打印所有元素的名字
		for (int i = 0; i < list.size(); i++) {
			/*
			 * Person p = list.get(i); String name = p.getName();
			 * System.out.println(name);
			 */

			System.out.println(list.get(i).getName() + "!");

		}

	}

}
