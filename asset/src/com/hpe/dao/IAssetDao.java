package com.hpe.dao;

import java.sql.SQLException;
import java.util.List;

import com.hpe.po.Asset;
import com.hpe.vo.AssetInfo;

/**
 * @Description:对Asset表操作接口
 * @author chaoling
 * @date 2018年8月4日
 */
public interface IAssetDao {

	/**
	 * @Description: 查询该userId下的所有资产
	 * @param userId
	 * @return 该userId下的所有资产
	 * @throws SQLException 
	 */
	List<AssetInfo> selectAssetByUserId(int userId) throws SQLException;
	
	/**
	 * @Description: 根据bankId删除对应的bankId
	 * @param bankId
	 * @return 受影响的行数
	 * @throws SQLException 
	 */
	int deleteAssetByBankId(int bankId) throws SQLException;
	
	/**
	 * @Description: 根据bankId与CardNum查询资产
	 * @param asset
	 * @return 对应的资产记录，为null表示不为存在
	 * @throws SQLException 
	 */
	Asset selectAssetByBankIdAndCardNum(Asset asset) throws SQLException;
	
	/**
	 * @Description: 添加一条记录
	 * @param asset
	 * @return 受影响的行数
	 * @throws SQLException 
	 */
	int addAsset(Asset asset) throws SQLException;
	
	/**
	 * @Description: 根据bankId与CardNum与userId查询资产
	 * @param asset
	 * @return 对应的资产记录，为null表示不存在
	 * @throws SQLException 
	 */
	Asset selectAssetByBankIdAndCardNumAndUser(Asset asset) throws SQLException;
	
	/**
	 * @Description: 根据bankId和CardNum查询余额
	 * @param asset
	 * @return 余额
	 * @throws SQLException 
	 */
	double selectCardMoneyByBankIdAndCardNum(Asset asset) throws SQLException;
	
	/**
	 * @Description: 根据bankId，CardNum更新余额
	 * @param asset
	 * @return 受影响的行数
	 * @throws SQLException 
	 */
	int updateAssetByBankIdAndCardNum(Asset asset) throws SQLException;
	
	/**
	 * @Description: 根据用户id查询总资产
	 * @param userId
	 * @return 总资产
	 * @throws SQLException 
	 */
	double selectSumMoney(int userId) throws SQLException;

}
