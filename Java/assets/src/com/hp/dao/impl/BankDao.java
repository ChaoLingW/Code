package com.hp.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hp.dao.IBankDao;
import com.hp.po.Bank;
import com.hp.util.DBUtil;

/**
 * @Description:对bank表的操作类 实现IbankDao接口
 * @author chaoling
 * @date 2018年8月1日
 */
public class BankDao implements IBankDao {

	@Override
	public int addBank(Bank bank) {
		// 插入一条银行记录
		String sql = "insert into bank (bankName,bankTel) values(?,?)";
		Object[] params = { bank.getBankName(), bank.getBankTel() };

		return DBUtil.update(sql, params);
	}

	@Override
	public int deleteBankByBankId(int bankId) {
		// 根据bankId删除对应的银行记录
		String sql = "delete from bank where bankId = ?";
		return DBUtil.update(sql, bankId);
	}

	@Override
	public int updateBankByBankId(Bank bank) {
		// 根据bankId修改信息
		String sql = "update bank set bankName = ?,bankTel = ? where bankId = ? ";
		Object[] params = { bank.getBankName(), bank.getBankTel(), bank.getBankId() };

		return DBUtil.update(sql, params);
	}

	@Override
	public List<Bank> selectAll() {
		// 查询所有
		String sql = "select * from bank";

		return DBUtil.query(sql, new BeanListHandler<>(Bank.class), null);
	}

	@Override
	public Bank selectByBankId(int bankId) {
		// 根据bankid查询对应的记录
		String sql = "select * from bank where bankId = ?";
		return DBUtil.query(sql, new BeanHandler<>(Bank.class), bankId);
	}

	@Override
	public Bank selectByBankName(String bankName) {
		// 根据bankName查询对应的记录
		String sql = "select * from bank where bankName = ?";
		return DBUtil.query(sql, new BeanHandler<>(Bank.class), bankName);
	}

}
