package com.hpe.service.impl;

import java.util.List;

import com.hpe.base.BaseDao;
import com.hpe.bean.User;
import com.hpe.dao.IUserDao;
import com.hpe.dao.impl.UserDaoImpl;
import com.hpe.service.IUserService;
import com.hpe.util.Page;

public class UserServiceImpl implements IUserService{

	//注入
	private IUserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		
		//调用UserDao中getUser的的方法
		return userDao.getUser(user);
	}

	@Override
	public boolean saveUser(User user) {
		boolean res = false;
		try {
			BaseDao.beginTranscation();
			userDao.saveUser(user);
			BaseDao.endTranscation();
			res=true;
		} catch (Exception e) {
			e.printStackTrace();
			BaseDao.rollback();
		}
		finally
		{
			BaseDao.closeConn();
		}
		return res;
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public Page searchUser(Page page,User user) {
		return userDao.searchUser(page,user);
	}

	@Override
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

	@Override
	public boolean updateUserById(User user) {
		boolean res = false;
		try {
			BaseDao.beginTranscation();
			userDao.updateUserById(user);
			BaseDao.endTranscation();
			res=true;
		} catch (Exception e) {
			e.printStackTrace();
			BaseDao.rollback();
		}
		finally
		{
			BaseDao.closeConn();
		}
		return res;
	}

}
