package com.hpe.service.impl;

import java.sql.SQLException;

import com.hpe.dao.impl.AdminDaoImpl;
import com.hpe.po.Admin;
import com.hpe.service.gene.ISelectOne;

/**
 * @Description:admin业务的实现类。实现ILogin接口
 * @author chaoling
 * @date 2018年8月5日
 */
public class AdminService implements ISelectOne<Admin> {

	private AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
	
	/**
	 * 实现登录功能，为null表示不存在，即登录失败，否则登录成功
	 */
	@Override
	public  Admin login(Admin admin) {
		
		try {
			return adminDaoImpl.selectOne(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
