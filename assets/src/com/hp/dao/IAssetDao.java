package com.hp.dao;

import java.util.List;

import com.hp.po.Asset;
import com.hp.po.Bank;
import com.hp.po.User;

/**
 * @Description:对asset表操作的接口
 * @author chaoling
 * @date 2018年7月30日
 */
public interface IAssetDao {
	
	/**
	 * @Description: 查询该user下的所有asset表中的信息
	 * @param userId
	 * @return List<Asset> 若为null且size()为0,则不存在  
	 * @throws SQLException
	 */
	public List<Asset> selectAllAssetByUserName(int userId);
	
	/**
	 * @Description: 查询该BankID下cardNum是否存在
	 * @param bank
	 * @return >0 存在
	 * @throws SQLException
	 */
	public int selectCardNumByBankId(Bank bank);

	/**
	 * @Description: 添加资产
	 * @param asset
	 * @return 1 添加成功，0 添加失败  
	 * @throws SQLException
	 */
	public int addAsset(Asset asset);
	
	/**
	 * @Description: 判断该用户是否有该资产(多表查询)
	 * @param Asset
	 * @return asset为null则不存在
	 * @throws SQLException
	 */
	public Asset updateAssetBefore(Asset asset);
	
	/**
	 * @Description: 修改资产 (提取/存入)
	 * @param asset
	 * @return >0 修改成功 
	 * @throws SQLException
	 */
	public int updateAsset(Asset asset);
	
	/**
	 * @Description: 查询该用户下的总资产
	 * @param userId
	 * @return 返回总资产，若为-1.0 则说明无资产  
	 * @throws SQLException
	 */
	public double selectSumAsset(int userId);
	
}
