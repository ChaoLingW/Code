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
	
	//获取数据源
	public static DataSource getDataSource(){
		return dataSource;
	}
}
