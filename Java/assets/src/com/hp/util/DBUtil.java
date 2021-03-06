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
 * @Description: 对数据源的操作类
 * @author chaoling
 * @date 2018年7月30日
 */
public class DBUtil {
	
	private static DataSource dataSource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static QueryRunner qr = new QueryRunner(dataSource);


	/**
	 * @Description: 获取数据源
	 * @return  数据源 
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @Description: 获取连接
	 * @return 连接
	 * @throws SQLException   
	 * @throws
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if (con == null) {
			return dataSource.getConnection();
		}
		return con;
	}

	/**
	 * @Description: 开启事务
	 * @throws SQLException   
	 */
	public static void beginTranscation() throws SQLException {
		Connection con = tl.get();
		if (con != null) {
			throw new SQLException("事务已经开启，在没有结束当前事务时，不能再开启事务！");
		}
		con = dataSource.getConnection();
		con.setAutoCommit(false);
		tl.set(con);
	}

	/**
	 * @Description: 提交事务
	 * @throws SQLException   
	 */
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null) {
			throw new SQLException("当前没有事务，所以不能提交事务！");
		}
		con.commit();
		con.close();
		tl.remove();
	}

	/**
	 * @Description: 回滚事务
	 * @throws SQLException   
	 */
	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null) {
			throw new SQLException("当前没有事务，所以不能回滚事务！");
		}
		con.rollback();
		con.close();
		tl.remove();
	}

	/**
	 * @Description: 执行更新操作(多个条件)
	 * @param sql
	 * @param params
	 * @return row 受影响的行数
	 */
	public static int update(String sql, Object[] params)  {

		int row = 0;
		try {
			row = qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * @Description: 执行更新操作(一个条件)
	 * @param sql
	 * @param params
	 * @return row 受影响的行数
	 */
	public static int update(String sql, Object param)  {

		int row = 0;
		try {
			row = qr.update(sql, param);
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
