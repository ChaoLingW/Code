package com.hpe.service;

import java.util.List;

import com.hpe.po.Asset;
import com.hpe.vo.AssetInfo;

/**
 * @Description:资产业务的接口
 * @author chaoling
 * @date 2018年8月3日
 */
public interface IAssetService {

	/**
	 * @Description: 根据用户id查询资产
	 * @param userId
	 * @return 所有资产
	 */
	List<AssetInfo> selectAssetsByUserId(int userId);
	
	/**
	 * @Description: 根据用户id查询总资产
	 * @param userId
	 * @return 该用户的资产列表
	 */
	double selectSumMoneyByUserId(int userId);

	/**
	 * @Description: 添加资产
	 * @param asset 
	 * @return -1 银行不存在 -2 此资产已存在 0 添加失败 1 添加成功
	 */
	int addAsset(Asset asset);
	
	/**
	 * @Description: 提取资产
	 * @param asset 包括bankId cardNum cardMoney(待提取的金额) userId
	 * @return -2余额不足 -1 此用户无此资产 0 提取失败 1 提取成功 
	 */
	int extractAsset(Asset asset);
	
	/**
	 * @Description: 存入资产
	 * @param asset 包括bankId cardNum cardMoney(待存入的金额)
	 * @return -1 此资产不存在(此银行无此银行卡) 0 存入失败  1 存入成功
	 */
	int depositAsset(Asset asset);
	
}
