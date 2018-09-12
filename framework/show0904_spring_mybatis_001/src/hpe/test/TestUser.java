package hpe.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hpe.po.User;
import hpe.service.IUserService;
import hpe.service.UserService;

public class TestUser {

	private static ApplicationContext atx = null;

	// @BeforeAll
	@BeforeClass
	public static void init() throws Exception {
		//
		atx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void test3() {
		List<User> users = new ArrayList<>();

		IUserService userService = (IUserService) atx.getBean("userService");

		for (int i = 0; i < 3; i++) {
			User user = new User();

			user.setUsername("--------" + i);
			user.setPwd("=====" + i);

			users.add(user);
		}

		try {
			userService.addUser(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
