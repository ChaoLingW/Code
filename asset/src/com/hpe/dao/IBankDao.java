package com.hpe.dao;

import java.sql.SQLException;
import java.util.List;

import com.hpe.po.Bank;

/**
 * @Description:对bank表操作的接口
 * @author chaoling
 * @date 2018年8月3日
 */
public interface IBankDao {

	/**
	 * @Description: 向bank表中添加一个记录
	 * @param bank-->bankName,bankTel
	 * @return int-->受影响的行数
	 * @throws SQLException
	 */
	int addBank(Bank bank) throws SQLException;

	/**
	 * @Description: 根据银行id删除银行
	 * @param bankId
	 * @return int-->受影响的行数
	 * @throws SQLException
	 */
	int deleteBankByBankId(int bankId) throws SQLException;

	/**
	 * @Description: 根据银行id修改银行
	 * @param bank-->bankId,bankName,bankTel
	 * @return int-->受影响的行数
	 * @throws SQLException
	 */
	int updateBankByBankId(Bank bank) throws SQLException;

	/**
	 * @Description: 查询所有银行
	 * @return
	 * @throws SQLException
	 */
	List<Bank> selectALlBank() throws SQLException;

	/**
	 * @Description: 根据银行名查询
	 * @param bankName
	 * @return Bank-->为null没有此名称的银行，不为null有此名称的银行
	 * @throws SQLException
	 */
	Bank selectBankByBankName(String bankName) throws SQLException;

	/**
	 * @Description: 根据银行id查询
	 * @param bankId
	 * @return Bank-->为null没有此名称的银行，不为null有此名称的银行
	 * @throws SQLException
	 */
	Bank selectBankByBankId(int bankId) throws SQLException;

}
