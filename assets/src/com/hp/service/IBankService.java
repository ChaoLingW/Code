package com.hp.service;

import java.sql.SQLException;
import java.util.List;

import com.hp.po.Bank;

/**
 * @Description:银行业务的接口类
 * @author chaoling
 * @date 2018年7月31日
 */
public interface IBankService {

	/**
	 * @Description: 添加一条银行记录
	 * @param bank 需要添加的银行的信息
	 * @return -1 该银行名已存在 0 添加失败 1 添加成功 
	 */
	int addBank(Bank bank);

	/**
	 * @Description: 根据银行id删除改银行
	 * @param bankId
	 * @return true 删除成功  false 删除失败
	 */
	boolean deleteBankByBankId(int bankId);
	
	/**
	 * @Description: 对bank表执行更新/修改操作
	 * @param bank 带修改的信息
	 * @return -1 银行名存在 1 更新成功；0更新失败
	 */
	int updateBankByBankId(Bank bank);
	
	/**
	 * @Description: 查询bank表中的所有记录
	 * @return banks 存储所有的记录，为空时且size()为0时表示表为空  
	 */
	public List<Bank> selectAll();
	
	/**
	 * @Description: 根据id查询是否存在该id的记录
	 * @param bankId
	 * @return 对应的银行记录，若不存在则为null
	 */
	public Bank selectByBankId(int bankId);

	/**
	 * @Description: 根据name查询是否存在该名称
	 * @param name
	 * @return bank 存在就返回这条记录，否则返回null   
	 */
	Bank selectByName(String name);

}
