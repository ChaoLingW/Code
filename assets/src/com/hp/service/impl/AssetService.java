package com.hp.service.impl;

import java.util.List;

import com.hp.dao.IAssetDao;
import com.hp.dao.IBankDao;
import com.hp.dao.impl.AssetDao;
import com.hp.dao.impl.BankDao;
import com.hp.po.Admin;
import com.hp.po.Asset;
import com.hp.po.Bank;
import com.hp.po.User;
import com.hp.service.IAdminService;
import com.hp.service.IAssetServie;
import com.hp.vo.AssetInfo;

/**
 * @Description:资产业务操作类 实现IAssetService
 * @author chaoling
 * @date 2018年8月1日
 */
public class AssetService implements IAssetServie {

	// 将需要的对象私有化
	private IAssetDao assetDao = new AssetDao();
	private IBankDao bankDao = new BankDao();

	@Override
	public List<AssetInfo> selectAllAssetByUserId(User user) {
		// 接收返回值
		List<AssetInfo> res = assetDao.selectAllAssetByUserId(user.getUserId());
		// 当返回值不为null且size()不为0时返回res,否则返回null
		if (res != null && res.size() != 0)
			return res;
		return null;
	}

	@Override
	public double selectSumAsset(User user) {
		// 返回资产
		return assetDao.selectSumAsset(user.getUserId());
	}

	@Override
	public int updateOfTake(Asset asset) {
		// 查询该资产是否存在
		Asset res = assetDao.selectOfTakeOrSave(asset);
		// null 返回-1 不存在
		if (res == null)
			return -1;
		// 对传递来的需要提取的金额获取，并取绝对值
		double updatecarMoney = asset.getCardMoney();
		updatecarMoney = Math.abs(updatecarMoney);
		// 获取账户余额
		double carMoney = res.getCardMoney();
		// 判断余额是否大于或等于待提取的金额，是则执行更新
		if (updatecarMoney <= carMoney) {
			// 获取更新结果
			int updateRes = assetDao.updateAsset(asset);
			if (updateRes > 0)
				// 更新成功
				return 1;
			// 更新失败
			return 0;
		}
		// 资产不足
		return 2;
	}

	@Override
	public int updateOfSave(Asset asset) {
		// 查询该资产
		Asset res = assetDao.selectOfTakeOrSave(asset);
		// 为null不存在
		if (res == null)
			return -1;
		// 执行更新，并接收返回值
		int updateRes = assetDao.updateAsset(asset);
		if (updateRes > 0)
			// 更新成功
			return 1;
		// 更新失败
		return 0;
	}

	@Override
	public int addNewAsset(Asset asset) {

		Bank bank = bankDao.selectByBankId(asset.getBankId());
		// 判断需要添加的银行是否存在
		if (bank == null)
			// 为null不存在，返回-1
			return -1;
		// 接收返回值：判断该银行下该账户是否存在
		int res = assetDao.selectCardNum(asset);
		if (res > 0)
			// 存在，返回2 该银行下该账户已存在
			return 2;
		// 执行更新，并接收返回值
		int addRes = assetDao.addAsset(asset);
		// 更新成功
		if (addRes > 0)
			return 1;
		// 更新失败
		return 0;
	}
}
