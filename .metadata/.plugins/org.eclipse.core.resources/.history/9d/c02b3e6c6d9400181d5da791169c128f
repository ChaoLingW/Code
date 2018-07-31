package com.hp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description:连接数据库，并对连接关闭，释放资源
 * @author chaoling
 * @date 2018年7月30日
 */
public class DBUtil {
	
	static private String driver;
	static private String user;
	static private String password;
	static private String url;
	
	static{
		driver = "com.mysql.jdbc.Driver";
		user = "root";
		password = "root";
		url = "jdbc:mysql://172.17.42.30:3306/assetmanager?useUnicode=true&characterEncoding";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: 创建数据库的连接
	 * @return connection    
	 * @throws SQLException
	 */
	public static Connection getConnection(){
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @Description: 关闭连接，释放资源
	 * @param rs
	 * @param pstmt
	 * @param connection     
	 * @throws SQLException
	 */
	public static void close(ResultSet rs,Statement pstmt, Connection connection){
		
		try {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
