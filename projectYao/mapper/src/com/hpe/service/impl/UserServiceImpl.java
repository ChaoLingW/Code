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
 * �û�����ҵ����
 * 
 * @author chaoling
 * @data 2018��9��10��
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
	 *  ���⣺ȱ���쳣���׳�
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
		
		// ͨ��mapper��ҳ�Ĺ�����PageHelper
		PageHelper.startPage(0, 2); // ҳ�� ����
		List<User> list = userMapper.select(new User());
		// ���÷�ҳ��װ��PageInfo
		PageInfo<User> info = new PageInfo<User>(list);
		
		return null;
	}

	@Override
	public List<User> seachUserList(User user) {
		
		// ͨ��mapper��һ����ѯ����
		Example exp = new Example(User.class);
		// ��չexp �����򡢲�ѯ�Ӿ䣩
		Criteria c = exp.createCriteria();	// ����һ����ѯ�����ı�׼
		// ������ӣ����򣬲�ѯ�Ӿ䣩
		if(user != null && user.getUserName() != null && !user.getUserName().equals("")) {
			// ���԰�username��Ϊ��ѯ�������õ���ѯ�����
			c.andLike("userName", "%" + user.getUserName() + "%");
			
		}
		
		if(user != null && user.getSex() != null && !user.getSex().equals("")) {
			// ���԰�sex��Ϊ��ѯ�������õ���ѯ�����
			c.andEqualTo("sex", user.getSex());
			
		}
		
		if(user != null && user.getAddress() != null && !user.getAddress().equals("")) {
			// ���԰�sex��Ϊ��ѯ�������õ���ѯ�����
			c.andLike("address", "%" + user.getAddress() + "%");
			
		}
		
		// order by
		exp.setOrderByClause(" id desc ");
		
		return userMapper.selectByExample(exp);
	}

	@Override
	public PageInfo<User> selectPage(User user, int pageNum) {
		
		// ��ҳ��װ
		PageHelper.startPage(pageNum, 5);
		List list = this.seachUserList(user);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		
		return pageInfo;
	}
	
}
