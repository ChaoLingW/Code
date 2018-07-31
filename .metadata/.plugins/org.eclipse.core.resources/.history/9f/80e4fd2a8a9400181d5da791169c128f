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

	//创建数据源
	private static DataSource dataSource = new ComboPooledDataSource(); 

	/**
	 * @Description: 连接数据库，并返回数据库连接
	 * @return connection
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @Description: 关闭Connection
	 * @param connection
	 * @throws SQLException
	 */
	public static void close(Connection connection) {

		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * @Description: 关闭Statement
	 * @param statement
	 * @throws SQLException
	 */
	public static void close(Statement statement) {

		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * @Description: 关闭ResultSet
	 * @param resultSet
	 * @throws SQLException
	 */
	public static void close(ResultSet resultSet) {

		if (resultSet != null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * @Description: 关闭，释放资源 @param resultSet @param statement @param
	 *               connection @throws
	 */
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {

		close(resultSet);
		close(statement);
		close(connection);
	}

}
