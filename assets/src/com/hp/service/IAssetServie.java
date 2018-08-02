package com.hp.service;

import java.util.List;

import com.hp.po.Asset;
import com.hp.po.User;
import com.hp.vo.AssetInfo;

/**
 * @Description:资产业务接口
 * @author chaoling
 * @date 2018年7月31日
 */
public interface IAssetServie {
	
	/**
	 * @Description: 查询该user下的所有asset表中的信息
	 * @param user
	 * @return List<AssetInfo> 若为null且size()为0,则不存在  
	 */
	public List<AssetInfo> selectAllAssetByUserId(User user);

	/**
	 * @Description: 查询该用户下的总资产
	 * @param user
	 * @return 返回总资产，若为0.0则说明无资产  
	 */
	public double selectSumAsset(User user);
	
	/**
	 * @Description: TODO
	 * @param asset
	 * @return   
	 * @throws
	 */
	public int updateOfTake(Asset asset);
	
	/**
	 * @Description: TODO
	 * @param asset
	 * @return   
	 * @throws
	 */
	public int updateOfSave(Asset asset);
	
	/**
	 * @Description: TODO
	 * @param asset
	 * @return   
	 * @throws
	 */
	public int addNewAsset(Asset asset);
}
