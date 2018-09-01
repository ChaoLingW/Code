package com.hpe.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hpe.dao.gene.IAddAndUpdate;
import com.hpe.dao.gene.IDelete;
import com.hpe.dao.gene.ISelectOne;
import com.hpe.po.Asset;
import com.hpe.util.DBUtil;
import com.hpe.vo.AssetInfo;

public class AssetDaoImpl implements ISelectOne<Asset>, IAddAndUpdate<Asset>,IDelete {

	private BeanListHandler<AssetInfo> blh = new BeanListHandler<>(AssetInfo.class);
	private BeanHandler<Asset> bh = new BeanHandler<>(Asset.class);

	/**
	 * 根据bankId删除对应的asset表中的记录
	 * 受影响的行数
	 */
	@Override
	public int delete(int bankId) throws SQLException {

		String sql = "delete from asset where bankId = ?";
		return DBUtil.update(sql, bankId);
	}
	
	/**
	 * 添加新资产
	 * 受影响的行数
	 */
	@Override
	public int add(Asset asset) throws SQLException {

		String sql = "insert into asset values(?,?,?,?,?)";
		Object[] params = { asset.getBankId(), asset.getCardNum(), asset.getCardMoney(), asset.getCreateDate(),
				asset.getUserId() };

		return DBUtil.update(sql, params);
	}

	/**
	 * 更新资产 （提取/存入）
	 * 受影响的行数
	 */
	@Override
	public int update(Asset asset) throws SQLException {
		
		String sql = "update asset set cardMoney = cardMoney + ? where bankId = ? and cardNum = ?";
		Object[] params = { asset.getCardMoney(), asset.getBankId(), asset.getCardNum() };

		return DBUtil.update(sql, params);
	}

	/**
	 * 查询资产是否存在
	 * 受影响的行数
	 */
	@Override
	public Asset selectOne(Asset asset) throws SQLException {
		String sql = "select * from asset where userId = ? and bankId = ? and cardNum = ?";
		Object[] params = { asset.getUserId(), asset.getBankId(), asset.getCardNum() };

		return DBUtil.query(sql, bh, params);
	}

	/**
	 * @Description: 查询某userId下的所有资产
	 * @param userId
	 * @return 该userId下的所有资产列表，为null表示不存在
	 * @throws SQLException
	 */
	public List<AssetInfo> selectAll(int userId) throws SQLException {
		String sql = "select u.userId userId,u.userName userName,b.bankId bankId,b.bankName bankName,a.cardNum cardNum,a.cardMoney cardMoney,a.createDate creataDate from asset a"
				+ " inner join bank b on a.bankId = b.bankId" + " inner join user u on u.userId = a.userId "
				+ " where a.userId = ?";
		return DBUtil.query(sql, new BeanListHandler<>(AssetInfo.class), userId);

	}

	/**
	 * @Description: 根据userId查询总资产
	 * @param userId
	 * @return 总资产
	 * @throws SQLException
	 */
	public double selectSumMoney(int userId) throws SQLException {

		String sql = "select sum(cardMoney) cardMoney from asset where userId = ?";
		Asset asset = DBUtil.query(sql, bh, userId);

		return asset.getCardMoney();

	}

}
