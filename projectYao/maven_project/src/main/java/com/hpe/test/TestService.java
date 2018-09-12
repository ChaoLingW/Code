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
 * Userservice��Ĳ�����
 * 
 * @author chaoling
 * @data 2018��9��10��
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
		// ����һ��
		System.out.println(dbUser.getUserName());
		// assertEquals(dbUser.getUserName(), "11");

	}

	@Test
	public void testSelectUserList() {

		User user = new User();
		user.setUserName("11");
		user.setSex("Ů");

		List<User> list = userServiceImpl.selectUserList(user);
		System.out.println(list.size());

	}

	@Test
	public void testSelectUserCount() {

		User user = new User();
		user.setUserName("11");
		user.setSex("Ů");

		Integer i = userServiceImpl.selectUserCount(user);
		System.out.println(i);
	}

	@Test
	public void testAddUser() {

		User user = new User();
		user.setUserName("11");
		user.setSex("Ů");
		user.setAddress("������ѧԺ");
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
		user.setUserName("����");
		user.setId(14);
		user.setBirthday(new Date());
		user.setAddress("11");
		user.setSex("Ů");

		int i = userServiceImpl.updateUser(user);
		System.out.println(i);

	}
	
	/**
	 * ���Է�ҳ����
	 */
	@Test
	public void testSelectPage() {
		userServiceImpl.selectPage();
	}
	
	@Test
	public void testSeachUserList() {
		
		User user = new User();
		user.setAddress("1");
		user.setSex("��");
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
		int pageNum = page.getPageNum();	// ��ǰҳ
		int Pages = page.getPages();	// ҳ��
		page.getPrePage();	// ��һҳ
		page.getTotal();	// �ܼ�¼��
		
		System.out.println(page.getList().size());
		
	}
	
}
