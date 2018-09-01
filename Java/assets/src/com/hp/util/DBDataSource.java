package com.hp.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBDataSource {
	
	private static DataSource dataSource = new ComboPooledDataSource();
	
	/**
	 * @Description: 获取数据源
	 * @return dataSource  
	 */
	public static DataSource getDataSource(){
		
		return dataSource;
	}

}
