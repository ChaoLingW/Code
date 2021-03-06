package com.hp.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.hp.dao.IAssetDao;
import com.hp.po.Asset;
import com.hp.po.Bank;
import com.hp.util.DBUtil;
import com.hp.vo.AssetInfo;

/**
 * @Description:对Asset表的操作，实现IAssetDao接口
 * @author chaoling
 * @date 2018年8月1日
 */
public class AssetDao implements IAssetDao {

	@Override
	public List<AssetInfo> selectAllAssetByUserId(int userId) {

		// 根据userId查询对应的资产信息
		// 多表查询
		String sql = "select u.userId userId,u.userName userName,b.bankId bankId,b.bankName bankName,a.cardNum cardNum,a.cardMoney cardMoney,a.createDate creataDate from asset a"
				+ " inner join bank b on a.bankId = b.bankId" + " inner join user u on u.userId = a.userId "
				+ " where a.userId = ?";

		return DBUtil.query(sql, new BeanListHandler<>(AssetInfo.class), userId);
	}

	@Override
	public int addAsset(Asset asset) {

		// 插入银行信息
		String sql = "insert into asset values(?,?,?,?,?)";
		Object[] params = { asset.getBankId(), asset.getCardNum(), asset.getCardMoney(), asset.getCareteDate(),
				asset.getUserId() };

		return DBUtil.update(sql, params);
	}

	@Override
	public int updateAsset(Asset asset) {

		// 根据bankId与cardNum与userId设置cardNum
		String sql = "update asset set cardMoney = cardMoney + ? where bankId = ? and cardNum = ? and userId = ?";
		Object[] params = { asset.getCardMoney(), asset.getBankId(), asset.getCardNum(), asset.getUserId() };
		return DBUtil.update(sql, params);
	}

	@Override
	public double selectSumAsset(int userId) {

		// 根据userId查询sum(cardMoney)
		String sql = "select sum(cardMoney) from asset where userId = ?";
		Object obj = DBUtil.query(sql, new ScalarHandler<>(), userId);
		return (double) obj;

	}

	@Override
	public int selectCardNum(Asset asset) {

		// 根据userId与bankId查询对应的
		String sql = "select * from asset where bankId = ? and userId = ?";
		Object[] params = { asset.getBankId(), asset.getUserId() };

		List<Asset> res = DBUtil.query(sql, new BeanListHandler<>(Asset.class), params);
		if (res != null)
			return -1;
		return 1;

	}

	@Override
	public int deleteByBankId(int bankId) {

		// 根据bankId删除对应的银行
		String sql = "delete from asset where bankId = ?";

		return DBUtil.update(sql, bankId);
	}

	@Override
	public Asset selectOfTakeOrSave(Asset asset) {

		// 根据userId，bankId,cardNum获取对应的资产信息
		String sql = "select * from asset where userId = ? and bankId = ? and cardNum = ?";
		Object[] params = { asset.getUserId(), asset.getBankId(), asset.getCardNum() };

		return DBUtil.query(sql, new BeanHandler<>(Asset.class), params);
	}

}
