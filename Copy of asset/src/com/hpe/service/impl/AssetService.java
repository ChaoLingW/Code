package com.hpe.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hpe.dao.impl.AssetDaoImpl;
import com.hpe.dao.impl.BankDaoImpl;
import com.hpe.po.Asset;
import com.hpe.po.Bank;
import com.hpe.service.gene.IAdd;
import com.hpe.service.gene.ISelect;
import com.hpe.vo.AssetInfo;

/**
 * @Description:资产业务的实现类。实现IAdd与ISelect接口
 * @author chaoling
 * @date 2018年8月5日
 */
public class AssetService implements IAdd<Asset>, ISelect<List<AssetInfo>> {

	private AssetDaoImpl assetDao = new AssetDaoImpl();
	private BankDaoImpl bankDao = new BankDaoImpl();
	private Bank bank = new Bank();
	private Asset asset = new Asset();

	public AssetService(int userId) {
		this.asset.setUserId(userId);
	}

	public AssetService() {
		super();
	}

	/**
	 * @Description: 根据userId查询个人总资产
	 * @return 个人总资产
	 */
	public double selectSumMoneyByUserId() {
		try {
			return assetDao.selectSumMoney(asset.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0.0;
	}

	/**
	 * @Description: 提取资产功能
	 * @param asset
	 * @return -1 此资产不存在 -2 余额不足 0 提取失败 1 提取成功
	 */
	public int extractAsset(Asset asset) {
		try {
			// 查看此用户是否有此资产，如果灭有，直接返回-1
			Asset res = assetDao.selectOne(asset);
			if (res != null)
				return -1;
			// 查询余额，与要提取的余额比较，若小于待提取的资产，返回-2
			double cardMoney = res.getCardMoney();
			double extractMoney = asset.getCardMoney();
			if (extractMoney < cardMoney)
				return -2;
			// 执行更新
			asset.setCardMoney(-extractMoney);
			return assetDao.update(asset);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int depositAsset(Asset asset) {

		try {
			// 查看此资产是否存在，如果没有，返回-1
			Asset res = assetDao.selectOne(asset);
			if (res != null)
				return -1;
			// 执行更新，并返回返回值
			return assetDao.update(asset);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 添加资产
	 * -1 银行不存在， -2 资产已存在 0 添加成功 1 添加失败
	 */
	@Override
	public int add(Asset t) {

		try {
			// 查看此银行是否存在，不存在返回-1
			if (bankDao.selectBankByBankId(asset.getBankId()) == null)
				return -1;
			// 查看此资产是否存在，如果存在返回-2
			if (assetDao.selectOne(t) != null)
				return -2;
			// 添加资产
			return assetDao.add(asset);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<AssetInfo> selectAll() {
		try {
			return assetDao.selectAll(asset.getBankId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
