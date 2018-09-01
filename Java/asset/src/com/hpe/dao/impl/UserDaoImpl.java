package com.hpe.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hpe.dao.IUserDao;
import com.hpe.po.User;
import com.hpe.util.DBUtil;

/**
 * @Description:实现IuserDao接口，对user表的实际操作类
 * @author chaoling
 * @date 2018年8月4日
 */
public class UserDaoImpl implements IUserDao {

	private BeanHandler<User> bh = new BeanHandler<>(User.class);
	private BeanListHandler<User> blh = new BeanListHandler<>(User.class);
	
	@Override
	public List<User> selectAllUser() throws SQLException {

		String sql = "select * from user";
		return DBUtil.query(sql, blh, null);
	}

	@Override
	public int addUser(User user) throws SQLException {

		String sql = "insert into user (userName,userPassword,realName,sex,tel,idCard,address)"
				+ " values(?,?,?,?,?,?,?)";
		Object[] params = { user.getUserName(), user.getUserPassword(), user.getRealName(), user.getSex(),
				user.getTel(), user.getIdCard(), user.getAddress() };

		return (int)DBUtil.insert(sql, new ScalarHandler<>(), params);
	}

	@Override
	public User selectUserByUserName(String name) throws SQLException {
		
		String sql = "select * from user where userName = ?";
		return DBUtil.query(sql, bh, name);
	}

	@Override
	public int updateUserByUserId(User user) throws SQLException {
		
		String sql = "update user set userPassword = ? where userId = ?";
		Object[] params = {user.getUserPassword(),user.getUserId()};
		
		return DBUtil.update(sql, params);
	}

}
