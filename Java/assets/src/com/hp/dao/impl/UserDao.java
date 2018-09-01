package com.hp.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.dao.IUserDao;
import com.hp.po.User;
import com.hp.util.DBUtil;

/**
 * @Description:对user表的操作实现IUserDao接口
 * @author chaoling
 * @date 2018年8月1日
 */
public class UserDao implements IUserDao {

	@Override
	public int updateByNameToPassword(User user) {
		// 根据userName设置userPassword
		String sql = "update user set userPassword =? where userName = ?";
		Object[] params = { user.getUserPassword(), user.getUserName() };
		return DBUtil.update(sql, params);
	}

	@Override
	public List<User> seleteAllUser() {
		// 查询所有的记录
		String sql = "select * from user";
		return DBUtil.query(sql, new BeanListHandler<>(User.class), null);
	}

	@Override
	public User seleteUser(User user) {
		// 根据对应的userName查询对应的记录
		String sql = "select * from user where userName = ?";

		return DBUtil.query(sql, new BeanHandler<>(User.class), user.getUserName());
	}

	@Override
	public int addUser(User user) {
		// 插入一条user表记录，不包括userId
		String sql = "insert into user (userName,userPassword,realName,sex,tel,idCard,address)"
				+ " values(?,?,?,?,?,?,?)";
		Object[] params = { user.getUserName(), user.getUserPassword(), user.getRealName(), user.getSex(),
				user.getTel(), user.getIdCard(), user.getAddress() };

		return DBUtil.update(sql, params);
	}

}
