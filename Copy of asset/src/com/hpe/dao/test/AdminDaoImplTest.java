package com.hpe.dao.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.hpe.dao.impl.AdminDaoImpl;
import com.hpe.po.Admin;
/**
 * @Description:AdminDaoImp类的测试类
 * @author chaoling
 * @date 2018年8月5日
 */
public class AdminDaoImplTest {

	@Test
	public void testSelectOne() {

		Admin admin = new Admin(1,"admin","admin");
		Admin one = null;
		try {
			one= new AdminDaoImpl().selectOne(admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(one);
	
	}

}
