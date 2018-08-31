package com.hpe.service.impl;

import java.util.List;

import com.hpe.base.BaseDao;
import com.hpe.bean.User;
import com.hpe.dao.IUserDao;
import com.hpe.dao.impl.UserDaoImpl;
import com.hpe.service.IUserService;
import com.hpe.util.Page;

/**
 *  用户管理的业务类，实现IUserService接口
 * @author chaoling
 */
public class UserServiceImpl implements IUserService{

	private IUserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		
		return userDao.getUser(user);
	}

	@Override
	public boolean register(User user) {
		
		boolean res = false;
		try {
			BaseDao.beginTranscation();
			userDao.saveUser(user);
			BaseDao.endTranscation();
			res=true;
		} catch (Exception e) {
			BaseDao.rollback();
		} finally {
			BaseDao.closeConn();
		}
		return res;
	}

	@Override
	public List<User> findAllUser() {
	
		return userDao.findAllUser();
	}

	@Override
	public boolean deleteUser(int id) {
		
		boolean res = false;
		try {
			BaseDao.beginTranscation();
			userDao.deleteUser(id);
			BaseDao.endTranscation();
			res = true;
		} catch (Exception e) {
			BaseDao.rollback();
		} finally {
			BaseDao.closeConn();
		}
		return res;
	}

	@Override
	public boolean updateUser(User user) {
		
		boolean res = false;
		try {
			BaseDao.beginTranscation();
			userDao.updateUser(user);
			BaseDao.endTranscation();
			res = true;
		} catch (Exception e) {
			BaseDao.rollback();
		} finally {
			BaseDao.closeConn();
		}
		return res;
	}

	@Override
	public Page searchUser(Page page,User user) {
		return  userDao.searchUser(page,user);
	}

	@Override
	public User findUserById(int id) {
	
		return userDao.findUserById(id);
	}
	
}
