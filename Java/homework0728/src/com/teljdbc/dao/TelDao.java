package com.teljdbc.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.teljdbc.po.Telephone;
import com.teljdbc.util.JdbcUtil;

/**
 * @Description: 数据库操作类
 * @author chaoling
 * @date 2018年7月29日下午1:40:08
 */
public class TelDao {

	/**
	 * @Description: 向数据库中插入数据
	 * @param telephone
	 * @return flag
	 * @throws SQLException
	 */
	public boolean insert(Telephone telephone) {

		String sql = "insert into telephone (name,sex,age,tel,qq,address) values (?,?,?,?,?,?)";
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		boolean flag = true;

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, telephone.getName());
			pstmt.setString(2, telephone.getSex());
			pstmt.setInt(3, telephone.getAge());
			pstmt.setString(4, telephone.getTel());
			pstmt.setString(5, telephone.getQq());
			pstmt.setString(6, telephone.getAddress());

			int row = pstmt.executeUpdate();

			if (row < 0)
				flag = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection,pstmt);
		}
		return flag;
	}

	/**
	 * @Description: 查询全部
	 * @return List<Telephone>   
	 * @throws
	 */
	public List<Telephone> select() {

		String sql = "select * from telephone";
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		List<Telephone> tels = new ArrayList<>();
		ResultSet result = null;
		try {
			pstmt = connection.prepareStatement(sql);

			result = pstmt.executeQuery();
			// name,sex,age,tel,qq,address
			while (result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				String sex = result.getString(3);
				int age = result.getInt(4);
				String tel = result.getString(5);
				String qq = result.getString(6);
				String address = result.getString(7);
				
				Telephone telephone = new Telephone(id,name, sex, age, tel, qq, address);
				
				tels.add(telephone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection,pstmt,result);
		}
		return tels;
	}

	/**
	 * @Description: 根据姓名查询
	 * @param name
	 * @return index    
	 * @throws
	 */
	public Telephone select(String name) {

		String sql = "select * from telephone where name = ?";
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Telephone telephone = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeQuery();
			if(result.next()) {
				int id = result.getInt(1);
				name = result.getString(2);
				String sex = result.getString(3);
				int age = result.getInt(4);
				String tel = result.getString(5);
				String qq = result.getString(6);
				String address = result.getString(7);
				telephone = new Telephone(id, name, sex, age, tel, qq, address);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection,pstmt,result);
		}
		return telephone;
	}
	
	/**
	 * @Description: 根据姓名删除
	 * @param name
	 * @return flag    
	 * @throws
	 */
	public boolean delete(String name) {

		String sql = "delete from telephone where name = ?";
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		boolean flag = true;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			int row = pstmt.executeUpdate();
			if(row < 1)
				flag = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection,pstmt);
		}
		return flag;
	}

	/**
	 * @Description: 根据姓名更新
	 * @param telephone
	 * @param name
	 * @return     
	 * @throws
	 */
	public boolean update(Telephone telephone, String name) {
		
		String sql = "update telephone set name=?,sex=?,age=?,tel=?,qq=?,address=? where id = ?";
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		boolean flag = true;
		Telephone tel = select(name);
		int index = tel.getId();
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, telephone.getName());
			pstmt.setString(2, telephone.getSex());
			pstmt.setInt(3, telephone.getAge());
			pstmt.setString(4, telephone.getTel());
			pstmt.setString(5, telephone.getQq());
			pstmt.setString(6, telephone.getAddress());
			pstmt.setInt(7, index);
			int row = pstmt.executeUpdate();
			if(row < 1)
				flag = false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection,pstmt);
		}
		return flag;
	}
}
