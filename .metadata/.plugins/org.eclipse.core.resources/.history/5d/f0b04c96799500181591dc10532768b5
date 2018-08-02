package com.hp.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @Description:
 * @author chaoling
 * @date 2018年7月30日
 */
public class DBUtil {

	private static QueryRunner qr;

	static {
		DataSource ds = DBDataSource.getDataSource();
		qr = new QueryRunner(ds);
	}

	/**
	 * @Description: 执行更新操作
	 * @param sql
	 * @param params
	 * @return row 受影响的行数
	 * @throws SQLException
	 */
	public static int update(String sql, Object[] params) {

		int row = 0;
		try {
			row = qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * @Description: 查询所有的记录 
	 * @param sql 
	 * @param rsh 
	 * @param params 
	 * @return 存在就返回所有的记录，否则返回null
	 *  @throws SQLException
	 */
	public static <T> T query(String sql, ResultSetHandler<T> rsh, Object[] params) {

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
	public static <T> T query(String sql, ResultSetHandler<T> rsh, Object param) {

		T result = null;

		try {
			result = qr.query(sql, rsh, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
