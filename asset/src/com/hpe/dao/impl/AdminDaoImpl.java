package com.hpe.dao.impl;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hpe.dao.IAdminDao;
import com.hpe.po.Admin;

/**
 * @DescriptionIAdmin接口的实现类，对admin表操作的具体实现
 * @author chaoling
 * @date 2018年8月2日
 */
public class AdminDaoImpl implements IAdminDao {

	@Override
	public Admin selectAdminByNameAndPwd(Admin admin) {
		
		String sql = "select * from admin where adminName = ? and adminPassword = ?";
		
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		
		Object[] params = {admin.getAdminName(),admin.getAdminPassword()};
		
		Admin res = null;
		res = qr.query(sql, new BeanHandler<>(Admin.class),params);
		// TODO Auto-generated method stub
		return res;
	}

	
	
}
