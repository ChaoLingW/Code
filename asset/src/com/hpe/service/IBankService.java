package com.hpe.service;

import java.util.List;

import com.hpe.po.Bank;

/**
 * @Description:银行业务的接口
 * @author chaoling
 * @date 2018年8月3日
 */
public interface IBankService {
	
	/**
	 * @Description: 查询所有银行的业务
	 * @return
	 */
	List<Bank> selectAllBank();

	/**
	 * @Description: 添加银行的业务
	 * @param bank
	 * @return -1 银行已存在 1 添加成功 0 添加失败 
	 */
	int addBank(Bank bank);

	/**
	 * @Description: 修改银行业务
	 * @param bank
	 * @return true 修改成功 false 修改失败
	 */
	int updateBank(Bank bank);
	
	/**
	 * @Description: 删除银行业务
	 * @param bankId
	 * @return -1 银行不存在 1 删除成功 0 删除失败
	 */
	int deleteBank(int bankId);
	
	/**
	 * @Description: 根据bankId判断该银行是否存在
	 * @param bankId
	 * @return true 存在 false 不存在
	 */
	boolean selectBankByBankId(int bankId);
	
	
	

}
