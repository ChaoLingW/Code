package hpe.dao;

import java.util.List;

import hpe.po.User;

/**
 * 用户表操作接口
 * 		。。。
 * 
 * @author jntcf
 *
 */
public interface UserDao {
	/**
	 * 查询所有记录，结果以对象列表形式返回
	 * 
	 * @return
	 * 	对象列表
	 * @throws Exception 
	 */
	List<User> queryAll () throws Exception;	
	
	/**
	 * 用户注册
	 * 
	 * @param u	用户对象，含有所有属性
	 * @return
	 * 		>0	操作成功
	 * 		<=0	操作失败
	 * @throws Exception
	 */
	int addUser (User u) throws Exception;
	
}
