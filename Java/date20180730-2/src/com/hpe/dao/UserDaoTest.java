package com.hpe.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.hpe.po.User;

public class UserDaoTest {

	UserDao userDao = new UserDao();
	@Test
	public void testAddUser() {
		User user = new User(0, "123", "123", "123", 12);
		int addUser = userDao.addUser(user);
		System.out.println(addUser);
	}

	@Test
	public void testDeleteUserByName() {
		int deleteUserByName = userDao.deleteUserByName("1");
		System.out.println(deleteUserByName);
	}

	@Test
	public void testUpdateByname() {
		User user = new User(0, "123", "100", "100", 18);
		int i = userDao.updateByname(user);
		System.out.println(i);
	}

	@Test
	public void testSelectAll() {
		List<User> users = userDao.selectAll();
		for(User user : users)
			System.out.println(user);
	}

	@Test
	public void testSelectByName() {
		User user = userDao.selectByName("123");
		System.out.println(user);
	}

}
