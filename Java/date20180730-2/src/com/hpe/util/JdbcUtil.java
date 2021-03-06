package com.hpe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: 连接数据库
 * @author chaoling
 * @date 2018年7月30日下午3:02:46
 */
public class JdbcUtil {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	// 在静态代码块中完成初始化
	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/bigdata2?useUnicode=true&characterEncoding";
		user = "root";
		password = "mysql";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: 连接数据库，并返回数据库连接 
	 * @return connection 
	 * @throws SQLException
	 */
	public static Connection getConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
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
	 * @Description: 关闭，释放资源
	 * @param resultSet
	 * @param statement
	 * @param connection     
	 * @throws
	 */
	public static void close(ResultSet resultSet,Statement statement, Connection connection) {

		close(resultSet);
		close(statement);
		close(connection);
	}

}
