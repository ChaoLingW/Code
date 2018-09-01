package com.hpe.java2;

import org.junit.Test;

public class PolyTest {

	@Test
	public void test() {

		// 创建Person/Man/Women类的对象并调用eat方法

		Person p1 = new Person();
		p1.eat();
		Man m1 = new Man();
		m1.eat();
		Women w1 = new Women();
		w1.eat();
	}

	@Test
	public void test1() {

		Person p1 = new Man();// 父类的引用指向子类的实例(多态的写法),调用重写的方法时，调用的是子类重写后的方法
		p1.eat();

		Person p2 = new Women();
		p2.eat();
	}

	@Test
	public void test3() {

		Man man = new Man();
		callEat(man);
		Women women = new Women();
		callEat(women);
		callEat(new Kid());
	}

	// 定义方法
	// 参数：Man
	// 功能：调用Many的eat方法
	public void callEat(Person person) {

		person.eat();
	}

	@Test
	public void test4() {

		// 多态
		// 父类的引用指向子类的实例
		// 编译的时候看左边，运行的时候看右边
		Person p1 = new Man();// 向上转型
		int a = 1;
		long l = a;// 向上转型，自动完成
		// p1.drink();

		// 向上转型（父类的引用指向子类的实例）/向下转型（父类的引用赋值给子类的引用，必须强制类型转化）

		long b = 1;
		int c = (int) b;// 强制类型转换

		Person p2 = new Man();// 向上转型

		Man m1 = (Man) p2;
		m1.drink();

		/*
		 * //问题 Person p3 = new Person(); Man m2 = (Man)p3;
		 * 
		 * Person p4 = new Women(); Man m3 = (Man)p4;
		 */
		// instanceOf--> a instanceOf A,判断a是否是A的实例，如果是true，否则false
		// 做强制类型转化之前，可以a instanceOf A，判断是否是这个类的实例，如果是才做强转，避免类型转换异常
		// ClassCastException//类型转换异常

		Person p5 = new Man();
		if (p5 instanceof Man) {
			Man m4 = (Man) p5;
			m4.drink();
		}

		Person p6 = new Person();
		if (p6 instanceof Man) {
			Man m5 = (Man) p6;
		}
		else{
			System.out.println("类型不一致无法进行转换");
		}
		
		//类A a是A的实例， A继承B，B继承C
		//a instanceOf A  true
		//a instanceOf B  true
		//a instanceOf C  true
		
		System.out.println(p6 instanceof Object);
	}
}
