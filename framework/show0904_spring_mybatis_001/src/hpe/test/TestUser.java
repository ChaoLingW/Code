package hpe.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hpe.dao.UserDao;
import hpe.po.User;

public class TestUser {

	
	@Test
	public void testQueryAll () throws Exception {
		
		ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = atx.getBean(UserDao.class);
		List<User> list = userDao.queryAll();
		if(list != null && list.size() > 0) {
			for(User user : list) {
				System.err.println(user);
			}
		}
	
	}
	
	@Test
	public void testAddUser () {
//		UserDao obj = new UserOptionImpl_mybatis();
//		
//		try {
//			User u = new User();
//			
//			u.setAddress("0829-addr1");
//			u.setBirthday("1111-11-11");
//			u.setPwd("123");
//			u.setSex("男");
//			u.setUsername("0829-name1");
//			
//			
//			int ire = obj.addUser(u);
//			
//			System.out.println("rows:" + ire);
//			System.out.println(u.getId());
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
