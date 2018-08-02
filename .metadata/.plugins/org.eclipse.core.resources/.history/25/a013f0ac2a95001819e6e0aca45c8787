package com.teljdbc.util;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * 
 * @Description:使用Apache
 * @author chaoling
 * @date 2018年7月31日
 */
public class DBUtil {
	DataSource ds = DBDataScoure.getDataSource();
	private QueryRunner qr = new QueryRunner(ds);


	/**
	 * @Description: 对表执行更新操作（增删改）
	 * @param sql
	 * @param params
	 * @return 受影响的行数
	 * @throws SQLException
	 */
	public int update(String sql, Object[] params) {

		int res = 0;

		try {
			res = qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * @Description: 查询所有的记录
	 * @param sql
	 * @param rsh
	 * @param params
	 * @return 存在就返回所有的记录，否则返回null
	 * @throws SQLException
	 */
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) {

		T result = null;

		try {
			result = qr.query(sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * @Description: 查询一条记录
	 * @param sql
	 * @param rsh
	 * @param param
	 * @return 如果存在这条记录返回对应的实体类对象，否则为null
	 * @throws SQLException
	 */
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object param) {

		T result = null;

		try {
			result = qr.query(sql, rsh, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


}
