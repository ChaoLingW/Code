package com.hpe.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hpe.bean.User;
import com.hpe.dao.IUserDao;
import com.hpe.service.IUserService;
import com.hpe.util.MybatisDBUtil;
import com.hpe.util.Page;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao; 
	
	@Override
	public User login(User user) {

		// 获取Sql连接
		SqlSession session = MybatisDBUtil.getSession();
		// 动态代理对象
		userDao = session.getMapper(IUserDao.class);
		// 执行
		User res = userDao.login(user);
		// 关闭sql连接
		MybatisDBUtil.closeSession(session);
		return res;
	}

	@Override
	public boolean saveUser(User user) {

		boolean flag = false;

		// 获取Sql连接
		SqlSession session = MybatisDBUtil.getSession();
		// 动态代理对象
		IUserDao mapper = session.getMapper(IUserDao.class);
		// 执行
		try {
			flag = mapper.saveUser(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return flag;
	}
	
	@Override
	public Page searchUser(Page page) {

		// 获取Sql连接
		SqlSession session = MybatisDBUtil.getSession();
		// 动态代理对象
		userDao = session.getMapper(IUserDao.class);
		// 处理数据
		// 每页显示的记录条数
		int pageNumber = page.getPageNumber();
		// 第几页
		if (page.getCurPage() < 1) {
			page.setCurPage(1);
		}
		int curPage = page.getCurPage();
		// 每页开始的位置
		int limitStart = (curPage-1)*pageNumber;
		// 设置到 curPage中 
		page.setRows(limitStart);
		// 执行
		List<User> users = userDao.searchUser(page);
		
		// 处理页数问题
		// 总记录数
		int rows = userDao.selectCount(page.getUser());
		int totalPages = 0;	// 页数
		if(rows % pageNumber ==0){
			totalPages = rows / pageNumber;
		}else{
			totalPages = rows / pageNumber + 1;
		}
		// 封装page
		page.setRows(rows);
		page.setData(users);
		page.setTotalPage(totalPages); 
		
		// 关闭sql连接
		MybatisDBUtil.closeSession(session);
		return page;
	}

	@Override
	public User findUserById(int id) {

		// 获取Sql连接
		SqlSession session = MybatisDBUtil.getSession();
		// 动态代理对象
		userDao = session.getMapper(IUserDao.class);
		// 执行
		User user = userDao.findUserById(id);
		// 关闭sql连接
		MybatisDBUtil.closeSession(session);
		return user;
	}

	@Override
	public boolean updateUserById(User user) {

		boolean flag = false;
		// 获取Sql连接
		SqlSession session = MybatisDBUtil.getSession();
		// 动态代理对象
		userDao = session.getMapper(IUserDao.class);
		// 执行
		try {
			flag = userDao.updateUserById(user);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭sql连接
			MybatisDBUtil.closeSession(session);
		}
		return flag;
	}

	@Override
	public boolean deleteUserById(int id) {
		
		boolean flag = false;
		// 获取Sql连接
		SqlSession session = MybatisDBUtil.getSession();
		// 动态代理对象
		userDao = session.getMapper(IUserDao.class);
		// 执行
		try {
			flag = userDao.deleteUserById(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sql连接
			MybatisDBUtil.closeSession(session);
		}
		return flag;
	}
	
}
