package com.hpe.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hpe.dao.gene.IAddAndUpdate;
import com.hpe.dao.gene.ISelectAll;
import com.hpe.dao.gene.ISelectOne;
import com.hpe.po.User;
import com.hpe.util.DBUtil;

/**
 * @Description:user表的操作类，实现 ISelectAll,IAddAndUpdate,ISelectOne接口
 * @author chaoling
 * @date 2018年8月5日
 */
public class UserDaoImpl implements ISelectAll<List<User>>, IAddAndUpdate<User>, ISelectOne<User> {

	private BeanHandler<User> bh = new BeanHandler<>(User.class);
	private BeanListHandler<User> blh = new BeanListHandler<>(User.class);

	/**
	 * 查询对应的记录 实现登录查询的功能，null表示该user不存在
	 */
	@Override
	public User selectOne(User t) throws SQLException {

		String sql = "select * from user where userName = ? and userPassword = ?";
		Object[] params = { t.getUserName(), t.getUserPassword() };
		return DBUtil.query(sql, bh, params);
	}

	/**
	 * 向user表添加记录 返回受影响的行数
	 */
	@Override
	public int add(User t) throws SQLException {

		String sql = "insert into user (userName,userPassword,realName,sex,tel,idCard,address)"
				+ " values(?,?,?,?,?,?,?)";

		Object[] params = { t.getUserName(), t.getUserPassword(), t.getRealName(), t.getSex(), t.getTel(),
				t.getIdCard(), t.getAddress() };

		// QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		// qr.insert(sql, new ScalarHandler<>(),params);

		Object res = DBUtil.insert(sql, new ScalarHandler<>(), params);
		return Integer.parseInt(res.toString());

	}

	/**
	 * 修改本用户密码 返回受影响的行数
	 */
	@Override
	public int update(User t) throws SQLException {

		String sql = "update user set userPassword = ? where userId = ?";
		Object[] params = { t.getUserPassword(), t.getUserId() };
		return DBUtil.update(sql, params);
	}

	/**
	 * 查询user表中所有的记录
	 */
	@Override
	public List<User> selectAll() throws SQLException {

		String sql = "select * from user";
		return DBUtil.query(sql, blh, null);
	}

	/**
	 * @Description: 根据name查询对应的记录
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public User selectUserByUserName(String name) throws SQLException {

		String sql = "select * from user where userName = ?";
		return DBUtil.query(sql, bh, name);
	}
}
