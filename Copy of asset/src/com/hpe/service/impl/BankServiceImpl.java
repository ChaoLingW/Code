package com.hpe.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hpe.dao.gene.ISelectAll;
import com.hpe.dao.gene.ISelectOne;
import com.hpe.dao.impl.AssetDaoImpl;
import com.hpe.dao.impl.BankDaoImpl;
import com.hpe.po.Bank;
import com.hpe.service.gene.IAdd;
import com.hpe.service.gene.IUpdate;
import com.hpe.util.DBUtil;
/**
 * @Description:bank业务的操作类 实现IBankService接口
 * @author chaoling
 * @date 2018年8月3日
 */

public class BankServiceImpl implements ISelectAll<Bank>,IAdd<Bank>,IUpdate<Bank>,ISelectOne<Bank> {

	private BankDaoImpl bankDao = new BankDaoImpl();
	private AssetDaoImpl assetDao = new AssetDaoImpl();
	
	/**
	 * @Description: 删除bankId对应的银行，并删除对应的asset表表中的记录
	 * @param bankId
	 * @return 0 删除失败 1 删除成功
	 */
	public int deleteBank(int bankId) {
		
		try {
			//开启事务
			DBUtil.beginTranscation();
			//调用AssetDao中的deleteAssetByBankId();
			assetDao.delete(bankId);
			//删除银行
			bankDao.delete(bankId);
			//提交事务
			DBUtil.commitTransaction();
			return 1;
		} catch (SQLException e) {
			try {
				DBUtil.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @Description: 查询bankId对应的记录
	 * @param t
	 * @return null 不存在
	 */
	@Override
	public Bank selectOne(Bank t) {

		try {
			return bankDao.selectBankByBankId(t.getBankId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description: 修改bankId对应的银行信息
	 * @param t
	 * @return -1 银行不存在， 0 修改失败 1 修改成功
	 */
	@Override
	public int update(Bank t) {

		try {
			//判断该bankid是否存在 不存在返回-1;
			Bank bank = bankDao.selectBankByBankId(t.getBankId());
			if(bank == null)
				return -1;
			return bankDao.update(bank);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @Description: 添加一条bank表记录
	 * @param bank
	 * @return -1 该银行已存在 0 添加失败 1 添加成功
	 */
	@Override
	public int add(Bank bank) {
		
		try {
			//查询此名称的银行是否存在，存在，直接返回-1
			Bank res = bankDao.selectBankByBankName(bank.getBankName());
			if(res != null)
				return -1;
			//添加更新，并将值返回
			return bankDao.add(bank);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @Description: 查询bank表中的所有的记录
	 * @return
	 */
	@Override
	public List<Bank> selectAll() {
		
		try {
			return bankDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
