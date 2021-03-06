package com.teljdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teljdbc.po.Telephone;
import com.teljdbc.util.DBDataScoure;

/**
 * @Description:user表操作接口
 * @author chaoling
 * @date 2018年7月31日
 */

public interface ITelDao {
	/**
	 * @Description: 向数据库中插入数据
	 * @param telephone
	 * @return >0 插入成功
	 * @throws SQLException
	 */
	public int insert(Telephone telephone);

	/**
	 * @Description: 查询全部
	 * @return List<Telephone>   
	 * @throws SQLException
	 */
	public List<Telephone> select();

	/**
	 * @Description: 根据姓名查询
	 * @param name
	 * @return 该条记录 不存在返回null   
	 * @throws SQLException
	 */
	public Telephone select(String name) ;

	/**
	 * @Description: 根据姓名删除
	 * @param name
	 * @return >0存在   
	 * @throws SQLException
	 */
	public int delete(String name);

	/**
	 * @Description: 根据姓名更新
	 * @param telephone
	 * @param name
	 * @return >0 存在    
	 * @throws SQLException
	 */
	public int update(Telephone telephone) ;

}
