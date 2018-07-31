package com.hp.dao;

import com.hp.po.Admin;
/**
 * @Description:对Admin表操作的接口
 * @author chaoling
 * @date 2018年7月30日
 */
public interface IAdminDao {

	/**
	 * @Description: 实现登录验证
	 * @param admin
	 * @return admin 返回这个admin
	 * @throws SQLException
	 */
	public Admin loginAdmin(Admin admin);

	/**
	 * @Description: 根据adminName查询是否存在该名字的管理员
	 * @param adminName
	 * @return  admin 用户存在返回该用户的所有信息，否则返回null  
	 * @throws SQLException
	 */
	public Admin selectByAdminName(String adminName);
	
}
