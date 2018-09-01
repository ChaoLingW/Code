package com.hpe.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hpe.dao.IAssetDao;
import com.hpe.po.Asset;
import com.hpe.po.Bank;
import com.hpe.util.DBUtil;
import com.hpe.vo.AssetInfo;

/**
 * @Description:实现IAssetDao接口，对asset表的具体操作
 * @author chaoling
 * @date 2018年8月4日
 */
public class AssetDaoImpl implements IAssetDao {

	private BeanHandler<Asset> bh = new BeanHandler<>(Asset.class);
	private BeanListHandler<Asset> blh = new BeanListHandler<>(Asset.class);

	@Override
	public List<AssetInfo> selectAssetByUserId(int userId) throws SQLException {

		String sql = "select u.userId userId,u.userName userName,b.bankId bankId,b.bankName bankName,a.cardNum cardNum,a.cardMoney cardMoney,a.createDate creataDate from asset a"
				+ " inner join bank b on a.bankId = b.bankId" + " inner join user u on u.userId = a.userId "
				+ " where a.userId = ?";
		return DBUtil.query(sql, new BeanListHandler<>(AssetInfo.class), userId);

	}

	@Override
	public int deleteAssetByBankId(int bankId) throws SQLException {

		String sql = "delete from asset where bankId = ?";
		return DBUtil.update(sql, bankId);
	}

	@Override
	public Asset selectAssetByBankIdAndCardNum(Asset asset) throws SQLException {

		String sql = "select * from asset where bankId = ? and CardNum = ?";
		Object[] params = { asset.getBankId(), asset.getCardNum() };
		
		return DBUtil.query(sql, bh, params);
	}

	@Override
	public int addAsset(Asset asset) throws SQLException {

		String sql = "insert into asset values(?,?,?,?,?)";
		Object[] params = { asset.getBankId(), asset.getCardNum(), asset.getCardMoney(), asset.getCreateDate(),
				asset.getUserId() };

		return DBUtil.insert(sql, new ScalarHandler<>(),params);
	}

	@Override
	public Asset selectAssetByBankIdAndCardNumAndUser(Asset asset) throws SQLException {

		String sql = "select * from asset where userId = ? and bankId = ? and cardNum = ?";
		Object[] params = { asset.getUserId(), asset.getBankId(), asset.getCardNum() };

		return DBUtil.query(sql, bh, params);
	}

	@Override
	public double selectCardMoneyByBankIdAndCardNum(Asset asset) throws SQLException {

		String sql = "select * from asset where userId = ? and bankId = ? and cardNum = ?";
		Object[] params = { asset.getUserId(), asset.getBankId(), asset.getCardNum() };
		Asset res = DBUtil.query(sql, bh, params);
		
		return res.getCardMoney();
	}

	@Override
	public int updateAssetByBankIdAndCardNum(Asset asset) throws SQLException {
		
		String sql = "update asset set cardMoney = cardMoney + ? where bankId = ? and cardNum = ?";
		Object[] params = { asset.getCardMoney(), asset.getBankId(), asset.getCardNum() };
		
		return DBUtil.update(sql, params);
	}

	@Override
	public double selectSumMoney(int userId) throws SQLException {
		
		String sql = "select sum(cardMoney) cardMoney from asset where userId = ?";
		Asset asset = DBUtil.query(sql, bh, userId);
		
		return asset.getCardMoney();

	}

}
