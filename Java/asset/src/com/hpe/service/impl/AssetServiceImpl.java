package com.hpe.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hpe.dao.IAssetDao;
import com.hpe.dao.IBankDao;
import com.hpe.dao.impl.AssetDaoImpl;
import com.hpe.dao.impl.BankDaoImpl;
import com.hpe.po.Asset;
import com.hpe.service.IAssetService;
import com.hpe.vo.AssetInfo;
import com.mysql.jdbc.UpdatableResultSet;

/**
 * @Description:资产业务类，实现IAssetService接口
 * @author chaoling
 * @date 2018年8月4日
 */
public class AssetServiceImpl implements IAssetService {

	private IAssetDao assetDao = new AssetDaoImpl();
	private IBankDao bankDao = new BankDaoImpl();
	
	@Override
	public double selectSumMoneyByUserId(int userId) {
		
		try {
			return assetDao.selectSumMoney(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0.0;
	}

	@Override
	public List<AssetInfo> selectAssetsByUserId(int userId) {
		
		try {
			return assetDao.selectAssetByUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addAsset(Asset asset) {
		
		try {
			//查看此银行是否存在，不存在返回-1
			if(bankDao.selectBankByBankId(asset.getBankId()) == null)
				return -1;
			//查看此资产是否存在，如果存在返回-2
			if(assetDao.selectAssetByBankIdAndCardNumAndUser(asset) != null)
				return -2;
			//添加资产
			return assetDao.addAsset(asset);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return 0;
	}

	@Override
	public int extractAsset(Asset asset) {
		
		try {
			//查看此用户是否有此资产，如果没有，直接返回-1
			if(assetDao.selectAssetByBankIdAndCardNumAndUser(asset) == null)
				return -1;
			//查询余额，与要提取的余额比较，若小于待提取的资产，返回-2
			if(assetDao.selectCardMoneyByBankIdAndCardNum(asset)<asset.getCardMoney())
				return -2;
			//执行更新
			double cardMoney = asset.getCardMoney();
			asset.setCardMoney(-cardMoney);
			return assetDao.updateAssetByBankIdAndCardNum(asset);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int depositAsset(Asset asset) {
		
		try {
			//查看此资产是否存在，如果没有，返回-1
			if(assetDao.selectAssetByBankIdAndCardNumAndUser(asset) == null)
				return -1;
			//执行更新，并返回返回值
			return assetDao.updateAssetByBankIdAndCardNum(asset);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
