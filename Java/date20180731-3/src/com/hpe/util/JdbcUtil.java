package com.hpe.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @Description: 连接数据库
 * @author chaoling
 * @date 2018年7月30日下午3:02:46
 */
public class JdbcUtil {

	private static DataSource dataSource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if (con == null) {
			return dataSource.getConnection();
		}
		return con;
	}

	public static void beginTranscation() throws SQLException {
		Connection con = tl.get();
		if (con != null) {
			throw new SQLException("事务已经开启，在没有结束当前事务时，不能再开启事务！");
		}
		con = dataSource.getConnection();
		con.setAutoCommit(false);
		tl.set(con);
	}

	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null) {
			throw new SQLException("当前没有事务，所以不能提交事务！");
		}
		con.commit();
		con.close();
		tl.remove();
	}

	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null) {
			throw new SQLException("当前没有事务，所以不能回滚事务！");
		}
		con.rollback();
		con.close();
		tl.remove();
	}
}