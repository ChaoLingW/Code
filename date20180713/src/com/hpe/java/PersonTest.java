package com.hpe.java;

import org.junit.Test;

/**
 * 
 * @author chaoling
 * @date 2018年7月13日上午8:56:21
 * @Description
 */
public class PersonTest {

	//构造函数/构造器/构造函数（Constructor）
	
	//构造器作用-->用于对象并进行初始化
	
	//构造器特点
	//1.名称与类名一致
	//2.无返回值，无返回值类型（包括void)
	
	//注意：
	//如果类中，没有写构造函数，那么系统会提供一个默认的无参构造函数
	//一旦在类中，自定义了构造函数，那么系统就不会提供的默认无参构造函数了，此时需要无参构造函数时，需要显示定义
	
	
	
	@Test
	public void test(){
		
		//创建Person类的一个对象
		Person person = new Person();//new + 构造器来创建对象
		
		//打印person的age属性
		System.out.println(person.getAge());//1
		
		//创建Person对象，并完成属性的赋值
		Person p1 = new Person();//设置age 10,name zhangsan,sex 男
		p1.setAge(10);
		p1.setName("张三");
		p1.setSex("男");
		
		//希望在创建对象的同时（调用构造器），就对属性设置属性值
		Person p2 = new Person(11,"lis","女");
		System.out.println(p2);
		
		//this说明
		Person p3 = new Person();
		p3.setAge(10);
	}
	
	
	
}
