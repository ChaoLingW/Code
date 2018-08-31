package com.hpe.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hpe.DBUtils.MybatisDBUtil;
import com.hpe.dao.IUserDao;
import com.hpe.po.User;

public class UserServiceImpl implements IUserService {

	private static IUserDao userDao;

	@Override
	public User userLogin(String name, String pwd) {
		// 封装对象
		User paraUser = new User();
		paraUser.setPassword(pwd);
		paraUser.setUsername(name);
		// 获取sql连接
		SqlSession session = MybatisDBUtil.getSession();
		userDao = session.getMapper(IUserDao.class); // 动态代理对象
		// 调用selectUserByNameAndPwd方法接收返回值
		User user = userDao.selectUserByNameAndPwd(paraUser);
		// 关闭连接
		MybatisDBUtil.closeSession(session);
		
		return user;
	}

	@Override
	public List<User> select(User user) {
		// 获取sql连接
		SqlSession session = MybatisDBUtil.getSession();
		userDao = session.getMapper(IUserDao.class); // 动态代理对象
		// 调用select方法接收返回值
		List<User> users = userDao.select(user);
		// 关闭连接
		MybatisDBUtil.closeSession(session);
		
		return users;
	}

	@Override
	public int updateById(User user) {
		SqlSession session = MybatisDBUtil.getSession();
		userDao = session.getMapper(IUserDao.class); // 动态代理对象
		// 调用selectUserByNameAndPwd方法接收返回值
		int row = userDao.updateById(user);
		session.commit();
		// 关闭连接
		MybatisDBUtil.closeSession(session);
		
		return row;
	}

	@Override
	public int deleteById(List<Integer> id) {
		
		SqlSession session = MybatisDBUtil.getSession();
		userDao = session.getMapper(IUserDao.class); // 动态代理对象
		// 调用selectUserByNameAndPwd方法接收返回值
		int row = userDao.deleteById(id);
		session.commit();
		// 关闭连接
		MybatisDBUtil.closeSession(session);
		
		return row;
	}

}
