package com.hpe.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hpe.base.BaseDao;
import com.hpe.bean.User;
import com.hpe.dao.IUserDao;
import com.hpe.util.Page;

/**
 * 对user表的操作的类
 * 
 * @author YHJ
 *
 */
public class UserDaoImpl extends BaseDao<User> implements IUserDao{

	@Override
	public User getUser(User user) {
		
		String sql = "select * from t_user where username=? and pwd=?";
		
		Object[] params = {user.getUsername(),user.getPwd()};
		
		User res = get(sql, User.class, params);
		
		return res;
	}

	@Override
	public boolean saveUser(User user) throws Exception {
		
		String sql="insert into t_user (username,pwd,sex,love,birthday,address,email,createDate,updateDate)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		
		Object[] params = {user.getUsername(),user.getPwd(),user.getSex(),user.getLove(),
				user.getBirthday(),user.getAddress(),user.getEmail(),user.getCreateDate(),user.getUpdateDate()};
		
		boolean isSave = update(sql, params);
		return isSave;
	}

	@Override
	public List<User> findAllUser() {
		
		String sql = "select * from t_user";
		return query(sql, User.class, null);
	}

	//User封装的是查询的条件
	@Override
	public Page searchUser(Page page,User user) {
		
		List<Object> params = new ArrayList<>();//占位符集合
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("select * from t_user where 1=1");
		
		
		if(user!=null)
		{
			//用户名
			String username = user.getUsername();
			if(username!=null&&!"".equals(username))
			{
				sb.append(" and username like ?");
				params.add("%"+username+"%");
			}
			//地址
			String address = user.getAddress();
			if(address!=null&&!"".equals(address))
			{
				sb.append(" and address like ?");
				params.add("%"+address+"%");
			}
			//时间
			String createDate = user.getCreateDate();
			if(createDate!=null&&!"".equals(createDate))
			{
				sb.append(" and createDate like ?");
				params.add("%"+createDate+"%");
			}
			//性别
			String sex = user.getSex();
			if(sex!=null&&!"".equals(sex))
			{
				sb.append(" and sex = ?");
				params.add(sex);
			}
		}
		sb.append(" order by createDate desc");
		
		page = page(page, User.class, sb.toString(), params.toArray());
		
		return page;
	}

	@Override
	public User findUserById(int id) {
		
		String sql = "select * from t_user where id=?";
		Object[] params = {id};
		return get(sql, User.class, params);
	}

	@Override
	public boolean updateUserById(User user) throws Exception {
		String sql = "update t_user set username=?,"
				+ "pwd=?,sex=?,love=?,birthday=?,address=?,"
				+ "email=?,createDate=?,updateDate=? where id=?";
		
		Object[] params = {user.getUsername(),user.getPwd(),user.getSex(),user.getLove(),
				user.getBirthday(),user.getAddress(),user.getEmail(),user.getCreateDate(),user.getUpdateDate(),user.getId()};
		
		return update(sql, params);
	}

}
