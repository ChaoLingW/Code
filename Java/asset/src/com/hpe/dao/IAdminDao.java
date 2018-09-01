package com.hpe.dao;

import java.sql.SQLException;

import com.hpe.po.Admin;

/**
 * @Description:对admin操作的接口
 * @author chaoling
 * @date 2018年8月2日
 */
public interface IAdminDao {

	/**
	 * @Description: 根据用户名及密码查询
	 * @param admin 
	 * @return admin  返回对应的记录
	 * @throws SQLException
	 */
	Admin selectAdminByNameAndPwd(Admin admin) throws SQLException;

}
