package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.dao.AdminDao;
import com.hp.po.Admin;
import com.hp.util.DBUtil;

/**
 * @Description:admin的操作类
 * @author chaoling
 * @date 2018年7月30日
 */
public class AdminDaoImpl implements AdminDao {

	@Override
	public int login(Admin admin) {
		Admin res = select(admin);
		//为null说明不存该用户
		if(res == null)
			return -1;
		//全部相等说明 可以登录
		if(res.getAdminPassword().equals(admin.getAdminPassword()))
			return 1;
		//用户名存在，用户密码不对
		return 0;
	}
	
	@Override
	public Admin select(Admin admin) {

		Connection connection = null;
		String sql = "select * from where adminName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin res = null;

		try {
			connection = DBUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 如果查到这个name的记录，说明该用户名存在
			if (rs.next()) {
				int adminId = rs.getInt(1);
				String adminName = rs.getString(2);
				String adminPassword = rs.getString(3);
				res = new Admin(adminId, adminName, adminPassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
