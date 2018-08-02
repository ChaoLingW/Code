package com.hpe.dao;

import java.sql.SQLException;

public interface IAccountDao {

	//账户id,钱数
	int updataAccount(int account, int money) throws SQLException;
}
