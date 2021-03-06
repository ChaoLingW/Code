package com.hpe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.hpe.dao.IAccountDao;
import com.hpe.util.JdbcUtil;

public class AccountImpl implements IAccountDao {

	@Override
	public int updataAccount(int account, int money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Object[] params = { money, account };

		Connection connection = JdbcUtil.getConnection();

		String sql = "update account set accountmoney = accountmoney - ? where accountid = ?";

		PreparedStatement pstmt = null;

		int count = qr.update(JdbcUtil.getConnection(), sql, params);
		return count;

	}

}
