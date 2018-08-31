package com.hpe.dao;

import java.sql.SQLException;
import java.util.List;

import com.hpe.po.User;

/**
 * @Description:操作user表的接口
 * @author chaoling
 * @date 2018年8月4日
 */
public interface IUserDao {
	
	/**
	 * @Description: 查询所有的用户
	 * @return 所有的记录 为null表示记录不存在
	 * @throws SQLException 
	 */
	List<User> selectAllUser() throws SQLException;
	
	/**
	 * @Description: 注册功能/添加用户
	 * @param user 待添加的用户的信息
	 * @return 新增用户的主键 
	 * @throws SQLException 
	 */
	int addUser(User user) throws SQLException;
	
	/**
	 * @Description: 根据用户名查询用户
	 * @param name
	 * @return 对应的用户信息 
	 * @throws SQLException 
	 */
	User selectUserByUserName(String name) throws SQLException;
	
	/**
	 * @Description: 根据userId修改用户密码
	 * @return 受影响的行数
	 * @throws SQLException 
	 */
	int updateUserByUserId(User user) throws SQLException;

}
