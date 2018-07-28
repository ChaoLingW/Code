package com.hpe.java1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MapTest {

	// Map接口，map存放的都是键值对 key-value（根据键去找值）
	// key不允许重复，value可以重复
	// key和value都必须是引用类型的数据

	// 主要实现类：HashMap
	// 建议使用String作为键

	@Test
	public void test1() {
		Map map = new HashMap<>();

		// 添加put(Object,Object)

		map.put("aaa", "AAA");

		map.put("bbb", "BBB");

		map.put("ccc", "CCC");

		map.put("aaa", "DDD");

		map.put("ddd", "DDD");

		
		 Person p1 = new Person(); Person p2 = new Person();
		  
		 map.put(p2, "XXX"); map.put(p1, "SSS");
		 

		System.out.println(map);
		System.out.println();

		// 删除（根据键来删除键值对）remove(Object key),返回值是要删除的键所对应的值

		Object removeRes = map.remove("aaa");

		System.out.println(removeRes);

		System.out.println(map);

		// 查找Object get(Object key)，根据指定的来查找这个键所对应的值

		Object object = map.get("bbb");

		System.out.println(object);

		// 判断map集合中是否存在此键，boolean containsKey(Object key)
		System.out.println(map.containsKey("bbb"));

		// 判断map集合中是否存在此值boolean containsValue(Object value)
		System.out.println(map.containsValue("BBB"));

		// map中元素（键值对）的个数int size()
		System.out.println(map.size());// 3

		// boolean isEmpty()
		System.out.println(map.isEmpty());// false

	}

	@Test
	public void test2() {
		
		Map map = new HashMap<>();

		// 添加put(Object,Object)

		map.put("aaa", "AAA");

		map.put("bbb", "BBB");

		map.put("ccc", "CCC");

		map.put("ddd", "DDD");
		
		//遍历所有的键
		//使用keySet(),得到所有键构成的集合
		
		Set keySet = map.keySet();
		
		//一
		for(Object obj:keySet)
		{
			System.out.println(obj+"!");
		}
		
		//二
		Iterator iterator = keySet.iterator();
		
		while(iterator.hasNext())
		{
			Object obj = iterator.next();
			System.out.println(obj+"@");
		}

	}
	
	@Test
	public void test3()
	{
		
		Map map = new HashMap<>();

		// 添加put(Object,Object)

		map.put("aaa", "AAA");

		map.put("bbb", "BBB");

		map.put("ccc", "CCC");

		map.put("ddd", "DDD");
		
		//遍历所有的值
		//values(),可以得到所有值构成的一个Collection集合
		
		Collection values = map.values();
		
		//方式一
		
		for(Object obj:values)
		{
			System.out.println(obj+"#");
		}
		
		//方式二
		
		Iterator iterator = values.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next()+"$");
		}
		
		//方式三
		
		
		
	}
	
	
	@Test
	public void test(){
		
		
		List list = new ArrayList<>();
		list.add("abc");
		list.add("bsd");
		list.add("abc");
		list.add("a123");
		
		Set set = new HashSet<>();
		
		for(Object object : list){
			set.add(object);
		}
		
		System.out.println(list);
		System.out.println(set);
		
	}

	
	//Map表示对象
	//Map表示对象集合
}
