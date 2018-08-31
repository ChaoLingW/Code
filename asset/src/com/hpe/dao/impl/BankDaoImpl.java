package com.hpe.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hpe.dao.IBankDao;
import com.hpe.po.Bank;
import com.hpe.util.DBUtil;

/**
 * @Description:对bank表的操作，实现IBankDao接口
 * @author chaoling
 * @date 2018年8月3日
 */
public class BankDaoImpl implements IBankDao {

	private BeanHandler<Bank> bh = new BeanHandler<>(Bank.class);
	private BeanListHandler<Bank> blh = new BeanListHandler<>(Bank.class); 
	
	@Override
	public int addBank(Bank bank) throws SQLException {

		String sql = "insert into bank (bankName,bankTel) values(?,?)";
		Object[] params = { bank.getBankName(), bank.getBankTel(), bank.getBankId() };

		return DBUtil.update(sql, params);
	}

	@Override
	public int deleteBankByBankId(int bankId) throws SQLException {

		String sql = "delete from bank where bankId = ?";
		return DBUtil.update(sql, bankId);
	}

	@Override
	public int updateBankByBankId(Bank bank) throws SQLException {

		String sql = "update bank set bankName = ?,bankTel=? where bankId = ?";
		return DBUtil.update(sql, bank.getBankId());
	}

	@Override
	public List<Bank> selectALlBank() throws SQLException {

		String sql = "select * from bank";
		return DBUtil.query(sql, blh, null);
	}

	@Override
	public Bank selectBankByBankName(String bankName) throws SQLException {

		String sql = "select * from where bankName = ?";
		return DBUtil.query(sql, bh, bankName);
	}

	@Override
	public Bank selectBankByBankId(int bankId) throws SQLException {
		
		String sql = "select * from bank where bankId = ?";
		return DBUtil.query(sql, bh, bankId);
	}

}
