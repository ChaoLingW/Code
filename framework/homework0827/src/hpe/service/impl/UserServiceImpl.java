package hpe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import hpe.dao.IUserDao;
import hpe.po.User;
import hpe.service.IUserService;
import hpe.utils.DBUtils;

/**
 * IUserService接口的实现类
 * 
 * @author chaoling 2018年8月27日
 */
public class UserServiceImpl implements IUserService {

	private IUserDao userDao = null; // IUserDao的操作对象

	@Override
	public User selectUserById(int id) {

		SqlSession session = DBUtils.getSession();
		userDao = session.getMapper(IUserDao.class);
		// 返回值对象user
		User user = null;

		try {
			// 调用selectUserById方法
			user = userDao.selectUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeSession(session);
		}

		return user;
	}

	@Override
	public User selectUserByUsername(String username) {

		SqlSession session = DBUtils.getSession();
		userDao = session.getMapper(IUserDao.class);
		// 返回值对象user
		User user = null;

		try {
			// 调用selectUserByUsername方法
			user = userDao.selectUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeSession(session);
		}

		return user;
	}

	@Override
	public List<User> selectUserAll() {

		SqlSession session = DBUtils.getSession();
		userDao = session.getMapper(IUserDao.class);
		// 返回值对象list
		List<User> users = new ArrayList<User>();

		try {
			// 调用selectUserAll方法
			userDao.selectUserAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeSession(session);
		}

		return users;
	}

	@Override
	public List<User> selectUserByPasswordAndGender() {

		SqlSession session = DBUtils.getSession();
		userDao = session.getMapper(IUserDao.class);
		// 返回值对象list
		List<User> users = new ArrayList<User>();

		try {
			// 调用selectUserByPasswordAndGender方法
			userDao.selectUserByPasswordAndGender();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeSession(session);
		}

		return users;
	}

	@Override
	public User userLogin(User user) {
		SqlSession session = DBUtils.getSession();
		userDao = session.getMapper(IUserDao.class);
		// 返回值对象user
		User userRes = null;

		try {
			// 调用selectUserByUsernameAndPassword方法
			userRes = userDao.selectUserByUsernameAndPassword(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeSession(session);
		}

		return userRes;
	}

	@Override
	public int insertUser(User user) {

		SqlSession session = DBUtils.getSession();
		userDao = session.getMapper(IUserDao.class);
		// 返回值
		int row = 0;

		try {
			// 判断用户名是否存在
			User userRes = userDao.selectUserByUsername(user.getUsername());
			if (userRes == null) {
				// 调用insertUser方法
				row = userDao.insertUser(user);
			} else {
				// 用户名存在
				row = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeSession(session);
		}
		// 判断是否修改添加成功
		if (row > 0) {
			row = user.getId();
		}
		return row;
	}

	@Override
	public int deleteUserByUsername(String username) {

		SqlSession session = DBUtils.getSession();
		userDao = session.getMapper(IUserDao.class);
		// 返回值
		int row = 0;

		try {
			// 判断用户名是否存在
			User user = userDao.selectUserByUsername(username);

			if (user != null) {
				// 用户名存在，可以进行删除
				// 调用deleteUserByUsername方法
				row = userDao.deleteUserByUsername(username);
			} else {
				// 用户名不存在
				row = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeSession(session);
		}

		return row;
	}

	@Override
	public int updateUserById(User user) {

		SqlSession session = DBUtils.getSession();
		userDao = session.getMapper(IUserDao.class);
		// 返回值
		int row = 0;
		try {
			// 判断用户名是否存在
			User res = userDao.selectUserByUsername(user.getUsername());
			if (res != null) {
				return -1;
			}
			// 调用updateUserById方法
			row = userDao.updateUserById(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeSession(session);
		}

		return row;
	}

}
