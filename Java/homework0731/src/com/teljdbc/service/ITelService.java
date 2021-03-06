package com.teljdbc.service;

import java.util.List;

import com.teljdbc.po.Telephone;

public interface ITelService {
	
	/**
	 * @Description: 添加业务处理
	 * @param telephone
	 * @return true 添加成功 false添加失败
	 */
	public boolean addTel(Telephone telephone);

	/**
	 * 
	 * @Description: 删除业务处理
	 * @param name
	 * @return -1 此人不存在 0 删除失败 1 删除成功    
	 */
	public int deleteTelByName(String name);

	/**
	 * @Description: 根据姓名更新
	 * @param telephone
	 * @return ture 更新成功 false 更新失败    
	 */
	public boolean updateTel(Telephone telephone);

	/**
	 * @Description: 查询所有
	 * @return tels  
	 */
	public List<Telephone> selectAllTel();

	/**
	 * @Description: 根据姓名查询
	 * @param name
	 * @return tel    
	 */
	public Telephone selectTelByName(String name);

}
