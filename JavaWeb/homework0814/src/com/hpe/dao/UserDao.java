package com.hpe.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hpe.po.User;
import com.hpe.util.DBUtil;

/**
 * TODO:对user表的操作类
 * @author chaoling
 *
 */
public class UserDao {
	
	private ResultSetHandler<User> rsh = new BeanHandler<>(User.class);
	
	/**
	 * 对user表执行查询操作
	 * @param user 待查询的信息
	 * @return 查到的信息
	 * @throws SQLException
	 */
	public User login(User user) throws SQLException{
		
		String sql = "select * from user where userName = ? and password = ?";
		Object[] params ={user.getUserName(),user.getPassword()};
		
		return DBUtil.query(sql, rsh, params);
		
	}
	
	/**
	 * 根据用户名进行查询
	 * @param userName
	 * @return 查到的信息 为null表示不存在
	 * @throws SQLException
	 */
	public User selectByUserName(String userName) throws SQLException{
		
		String sql = "select * from user where userName = ?";
		
		return DBUtil.query(sql, rsh, userName);
	}
	
	/**
	 * user表执行插入操作
	 * @param user
	 * @return 受影响的行数
	 * @throws SQLException 
	 */
	public int registe(User user) throws SQLException{
		
		String sql = "insert into user(userName,password,sex,hobbys) values(?,?,?,?)";
		Object[] params = {user.getUserName(),user.getPassword(),user.getSex(),user.getHobbys()};
		
		return DBUtil.update(sql, params);
		
	}

}
