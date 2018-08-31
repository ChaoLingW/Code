package com.hpe.base;

import java.sql.*;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hpe.util.MyDataSource;
import com.hpe.util.Page;

/**
 * dao层公共方法类。
 * 增删改方法 ，默认支持事务，需要在业务类中，添加事务。
 * @author yaohuicheng
 *
 * @param <T>
 */
public class BaseDao<T>{

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	/**
	 * 返回单个对象
	 * @param <T>
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 *            如果没有参数就设为 Object[] params={}
	 * @return
	 */
	public <T> T get(String sql, Class<T> clazz, Object[] params) {
		T obj = null;
		Connection conn = null;
		try {
			conn = MyDataSource.getConnection();
			QueryRunner qRunner = new QueryRunner();
			obj = qRunner.query(conn, sql, new BeanHandler<T>(clazz), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return obj;
	}

	/**
	 * 返回多个对象
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 *            如果没有参数就设为 Object[] params={}
	 * @return
	 */
	public <T> List<T> query(String sql, Class<T> clazz, Object[] params) {
		List beans = null;
		Connection conn = null;
		try {
			conn = MyDataSource.getConnection();
			QueryRunner qRunner = new QueryRunner();
			beans = (List) qRunner.query(conn, sql, new BeanListHandler<T>(clazz), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return beans;
	}
	/**
	 * 分页查询，返回page对象
	 * @param page
	 * @param beanClass
	 * @param sql
	 * @param params
	 * @return
	 */
	public <T> Page page(Page page ,Class<T> beanClass, String sql,Object[] params){
		// 当前页为1 
		if (page.getCurPage() < 1) {
			page.setCurPage(1);
		}
		int totalPages = 0;	//页数
		
		// limitsql语句 limit 4，4
		String sqlLimit = " limit " + (page.getCurPage()-1)*page.getPageNumber() + "," 
							+ page.getPageNumber();
		List<T> list = query(sql + sqlLimit ,beanClass,  params);
		
		// 计算总数
		Number num = this.getCount(" select count(*) c from ("+ sql +") as t ", params);
		int rows = (Integer)num.intValue();
		//求余数
		if(rows % page.getPageNumber() ==0){
			totalPages = rows / page.getPageNumber();
		}else{
			totalPages = rows / page.getPageNumber() + 1;
		}
		// 封装page
		page.setRows(num.intValue());
		page.setData(list);
		page.setTotalPage(totalPages); 
		
		return page;
	}

	/**
	 * 返回增删改是否成功
	 * 【注意，此方法没有关闭connection连接；需要在事务中关闭。 】
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public boolean update(String sql, Object[] params) throws Exception {
		Connection conn = getConnection();
		boolean flag = false;
		QueryRunner qRunner = new QueryRunner();
		int i = qRunner.update(conn, sql, params);
		if (i > 0) {
			flag = true;
		}
		return flag;
	}
	

	/***
	 * 批量操作，需要用到事务
	 * 【注意，此方法没有关闭connection连接；需要在事务中关闭。 】
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public boolean batchUpdate(String sql, Object[][] params) throws Exception {
		QueryRunner qRunner = new QueryRunner();
		int result = 0;
		boolean flag = false;
		result = qRunner.batch(getConnection(), sql, params).length;
		if (result > 0) {
			flag = true;
		}
		return flag;
	}
	/**
	 * 返回统计单值,
	 * @param sql
	 * @param params
	 * @return
	 */
	public Number getCount(String sql,Object[] params){
		Number value =0;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			value  = (Number) qRunner.query(conn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return value;
	}
	/**
	 * 返回主键,通常是执行insert语句时返回当前的主键值
	 * 【注意，此方法没有关闭connection连接；需要在事务中关闭。 】
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception 
	 */
    public Long getCurrentKey(String sql,Object[] params) throws Exception {
    	Connection conn = null;
		Long key = 0l;
		conn = getConnection();
		QueryRunner qRunner = new QueryRunner();
		key = (Long) qRunner.insert(conn,sql, new ScalarHandler(1), params);
		return key;
   }
    
	/**
	 * 从线程池中：获取数据连接。
	 * @return 
	 * @throws Exception
	 */
	public Connection getConnection(){
		Connection conn = tl.get();
		if(conn ==null){
			conn = MyDataSource.getConnection();
		}
		return conn;
	}
	/***********事务处理方法************/
	/**
	 * 开启事务
	 */
	public static void beginTranscation(){
		Connection conn = tl.get();

		try {
			conn = MyDataSource.getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tl.set(conn);
	}
	/**
	 * 结束事务
	 * @throws SQLException
	 */
	public static void endTranscation(){
		Connection conn = tl.get();
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 回滚
	 * @throws SQLException
	 */
	public static void rollback(){
		Connection conn = tl.get();
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 事务处理，关闭资源
	 * @throws SQLException
	 */
	public static void closeConn(){
		Connection conn = tl.get();
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tl.remove();
	}

	
}    
