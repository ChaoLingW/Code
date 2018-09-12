package com.hpe.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.hpe.po.User;
import com.hpe.service.IUserService;

/**
 * Userservice类的测试类
 * 
 * @author chaoling
 * @data 2018年9月10日
 * @version v1.0
 */
public class TestService {

	IUserService userServiceImpl = null;

	@Before
	public void before() {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userServiceImpl = ac.getBean(IUserService.class);

	}

	@Test
	public void testSelectUser() {

		User user = new User();
		user.setId(5);
		User dbUser = userServiceImpl.selectUser(user);
		// 断言一下
		System.out.println(dbUser.getUserName());
		// assertEquals(dbUser.getUserName(), "11");

	}

	@Test
	public void testSelectUserList() {

		User user = new User();
		user.setUserName("11");
		user.setSex("女");

		List<User> list = userServiceImpl.selectUserList(user);
		System.out.println(list.size());

	}

	@Test
	public void testSelectUserCount() {

		User user = new User();
		user.setUserName("11");
		user.setSex("女");

		Integer i = userServiceImpl.selectUserCount(user);
		System.out.println(i);
	}

	@Test
	public void testAddUser() {

		User user = new User();
		user.setUserName("11");
		user.setSex("女");
		user.setAddress("济宁大学院");
		user.setBirthday(new Date());

		Integer i = userServiceImpl.addUser(user);
		System.out.println(i);
	}

	@Test
	public void testDelUser() {

		int i = userServiceImpl.delUser(16);
		System.out.println(i);

	}

	@Test
	public void testDelUserByUser() {

		User user = new User();
		user.setUserName("dd");
		user.setId(15);

		int i = userServiceImpl.delUser(user);
		System.out.println(i);

	}
	
	@Test
	public void testUpdateUser() {

		User user = new User();
		user.setUserName("张三");
		user.setId(14);
		user.setBirthday(new Date());
		user.setAddress("11");
		user.setSex("女");

		int i = userServiceImpl.updateUser(user);
		System.out.println(i);

	}
	
	/**
	 * 测试分页方法
	 */
	@Test
	public void testSelectPage() {
		userServiceImpl.selectPage();
	}
	
	@Test
	public void testSeachUserList() {
		
		User user = new User();
		user.setAddress("1");
		user.setSex("男");
		user.setUserName("1");
		
		List<User> list = userServiceImpl.seachUserList(user);
		
		if(list != null) {
			for(User i : list) {
				System.out.println(i.getAddress());
			}
		}
	}
	
	@Test
	public void testPage() {
		
		User user = new User();
		user.setAddress("1");
		user.setUserName("1");
		user.setSex(null);
		
		PageInfo<User> page = userServiceImpl.selectPage(user, 2);
		System.out.println(page);
		int pageNum = page.getPageNum();	// 当前页
		int Pages = page.getPages();	// 页数
		page.getPrePage();	// 上一页
		page.getTotal();	// 总记录数
		
		System.out.println(page.getList().size());
		
	}
	
}
