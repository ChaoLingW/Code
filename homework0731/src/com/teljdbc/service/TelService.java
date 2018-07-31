package com.teljdbc.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.teljdbc.dao.ITelDao;
import com.teljdbc.dao.impl.TelDao;
import com.teljdbc.po.Telephone;

/**
 * @Description: 业务类：负责业务处理
 * @author chaoling
 * @date 2018年7月29日下午1:38:29
 */
public class TelService implements ITelService {

	ITelDao telDao = new TelDao();
	
	@Override
	public boolean addTel(Telephone telephone) {

		int res = telDao.insert(telephone);
		
		if(res > 0)
			return true;
		
		return false;
	}
	
	@Override
	public int deleteTelByName(String name) {
		
		Telephone telephone = telDao.select(name);
		
		if(telephone == null)
			return -1;
		
		int res = telDao.delete(name);
		
		if(res > 0)
			return 1;
		return 0;
	}
	
	@Override
	public boolean updateTel(Telephone telephone) {
		
		int res = telDao.update(telephone);
		
		if( res > 0)
			return true;
		return false;
	}
	
	@Override
	public List<Telephone> selectAllTel() {
		
		return telDao.select();
	}
	@Override
	public Telephone selectTelByName(String name) {
		
		return telDao.select(name);
	}
}
