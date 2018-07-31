package com.hp.dao;

import com.hp.po.Admin;
/**
 * @Description:对Admin表操作的接口
 * @author chaoling
 * @date 2018年7月30日
 */
public interface AdminDao {

	/**
	 * @Description: 实现登录验证
	 * @param admin
	 * @return -1 该用户不存在; 0 用户名存在，密码不存在; 1 用户存在 
	 * @throws SQLException
	 */
	public int login(Admin admin);

	/**
	 * @Description: 对admin表执行查询操作
	 * @param admin
	 * @return 用户存在返回该用户的所有信息，否则返回null  
	 * @throws SQLException
	 */
	public Admin select(Admin admin);
	
}
