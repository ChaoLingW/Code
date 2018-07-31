package com.hpe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hpe.dao.IUserDao;
import com.hpe.po.User;
import com.hpe.util.JdbcUtil;

/**
 * @Description: 对user表操作的类
 * @author chaoling
 * @date 2018年7月30日下午2:26:21
 */
public class UserDaoImpl implements IUserDao{

	/**
	 * @Description: 添加一条记录
	 * @param user
	 * @return row    
	 * @throws SQLException
	 */
	public int addUser(User user){
		
		String sql = "insert into user(username,password,realname,age) values (?,?,?,?)";
		Connection connection = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			connection = JdbcUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRealName());
			pstmt.setInt(4, user.getAge());
			
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, pstmt, connection);
		}		
		return row;
	}
	
	/**
	 * @Description: 根据姓名删除
	 * @param name
	 * @return row    
	 * @throws SQLException
	 */
	public int deleteUserByName(String name){

		String sql = "delete from user where username = ?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			connection = JdbcUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, pstmt, connection);
		}		
		return row;
	}
	
	/**
	 * @Description: 根据姓名修改
	 * @param user
	 * @return row    
	 * @throws SQLException
	 */
	public int updateByName(User user){
		
		int row = 0;
		String sql = "update user set password = ?, realname = ?,age = ? where username = ?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = JdbcUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getRealName());
			pstmt.setInt(3, user.getAge());
			pstmt.setString(4, user.getUserName());
			
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, pstmt, connection);
		}
		return row;
	}
	
	/**
	 * @Description: 查询所有
	 * @return users
	 * @throws SQLException
	 */
	public List<User> selectAll(){
		
		List<User> users = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sql = "select * from user";
		
		try {
			connection = JdbcUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			
			users = new ArrayList<>();
			
			while(resultSet.next()){
				
				int id = resultSet.getInt(1);
				String userName = resultSet.getString(2);
				String password = resultSet.getString(3);
				String realName = resultSet.getString(4);
				int age = resultSet.getInt(5);
				
				User user = new User(id, userName, password, realName, age);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(resultSet, pstmt, connection);
		}
		return users;
	}

	/**
	 * @Description: 根据姓名查询
	 * @param name
	 * @return user    
	 * @throws SQLException
	 */
	public User selectByName(String name){
		
		User user = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sql = "select * from user where username = ?";
		
		try {
			connection = JdbcUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				
				int id = resultSet.getInt(1);
				String userName = resultSet.getString(2);
				String password = resultSet.getString(3);
				String realName = resultSet.getString(4);
				int age = resultSet.getInt(5);
				
				user = new User(id, userName, password, realName, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(resultSet, pstmt, connection);
		}
		return user;
	}

}
