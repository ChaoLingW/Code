/**
 * 
 */
package com.hpe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpe.mapper.UserMapper;
import com.hpe.po.User;
import com.hpe.service.IUserService;

/**
 * 用户管理业务类
 * 
 * @author chaoling
 * @data 2018年9月10日
 * @version v1.0
 */
@Transactional
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectUser(User user) {
		return userMapper.selectOne(user);
	}

	@Override
	public List<User> selectUserList(User user) {
		return userMapper.select(user);
	}

	@Override
	public Integer selectUserCount(User user) {
		
		return userMapper.selectCount(user);
	}

	@Override
	public User selectUserByKey(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 *  问题：缺少异常的抛出
	 */
	
	@Override
	public Integer addUser(User user) {
		return userMapper.insert(user);
	}

	@Override
	public Integer delUser(int id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer delUser(User user) {
		return userMapper.delete(user);
	}

	@Override
	public Integer updateUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public List<User> selectPage() {
		
		// 通用mapper分页的工具类PageHelper
		PageHelper.startPage(0, 2); // 页数 行数
		List<User> list = userMapper.select(new User());
		// 调用分页封装类PageInfo
		PageInfo<User> info = new PageInfo<User>(list);
		
		return null;
	}

	@Override
	public List<User> seachUserList(User user) {
		
		// 通用mapper另一个查询对象
		Example exp = new Example(User.class);
		// 扩展exp （排序、查询子句）
		Criteria c = exp.createCriteria();	// 创建一个查询条件的标准
		// 可以添加（排序，查询子句）
		if(user != null && user.getUserName() != null && !user.getUserName().equals("")) {
			// 可以把username作为查询条件放置到查询语句中
			c.andLike("userName", "%" + user.getUserName() + "%");
			
		}
		
		if(user != null && user.getSex() != null && !user.getSex().equals("")) {
			// 可以把sex作为查询条件放置到查询语句中
			c.andEqualTo("sex", user.getSex());
			
		}
		
		if(user != null && user.getAddress() != null && !user.getAddress().equals("")) {
			// 可以把sex作为查询条件放置到查询语句中
			c.andLike("address", "%" + user.getAddress() + "%");
			
		}
		
		// order by
		exp.setOrderByClause(" id desc ");
		
		return userMapper.selectByExample(exp);
	}

	@Override
	public PageInfo<User> selectPage(User user, int pageNum) {
		
		// 分页封装
		PageHelper.startPage(pageNum, 5);
		List list = this.seachUserList(user);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		
		return pageInfo;
	}
	
}
