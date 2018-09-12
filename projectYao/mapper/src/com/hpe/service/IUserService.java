/**
 * 
 */
package com.hpe.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hpe.po.User;

/**
 * �û���ҵ����ӿ�
 * 
 * @author chaoling
 * @data 2018��9��10��
 * @version v
 */
public interface IUserService {

	/**
	 * ��ȡһ������
	 * 
	 * @param user ���� ��ѯ����
	 * @return user���� ��ѯ�ɹ� null ��ѯʧ��
	 */
	User selectUser(User user);
	// �ӿ��еķ������ǹ��еģ��ӿ��е����Զ��ǳ���

	/**
	 * ��������ѯ
	 * 
	 * @param user���� ��ѯ����
	 * @return list���� ��ѯ�ɹ� null ��ѯʧ��
	 */
	List<User> selectUserList(User user);

	/**
	 * ��ȡָ���û���Ϣ������
	 * 
	 * @param user ��ѯ����
	 * @return
	 */
	Integer selectUserCount(User user);

	/**
	 * ����������ѯ��Ϣ
	 * 
	 * @param id userId
	 * @return user���� ��ѯ�ɹ� null ��ѯʧ��
	 */
	User selectUserByKey(int id);

	/**
	 * ����û�
	 * 
	 * @param user����ӵ���Ϣ
	 * @return ��Ӱ������� >0 ��ӳɹ� <=0 ���ʧ��
	 */
	Integer addUser(User user);

	/**
	 * ����idɾ���û�
	 * 
	 * @param id ɾ��id
	 * @return ��Ӱ������� >0 ɾ���ɹ� <=0 ɾ��ʧ��
	 */
	Integer delUser(int id);

	/**
	 * �����û���Ϣɾ���û�
	 * 
	 * @param user ɾ������
	 * @return ��Ӱ������� >0 ɾ���ɹ� <=0 ɾ��ʧ��
	 */
	Integer delUser(User user);

	/**
	 * �޸��û�
	 * 
	 * @param user �޸���Ϣ
	 * @return ��Ӱ������� >0 �޸ĳɹ� <=0 �޸�ʧ��
	 */
	Integer updateUser(User user);

	/**
	 * ��ҳ 
	 * 1.jdbc: limit 
	 * 2.�򵥷�װ: PageBean(ҳ�������ݡ�ÿҳ��ʾ�ļ�¼���ȣ���ҳ��1��0) 
	 * 3.ͨ��mapper��ʵ�֡�
	 * 4.ģ����ѯ��ҳ
	 */

	/**
	 *  ��ҳ��ѯ
	 *  
	 * @return list���� ��ѯ�ɹ� null ��ѯʧ��
	 */
	List<User> selectPage();
	
	/**
	 *  ������ѯ��ģ����ѯ��
	 * @param user ��ѯ����
	 * @return list���� ��ѯ�ɹ� null ��ѯʧ��
	 */
	List<User> seachUserList(User user);
	
	/**
	 * ��ҳ��ѯ + ģ����ѯ
	 * @param user ģ����ѯ����
	 * @param pageNum ҳ��
	 * @return
	 */
	PageInfo<User> selectPage(User user, int pageNum);
}
