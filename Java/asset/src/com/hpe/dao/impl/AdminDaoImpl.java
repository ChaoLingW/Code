package com.hpe.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hpe.dao.IAdminDao;
import com.hpe.po.Admin;
import com.hpe.util.DBUtil;

/**
 * @DescriptionIAdmin接口的实现类，对admin表操作的具体实现
 * @author chaoling
 * @date 2018年8月2日
 */
public class AdminDaoImpl implements IAdminDao {

	private BeanHandler<Admin> bh = new BeanHandler<>(Admin.class);
	
	@Override
	public Admin selectAdminByNameAndPwd(Admin admin) throws SQLException {
		
		String sql = "select * from admin where adminName = ? and adminPassword = ?";
		Object[] params = {admin.getAdminName(),admin.getAdminPassword()};
		
		return DBUtil.query(sql, bh, params);
	}
	
}
