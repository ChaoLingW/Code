package com.hp.service.impl;

import java.util.List;

import com.hp.dao.IUserDao;
import com.hp.dao.impl.UserDao;
import com.hp.po.User;
import com.hp.service.IUserService;

/**
 * @Description:user业务的操作类，实现IuserService接口
 * @author chaoling
 * @date 2018年8月1日
 */
public class UserService implements IUserService {

	// 将需要的dao层对象私有化为属性
	private IUserDao userDao = new UserDao();

	@Override
	public int loginUser(User user) {
		// 查询该用户是否存在
		User res = userDao.seleteUser(user);
		// 不存在
		if (res == null)
			return -1;
		// 判断密码是否相同，相同返回对应的userId,不同返回0
		if (res.getUserPassword().equals(user.getUserPassword()))
			return res.getUserId();
		return 0;
	}

	@Override
	public int registerUser(User user) {
		// 判断用户名是否存在
		User res = userDao.seleteUser(user);
		// 用户名已存在，不可注册，返回-1
		if (res != null)
			return -1;
		// 执行更新并判断
		if (userDao.addUser(user) > 0)
			// 更新成功
			return 1;
		// 更新失败
		return 0;
	}

	@Override
	public List<User> selectAllUser() {
		// 查询所有的用户
		List<User> res = userDao.seleteAllUser();
		if (res != null && res.size() != 0)
			return res;
		return null;
	}

	@Override
	public boolean updataUserPassword(User user) {
		// 执行更新并接收返回值
		int res = userDao.updateByNameToPassword(user);
		if (res > 0)
			// 更新成功
			return true;
		// 更新失败
		return false;
	}

}
