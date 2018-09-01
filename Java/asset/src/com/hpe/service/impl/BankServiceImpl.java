package com.hpe.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hpe.dao.IAssetDao;
import com.hpe.dao.IBankDao;
import com.hpe.dao.impl.AssetDaoImpl;
import com.hpe.dao.impl.BankDaoImpl;
import com.hpe.po.Bank;
import com.hpe.service.IBankService;
import com.hpe.util.DBUtil;

/**
 * @Description:bank业务的操作类 实现IBankService接口
 * @author chaoling
 * @date 2018年8月3日
 */

public class BankServiceImpl implements IBankService {

	private IBankDao bankDao = new BankDaoImpl();
	private IAssetDao assetDao = new AssetDaoImpl();

	@Override
	public List<Bank> selectAllBank() {

		try {
			return bankDao.selectALlBank();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addBank(Bank bank) {

		try {
			// 查询此名称的银行是否存在，存在，直接返回-1
			Bank res = bankDao.selectBankByBankName(bank.getBankName());
			if (res != null)
				return -1;
			// 添加更新，并将值返回
			return bankDao.addBank(bank);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBank(Bank bank) {

		try {
			if(bankDao.selectBankByBankName(bank.getBankName()) == null)
					return -1;
			return bankDao.updateBankByBankId(bank);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteBank(int bankId) {

		try {
			if (bankDao.selectBankByBankId(bankId) == null)
				return -1;
			// 开启事务
			DBUtil.beginTranscation();
			// 调用AssetDao中的deleteAssetByBankId();
			assetDao.deleteAssetByBankId(bankId);
			// 删除银行
			bankDao.deleteBankByBankId(bankId);
			// 提交事务
			DBUtil.commitTransaction();
			return 1;
		} catch (SQLException e) {
			// 回滚事务
			try {
				DBUtil.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public boolean selectBankByBankId(int bankId) {
		
		try {
			return bankDao.selectBankByBankId(bankId)== null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
