package hpe.service;

import java.util.List;

import hpe.po.User;

/**
 * user业务的接口
 * 
 * @author chaoling 2018年8月27日
 */
public interface IUserService {

	/**
	 * 根据id查询用户记录
	 * 
	 * @param id
	 *            待查询用户的id
	 * @return 查询成功 用户对象（全部属性） 查询失败 null
	 */
	User selectUserById(int id);

	/**
	 * 根据username查询用户记录
	 * 
	 * @param username
	 *            待查询用户的username
	 * @return 查询成功 用户对象（全部属性） 查询失败 null
	 */
	User selectUserByUsername(String username);

	/**
	 * 查询所有的用户
	 * 
	 * @return 查询成功 List<User> 查询失败 null
	 */
	List<User> selectUserAll();

	/**
	 * 查询密码带”1”的女生并显示
	 * 
	 * @return 符合的所有记录
	 */
	List<User> selectUserByPasswordAndGender();

	/**
	 * 用户登录 根据用户名密码查询
	 * 
	 * @param user
	 *            必须设置username和password
	 * @return 查询成功 用户对象（全部属性） 查询失败 null
	 */
	User userLogin(User user);

	/**
	 * 添加记录
	 * 
	 * @param user
	 *            待添加的信息（不包括id）
	 * @return -1 用户名存在 0 添加失败 > 0添加成功 添加用户的id
	 */
	int insertUser(User user);

	/**
	 * 根据用户名删除用户
	 * 
	 * @param username
	 *            待删除用户的用户名
	 * @return -1 用户名不存在 0 删除失败 1 删除成功
	 */
	int deleteUserByUsername(String username);

	/**
	 * 根据用户id修改记录
	 * 
	 * @param user
	 *            待修改用户的信息
	 * @return -1 用户名存在 0 修改失败 1 修改成功
	 */
	int updateUserById(User user);

}
