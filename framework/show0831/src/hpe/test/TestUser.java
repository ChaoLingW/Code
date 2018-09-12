package hpe.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hpe.bean.User;


public class TestUser {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void test2() {
		// beanfactory 的子接口ApplicationContext
		ApplicationContext atx = new ClassPathXmlApplicationContext("bean.xml");
		// 通过bean工厂获取一个对象
		// 通过Class
		// 配置文件中的id、Name
		//User user = (User) atx.getBean("user");
		//User user1 = (User) atx.getBean("user");
		/**
		 *  现象1：多次获取，获取的同一个对象
		 *  scope 作用域
		 *  单例
		 *  
		 *  现象2：如果多个bean的class一样，通过.getBran(类.class 获取不到)
		 *  三种获取bean的方式，选择时唯一的
		 *  
		 */
		User  user = (User) atx.getBean("user");
		User user1 = (User) atx.getBean("user");
		
		System.out.println(user.hashCode());
		System.out.println(user1.hashCode());
		
	}
}
