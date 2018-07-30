package com.hp.dao;

import java.util.List;

import com.hp.po.User;

/**
 * @Description:对user表操作的接口
 * @author chaoling
 * @date 2018年7月30日
 */
public interface UserDao {
	
	/**
	 * @Description: 登录验证
	 * @return  -1 该用户不存在; 0 用户名存在，密码不存在; 1 用户存在  
	 * @throws SQLException
	 */
	public int login();
	
	/**
	 * @Description 根据用户名对本用户名下的密码进行修改
	 * @param userName
	 * @param userPassword
	 * @return true 修改成功  false 修改失败
	 * @throws SQLException
	 */
	public boolean updateByNameToPassword(String userName,String userPassword);

	/**
	 * @Description: 查询所有用户
	 * @return List<User> 当为null且size()为0时说明user表为空   
	 * @throws SQLException
	 */
	public List<User> seleteAll();
	
	/**
	 * @param user
	 * @return 用户存在，返回该用户的记录，否则返回null     
	 * @throws SQLException
	 */
	public User selete(User user);
	
	/**
	 * @Description: 根据userName查询是否存在该userName的记录
	 * @param name
	 * @return true 存在; false 不存在  
	 * @throws SQLException
	 */
	public boolean seleteByName(String name);
	/**
	 * @Description: 添加一条记录
	 * @param user
	 * @return true 添加成功; false 添加失败  
	 * @throws SQLException
	 */
	public boolean add(User user);
	
}
