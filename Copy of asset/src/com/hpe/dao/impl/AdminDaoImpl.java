package com.hpe.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hpe.dao.gene.ISelectAll;
import com.hpe.dao.gene.ISelectOne;
import com.hpe.po.Admin;
import com.hpe.util.DBUtil;
/**
 * @DescriptionIAdmin接口的实现类，对admin表操作的具体实现
 * @author chaoling
 * @date 2018年8月2日
 */
public class AdminDaoImpl implements ISelectOne<Admin> {

	private BeanHandler<Admin> bh = new BeanHandler<>(Admin.class);
	
	/**
	 * 对admin查询，实现登录功能
	 * 返回对应的记录，为null表示不存在
	 */
	@Override
	public Admin selectOne(Admin admin) throws SQLException {
		
		String sql = "select * from admin where adminPassword = ? and adminName = ?";
		Object[] params = {admin.getAdminPassword(),admin.getAdminName()}; 
		
		return DBUtil.query(sql, bh, params);
	}

	
	
}
