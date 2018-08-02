package com.hpe.dao;

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
	 * @return   
	 * @throws
	 */
	Admin selectAdminByNameAndPwd(Admin admin);
}
