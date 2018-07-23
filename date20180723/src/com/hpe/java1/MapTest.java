package com.hpe.java1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class MapTest {

	// map接口，map中存放的都是键值对 key-value（根据键去找值）
	// 主要实现类：HashMap
	// key不允许重复，value可以重复
	// key和value都必须是引用数据类型
	// 建议使用String作为键//因为重写了equals和hashCode

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

		// 遍历所有的值
		// values().可以得到所有值构成的一个Collection集合
		Collection values = map.values();

		// 方式一
		for (Object object : values)
			System.out.println(object);

		// 方式二
		Iterator iterator = values.iterator();

		while (iterator.hasNext()) {

			System.out.println(iterator.next());
		}

		// 方式三 遍历所有的值-->遍历所有的键（根据键去找值）

		// 1.得到所有键构成的集合
		Set keySet = map.keySet();

		for (Object object : keySet) {

			// 根据键找值
			Object object2 = map.get(object);
			System.out.println(object2 + "%");

		}

		iterator = keySet.iterator();

		while (iterator.hasNext()) {
			Object next = iterator.next();
			Object object = map.get(next);
			System.out.println(object + "!!");
		}

	}

	// key-->value
	@Test
	public void test4() {

		Map map = new HashMap<>();

		map.put("aaa", "AAA");
		map.put("bbb", "BBB");
		map.put("ccc", "CCC");
		map.put("ddd", "DDD");

		Set keySet = map.keySet();

		for (Object key : keySet) {

			// 根据键找值
			Object value = map.get(key);
			System.out.println(key + "-->" + value);

		}

		Iterator iterator = keySet.iterator();

		while (iterator.hasNext()) {
			Object key = iterator.next();
			Object value = map.get(key);
			System.out.println(key + "-->" + value + "=");
		}

		// entrySet Set
		Set entrySet = map.entrySet();// Entry集合

		for (Object obj : entrySet) {
			Map.Entry entry = (Entry) obj;
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + "-->" + value);
		}

	}

	// Map表示对象
	// Map表示对象集合
	@Test
	public void test5() {

		Person p = new Person(11, "zhangsan");

		// Map表示对象（age 11, name zhangsan)
		Map map = new HashMap<>();

		map.put("age", 11);
		map.put("name", "zhangsan");

	}

	@Test
	public void test6() {

		Person p1 = new Person(11, "zhangsan");
		Person p2 = new Person(12, "lisi");
		Person p3 = new Person(13, "wangwu");

		List list = new ArrayList<>();

		list.add(p1);
		list.add(p2);
		list.add(p3);

		// Map表示对象（age 11, name zhangsan)
		Map map1 = new HashMap<>();

		map1.put("age", 11);
		map1.put("name", "zhangsan");
		Map map2 = new HashMap<>();

		map2.put("age", 12);
		map2.put("name", "lisi");
		Map map3 = new HashMap<>();

		map3.put("age", 13);
		map3.put("name", "wangwu");
		
		List<Map> list1 = new ArrayList<>();
		list1.add(map1);
		list1.add(map2);
		list1.add(map3);

	}

}
