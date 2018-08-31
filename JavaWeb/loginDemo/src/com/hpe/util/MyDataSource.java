package com.hpe.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接池 c3p0数据源
 * 
 * @author Administrator
 */
public class MyDataSource {

	// 修改 数据库连接参
	public static String DRIVER;
	public static String URL;
	public static String USER;
	public static String PWD;
	public static int maxPoolSize;
	public static int minPoolSize;
	public static int initialPoolSize;
	public static int checkoutTimeout;
	private static final String filePath = "db.properties";
	
	private static ComboPooledDataSource cpDataSource = null;

	// 加载驱动
	static {
		try {
			// 读取配置文件，加载JDBC四大参数

			Properties config = new Properties();
			config.load(MyDataSource.class.getClassLoader().getResourceAsStream(filePath));
			DRIVER = config.getProperty("drivername");
			URL = config.getProperty("url");
			USER = config.getProperty("username");
			PWD = config.getProperty("password");

			maxPoolSize = Integer.parseInt(config.getProperty("maxPoolSize"));
			minPoolSize = Integer.parseInt(config.getProperty("minPoolSize"));
			initialPoolSize = Integer.parseInt(config.getProperty("initialPoolSize"));
			checkoutTimeout = Integer.parseInt(config.getProperty("checkoutTimeout"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**************** c3p0 数据库连接池 启动方法 ******************/
	private static void c3p0DataSource() throws Exception {
		cpDataSource = new ComboPooledDataSource();
		cpDataSource.setDriverClass(DRIVER);
		cpDataSource.setJdbcUrl(URL);
		cpDataSource.setUser(USER);
		cpDataSource.setPassword(PWD);
		cpDataSource.setMaxPoolSize(maxPoolSize);
		cpDataSource.setMinPoolSize(minPoolSize);
		cpDataSource.setInitialPoolSize(initialPoolSize);
		cpDataSource.setCheckoutTimeout(checkoutTimeout);
	}

	/**
	 * c3p0数据库连接入
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			if (cpDataSource == null) {
				c3p0DataSource();
			} 
			if(conn == null){
				conn = cpDataSource.getConnection();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
