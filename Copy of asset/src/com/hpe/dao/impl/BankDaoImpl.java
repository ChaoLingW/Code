package com.hpe.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hpe.dao.gene.IAddAndUpdate;
import com.hpe.dao.gene.IDelete;
import com.hpe.dao.gene.ISelectAll;
import com.hpe.dao.gene.ISelectOne;
import com.hpe.po.Bank;
import com.hpe.util.DBUtil;

/**
 * @Description:对bank表的操作，实现IBankDao接口
 * @author chaoling
 * @date 2018年8月3日
 */
public class BankDaoImpl implements IAddAndUpdate<Bank>,ISelectAll<Bank>,IDelete {

	private BeanHandler<Bank> bh = new BeanHandler<>(Bank.class);
	private BeanListHandler<Bank> blh = new BeanListHandler<>(Bank.class); 

	/**
	 * 根据bankId删除银行
	 * 受影响的行数
	 */
	@Override
	public int delete(int bankId) throws SQLException {
		
		String sql = "delete from bank where bankId = ?";
		return DBUtil.update(sql, bankId);
		
	}

	/**
	 * 查询所有的bank表记录
	 * 所有的记录，为null表示不存在
	 */
	@Override
	public List<Bank> selectAll() throws SQLException {
		
		String sql = "select * from bank";
		return DBUtil.query(sql, blh, null);
	}

	/**
	 * 添加一条新的bank表记录
	 * 受影响的行数
	 */
	@Override
	public int add(Bank bank) throws SQLException {
		
		String sql = "insert into bank (bankName,bankTel) values(?,?)";
		Object[] params = { bank.getBankName(), bank.getBankTel(), bank.getBankId() };

		return DBUtil.update(sql, params);
	}

	/**
	 * 根据bankId修改bankName与bankTel
	 * 受影响的行数
	 */
	@Override
	public int update(Bank bank) throws SQLException {
		
		String sql = "update bank set bankName = ?,bankTel=? where bankId = ?";
		return DBUtil.update(sql, bank.getBankId());
	}

	/**
	 * @Description: 根据bankName查询所有符合的记录
	 * @param bankName
	 * @return 所有bankName的记录
	 * @throws SQLException
	 */
	public Bank selectBankByBankName(String bankName) throws SQLException {

		String sql = "select * from where bankName = ?";
		return DBUtil.query(sql, bh, bankName);
	}

	/**
	 * @Description: 根据bankId查询对应的bank表记录
	 * @param bankId
	 * @return 所有bankId的记录
	 * @throws SQLException
	 */
	public Bank selectBankByBankId(int bankId) throws SQLException {
		
		String sql = "select * from bank where bankId = ?";
		return DBUtil.query(sql, bh, bankId);
	}
	
}
