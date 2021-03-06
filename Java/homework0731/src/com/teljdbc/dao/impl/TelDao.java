package com.teljdbc.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.teljdbc.dao.ITelDao;
import com.teljdbc.po.Telephone;
import com.teljdbc.util.DBDataScoure;
import com.teljdbc.util.DBUtil;

/**
 * @Description:tel表的操作类，实现了ITelDao接口
 * @author chaoling
 * @date 2018年7月31日
 */
public class TelDao implements ITelDao {

	DBUtil dbUtil = new DBUtil();

	@Override
	public int insert(Telephone telephone) {
		
		String sql = "insert into telephone (name,sex,age,tel,qq,address) values (?,?,?,?,?,?)";
		Object[] params ={telephone.getName(),telephone.getSex(),telephone.getAge(),telephone.getTel(),telephone.getQq(),telephone.getAddress()};
		
		return dbUtil.update(sql, params);
	}

	@Override
	public List<Telephone> select() {
		
		String sql = "select * from telephone";
		
		return dbUtil.query(sql, new BeanListHandler<>(Telephone.class), null);
	}
	
	@Override
	public Telephone select(String name) {
		
		String sql = "select * from telephone where name = ?";
		
		return dbUtil.query(sql, new BeanHandler<>(Telephone.class), name);
	}
	
	@Override
	public int delete(String name) {
		
		String sql = "delete from telephone where name = ?";
		Object[] params = {name};
		return dbUtil.update(sql, params);
	}
	
	@Override
	public int update(Telephone telephone) {
		
		String sql = "update telephone set name=?,sex=?,age=?,tel=?,qq=?,address=? where id = ?";
		Object[] params = {telephone.getName(),telephone.getSex(),telephone.getAge(),telephone.getTel(),telephone.getQq(),telephone.getAddress(),telephone.getId()};
			
		return dbUtil.update(sql, params);
	}

}
