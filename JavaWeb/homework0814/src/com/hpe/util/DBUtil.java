package com.hpe.util;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * TODO: 工具类
 * @author chaoling
 *
 */

public class DBUtil {
	
	private static DataSource dataSource = new ComboPooledDataSource();
	
	private static QueryRunner qr = new QueryRunner(dataSource);
	
	/**
	 * 根据信息查询某条记录
	 * @param sql 待执行的sql语句
	 * @param rsh 返回的记录所对应的对象
	 * @param param sql语句中对应的占位符数组
	 * @return 查询到的记录
	 * @throws SQLException
	 */
	public static <T> T query(String sql, ResultSetHandler<T> rsh,Object...params) throws SQLException{
		
		return qr.query(sql,rsh,params);
		
	}
	
	/**
	 * 根据信息进行更新
	 * @param sql 待执行的sql语句
	 * @param params sql语句中对应的参数数组
	 * @return 受影响的行数
	 * @throws SQLException
	 */
	 public static int update(String sql, Object... params) throws SQLException {
		return qr.update(sql, params);
		 
	 }

}
