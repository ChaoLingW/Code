package com.hpe.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hpe.dao.impl.UserDaoImpl;
import com.hpe.po.User;
import com.hpe.service.gene.IAdd;
import com.hpe.service.gene.ISelect;
import com.hpe.service.gene.ISelectOne;
import com.hpe.service.gene.IUpdate;

/**
 * @Description:user业务的实现类。实现IAdd、ISelect、ISelectOne、IUpdate接口
 * @author chaoling
 * @date 2018年8月3日
 */
public class UserServiceImpl implements IAdd<User>, ISelect<List<User>>, ISelectOne<User>, IUpdate<User> {

	private UserDaoImpl userDao = new UserDaoImpl();

	/**
	 * 添加用户
	 * -1 该用户名已存在 0 注册失败 1 注册成功
	 */
	@Override
	public int add(User user) {

		try {
			// 1.调用UserDao中的selectUserByName,查看此名称的用户是否存在，存在直接返回-1
			User res = userDao.selectUserByUserName(user.getUserName());
			if (res != null)
				return -1;
			// 2.不存在才调用UserDao的addUser方法
			return userDao.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 查看所有的用户
	 * null user表中不存在用户
	 */
	@Override
	public List<User> selectAll() {

		try {
			return userDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 修改密码
	 * 0 修改失败 1 修改成功
	 */
	@Override
	public int update(User t) {
		try {
			return userDao.update(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 登录
	 * null 登录失败
	 */
	@Override
	public User login(User t) {
		try {
			return userDao.selectOne(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
