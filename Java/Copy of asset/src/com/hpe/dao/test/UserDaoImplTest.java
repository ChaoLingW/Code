package com.hpe.dao.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.hpe.dao.impl.UserDaoImpl;
import com.hpe.po.User;
import com.hpe.util.DBUtil;

/**
 * @Description:UserDaoImpl类的测试类
 * @author chaoling
 * @date 2018年8月5日
 */
public class UserDaoImplTest {

	private User user = null;
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	/**
	 * @Description: 测试SelectOne方法
	 */
	@Test
	public void testSelectOne(){
		
		user = new User(0,"zhangsan","13",null,null,null,null,null);
		try {
			System.out.println(userDaoImpl.selectOne(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 测试add方法
	 */
	@Test
	public void testAdd(){
		
		user = new User(0,"1","1","1","1","1","1","1");
		try {
			System.out.println(userDaoImpl.add(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 测试update方法
	 */
	@Test
	public void testUpdate(){
		
		user = new User(0,null,"123",null,null,null,null,null);
		try {
			System.out.println(userDaoImpl.update(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试selectAll方法
	 */
	@Test
	public void testSelectAll(){
		
		try {
			List<User> selectAll = userDaoImpl.selectAll();
			if(selectAll!= null)
				for(User u :  selectAll)
					System.out.println(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
