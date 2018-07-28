package com.hpe.java1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MapTest {

	// map接口，map中存放的都是键值对 key-value（根据键去找值）
	// 主要实现类：HashMap
	// key不允许重复，value可以重复
	// key和value都必须是引用数据类型
	// 建议使用String作为键//因为重写了equals和hashCode
	@Test
	public void test1() {

		Map map = new HashMap<>();

		// 添加put(Object,Object)
		map.put("aaa", "AAA");
		map.put("bbb", "BBB");
		map.put("ccc", "CCC");
		map.put("aaa", "DDD");
		map.put("ddd", "DDD");

		Person p1 = new Person();
		Person p2 = new Person();

		map.put(p1, "SSS");
		map.put(p2, "XXX");

		System.out.println(map);

		// 删除 (根据键来删除键值对) remove(Object key),返回值是要删除的键所对应的值（键存在），返回值为null(键不存在）
		Object removeRes = map.remove("aaa");

		System.out.println(removeRes);
		System.out.println(map);

		// 查找Object get(Object key)，根据指定的来查找这个键所对应的值
		// 存在返回值，不存在返回null
		Object object = map.get("bbb");
		System.out.println(object);

		// 判断map集合中是否存在此键，boolean containsKey(Object key)
		System.out.println(map.containsKey("bbb"));

		// 判断map集合中是否存在此值，boolean containsValue(Object value)
		System.out.println(map.containsValue("BBB"));

		// int size() map中元素(键值对)的个数
		System.out.println(map.size());

		// boolean isEmpty() map是否为空
		System.out.println(map.isEmpty());

	}

	@Test
	public void test2() {

		Map map = new HashMap<>();

		map.put("aaa", "AAA");
		map.put("bbb", "BBB");
		map.put("ccc", "CCC");
		map.put("ddd", "DDD");

		// 遍历问题
		// 遍历所有的键
		// 使用keySet(),得到所有键构成的集合
		Set keySet = map.keySet();

		// 方式一
		for (Object object : keySet)
			System.out.println(object);

		// 方式二
		Iterator iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Object next = iterator.next();
			System.out.println(next);
		}

	}

	@Test
	public void test3() {

		Map map = new HashMap<>();

		map.put("aaa", "AAA");
		map.put("bbb", "BBB");
		map.put("ccc", "CCC");
		map.put("ddd", "DDD");
		
		//遍历所有的值
		//values().可以得到所有值构成的一个Collection集合
		Collection values = map.values();
		
		//方式一
		for(Object object : values)
			System.out.println(object);
		
		//方式二
		Iterator iterator = values.iterator();
		
		while(iterator.hasNext()){
			
			System.out.println(iterator.next());
		}

		//方式三
		Set keySet = map.keySet();
		iterator = keySet.iterator();
		
		while (iterator.hasNext()) {
			Object next = iterator.next();
			Object object = map.get(next);
			System.out.println(object + "!!");
		}
	
	}

	// Map表示对象
	// Map表示对象集合

}
