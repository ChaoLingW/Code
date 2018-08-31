package com.hpe.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hpe.dao.IUserDao;
import com.hpe.dao.impl.UserDaoImpl;
import com.hpe.po.User;
import com.hpe.service.IUserService;

/**
 * @Description:user业务类，实现IuserService接口
 * @author chaoling
 * @date 2018年8月3日
 */
public class UserServiceImpl implements IUserService {

	private IUserDao userDao = new UserDaoImpl();

	@Override
	public List<User> selectAllUser() {

		try {
			return userDao.selectAllUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int regist(User user) {

		try {
			// 1.调用UserDao中的selectUserByName,查看此名称的用户是否存在，存在直接返回-1
			User res = userDao.selectUserByUserName(user.getUserName());
			if (res != null)
				return -1;
			// 2.不存在才调用UserDao的addUser方法
			return (int) userDao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User login(User user) {

		try {
			return userDao.selectUserByUserName(user.getUserName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean changPwd(User user) {

		// 调用UserDao中的updateUserById
		try {
			return userDao.updateUserByUserId(user) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
