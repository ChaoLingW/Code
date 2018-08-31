package com.hpe.dao;

import java.util.List;

import com.hpe.bean.User;
import com.hpe.util.Page;

/**
 * 对User表操作的接口
 * @author chaoling
 *
 */
public interface IUserDao {
	
	/**
	 * 根据用户名和密码查询记录
	 * @param user username pwd
	 * @return 符合条件的记录，null表示不存在此纪录即登陆失败
	 */
	User getUser(User user);
	
	/**
	 * 向user表中添加记录
	 * @param user 待添加的user信息
	 * @return true 添加成功，false 添加失败
	 * @throws Exception 
	 */
	boolean saveUser(User user) throws Exception;
	
	/**
	 * 查询所有的用户
	 * @return user表中所有的用户记录
	 */
	List<User> findAllUser();
	
	/**
	 * TODO 分页查询
	 * @param page
	 * @param user 模糊查询的条件
	 * @return
	 */
	Page searchUser(Page page, User user);
	
	/**
	 * TODO 根据Id查询
	 * @param id
	 * @return
	 */
	User findUserById(int id);
	
	/**
	 * 删除指定用户
	 * @param user 待删除用户的Id 
	 * @return true 删除成功，false 删除失败
	 * @throws Exception 
	 */
	boolean deleteUser(int id) throws Exception;
	
	/**
	 * 根据id修改用户
	 * @param user 待修改用户的信息 
	 * @return true 修改成功，false 修改失败
	 * @throws Exception 
	 */
	boolean updateUser(User user) throws Exception;
	
}
