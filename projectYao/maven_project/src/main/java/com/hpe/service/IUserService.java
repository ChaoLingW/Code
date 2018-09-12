/**
 * 
 */
package com.hpe.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hpe.po.User;

/**
 * 用户表业务类接口
 * 
 * @author chaoling
 * @data 2018年9月10日
 * @version v
 */
public interface IUserService {

	/**
	 * 获取一个对象
	 * 
	 * @param user 对象 查询条件
	 * @return user对象 查询成功 null 查询失败
	 */
	User selectUser(User user);
	// 接口中的方法都是共有的，接口中的属性都是常量

	/**
	 * 多条件查询
	 * 
	 * @param user对象 查询条件
	 * @return list对象 查询成功 null 查询失败
	 */
	List<User> selectUserList(User user);

	/**
	 * 获取指定用户信息的数量
	 * 
	 * @param user 查询条件
	 * @return
	 */
	Integer selectUserCount(User user);

	/**
	 * 根据主键查询信息
	 * 
	 * @param id userId
	 * @return user对象 查询成功 null 查询失败
	 */
	User selectUserByKey(int id);

	/**
	 * 添加用户
	 * 
	 * @param user待添加的信息
	 * @return 受影响的行数 >0 添加成功 <=0 添加失败
	 */
	Integer addUser(User user);

	/**
	 * 根据id删除用户
	 * 
	 * @param id 删除id
	 * @return 受影响的行数 >0 删除成功 <=0 删除失败
	 */
	Integer delUser(int id);

	/**
	 * 根据用户信息删除用户
	 * 
	 * @param user 删除条件
	 * @return 受影响的行数 >0 删除成功 <=0 删除失败
	 */
	Integer delUser(User user);

	/**
	 * 修改用户
	 * 
	 * @param user 修改信息
	 * @return 受影响的行数 >0 修改成功 <=0 修改失败
	 */
	Integer updateUser(User user);

	/**
	 * 分页 
	 * 1.jdbc: limit 
	 * 2.简单封装: PageBean(页数、数据、每页显示的记录数等，首页是1或0) 
	 * 3.通用mapper的实现。
	 * 4.模糊查询分页
	 */

	/**
	 *  分页查询
	 *  
	 * @return list对象 查询成功 null 查询失败
	 */
	List<User> selectPage();
	
	/**
	 *  条件查询（模糊查询）
	 * @param user 查询条件
	 * @return list对象 查询成功 null 查询失败
	 */
	List<User> seachUserList(User user);
	
	/**
	 * 分页查询 + 模糊查询
	 * @param user 模糊查询条件
	 * @param pageNum 页数
	 * @return
	 */
	PageInfo<User> selectPage(User user, int pageNum);
}
