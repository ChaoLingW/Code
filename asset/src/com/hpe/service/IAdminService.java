package com.hpe.service;

import com.hpe.po.Admin;

/**
 * @Description:管理员业务
 * @author chaoling
 * @date 2018年8月3日
 */
public interface IAdminService{

	/**
	 * @Description: 查询对应的管理员信息
	 * @param admin
	 * @return 对应的信息，为null表示不存在
	 */
	Admin select(Admin admin);
	
}
