package com.hpe.java;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {

	@Test
	public void test1() {

		// 如何创建Person类的对象，并调用其中的对象

		Person p = new Person();
		p.setAge(10);
		p.setName("张三");

		System.out.println(p);

		p.eat();
		p.sayHi("李四");
		;
	}

	@Test
	public void test2() throws Exception {

		Class c1 = Person.class;

		// 完成实例化，创建Person对象
		Person p = (Person) c1.newInstance();
		p.setAge(10);
		p.setName("lisi");

		System.out.println(p);

		p.eat();
	}

	@Test
	public void test3() throws Exception {

		// 获取Class的三种方式
		// 1.使用类名.class
		Class c1 = Person.class;

		// 2.使用Class.forName(全类名)
		Class c2 = Class.forName("com.hpe.java.Person");

		// 3.对象名.getClass()的方式
		Person p = new Person();

		Class c3 = p.getClass();

		System.out.println(c1 == c2);
		System.out.println(c1 == c3);

	}

	@Test
	public void test4() throws Exception {

		// 使用构造器创建实例
		// 1.无参构造器创建实例
		Class c1 = Person.class;

		// 调用newInstace()创建实例-->无参构造器

		Person p = (Person) c1.newInstance();
		System.out.println(p);
		p.eat();

		// 2.有参构造器创建实例
		//得到有参构造器 
		Constructor cons = c1.getConstructor(int.class,String.class);
		Person p1 = (Person)cons.newInstance(1,"wangwu");
		
		System.out.println(p1);
		
	}
	
	@Test
	public void test5() throws Exception{
		
		//设置属性值-->具体的对象
		
		//1.得到Class
		Class c1 = Person.class;
		
		//2.得到属性
		Field fieldAge = c1.getField("age");
		
		System.out.println(fieldAge.getName());
		
		//3.设置属性值-->给哪个对象的age属性设置值
		Person p = (Person) c1.newInstance();
		fieldAge.set(p, 1);//属性.set(对象，值)  p.age = 1
		
		System.out.println(p);
		//对于非publicde 的属性，调用getDeclaredField来得到属性
		Field fieldName = c1.getDeclaredField("name");
		//如果要设置私有属性，调用setAccessible
		fieldName.setAccessible(true);
		fieldName.set(p, "zhaoliu");//p.name = "zhaoliu"
		System.out.println(p);
		
		//得到属性值
		int age = (int) fieldAge.get(p);//参数:对象 p.age
		
		Field[] fields = c1.getDeclaredFields();
		
		for(Field field : fields)
			System.out.println(field);

	}
	
	
	@Test
	public void test7() throws Exception{
		
		//如何通过反射机制获取方法，并调用方法
		//1.得到Class
		
		Class c = Person.class;
		
		//2.得到方法
		//参数：方法名
		Method eatMethod = c.getMethod("eat");
		
		//3.调用方法-->对象调用方法
		Person p = (Person) c.newInstance();
		eatMethod.invoke(p);//对象调用方法传递参数
		
		
		
	}
}
