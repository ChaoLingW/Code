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
		User user = (User) atx.getBean("user");
		// 1. set 方法设置值 
		user.output();
		
	}
}