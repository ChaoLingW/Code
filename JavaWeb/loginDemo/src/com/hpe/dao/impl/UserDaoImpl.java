package com.hpe.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hpe.base.BaseDao;
import com.hpe.bean.User;
import com.hpe.dao.IUserDao;
import com.hpe.util.Page;

/**
 * 对user表操作的类，继承BaseDao<T>,实现IUserDao接口
 * 
 * @author chaoling
 */
public class UserDaoImpl extends BaseDao<User> implements IUserDao {

	@Override
	public User getUser(User user) {

		String sql = " select * from t_user where username = ? and pwd = ?";
		String[] params = { user.getUsername(), user.getPwd() };

		return get(sql, User.class, params);

	}

	@Override
	public boolean saveUser(User user) throws Exception {

		String sql = "insert into t_user (username,pwd,sex,love,birthday,address,email,createDate,updateDate) "
				+ "value(?,?,?,?,?,?,?,?,?)";
		String[] params = { user.getUsername(), user.getPwd(), user.getSex(), user.getLove(), user.getBirthday(),
				user.getAddress(), user.getEmail(), user.getCreateDate(), user.getUpdateDate() };

		return update(sql, params);

	}

	@Override
	public List<User> findAllUser() {

		String sql = "select * from t_user";

		return query(sql, User.class, null);
	}

	

	@Override
	public Page searchUser(Page page, User user) {
		
		List<Object> params = new ArrayList<>();//占位符集合
		StringBuffer sb = new StringBuffer();
		
		sb.append("select * from t_user where 1 = 1");
		
		if (user != null) {
			
			//用户名
			String username = user.getUsername();
			if ( username != null && "".equals(username.trim())) {
				sb.append(" and username like ?");
				params.add("%" + username + "%");
			}
			
			//地址
			String address = user.getAddress();
			if ( address != null && "".equals(address.trim())) {
				sb.append(" and address like ?");
				params.add("%" + address + "%");
			}
			
			//时间
			String createDate = user.getCreateDate();
			if ( createDate != null && "".equals(createDate.trim())) {
				sb.append(" and createDate like ?");
				params.add("%" + createDate + "%");
			}
			
			//性别
			String sex = user.getSex();
			if ( sex != null && "".equals(sex.trim())) {
				sb.append(" and sex = ?");
				params.add(sex);
			}
			
		}
		
		sb.append(" order by createDate desc");
		
		return page(page, User.class, sb.toString(), params.toArray());
	}

	@Override
	public User findUserById(int id) {

		String sql = "select * from t_user where id = ?";
		Object[] params = { id };
		return this.get(sql, User.class, params);
	}
	
	@Override
	public boolean deleteUser(int id) throws Exception {

		String sql = "delete from t_user where id = ?";
		Object[] params = { id };
		return update(sql, params);
	}

	@Override
	public boolean updateUser(User user) throws Exception {

		String sql = "update user set username = ?, pwd = ?, sex = ?, love = ?, birthday = ?, address = ?, email = ?,updateDate = ? where id = ?";
		Object[] params = { user.getUsername(), user.getPwd(), user.getSex(), user.getLove(), user.getBirthday(),
				user.getAddress(), user.getEmail(), user.getUpdateDate(), user.getId() };

		return update(sql, params);
	}

}
