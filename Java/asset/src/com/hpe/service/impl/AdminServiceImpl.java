package com.hpe.service.impl;

import java.sql.SQLException;

import com.hpe.dao.IAdminDao;
import com.hpe.dao.impl.AdminDaoImpl;
import com.hpe.po.Admin;
import com.hpe.service.IAdminService;

/**
 * @Description:管理员业务类，实现IAdminService
 * @author chaoling
 * @date 2018年8月4日
 */
public class AdminServiceImpl implements IAdminService{

	private IAdminDao adminDaoImpl = new AdminDaoImpl();
	private Admin admin = null;
	
	@Override
	public Admin select(Admin admin) {
		
		try {
			admin = adminDaoImpl.selectAdminByNameAndPwd(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

}
