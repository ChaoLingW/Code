package com.hpe.util;

import java.util.ArrayList;
import java.util.List;

import com.hpe.bean.User;

/**
 * 分页类，封装分页基本信息。首页默认1
 * @author Administrator
 * @version v1.0
 */
public class Page {
	//当前页
	private int curPage = 1;
	//总页数
	private int totalPage;
	//数据库记录数
	private int rows;
	//每页数据量
	private int pageNumber = 5;
	//要展示的List数据
	private List data = new ArrayList();
	// 查询条件
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public List getData() {
		return data;
	}
	public void setData(List date) {
		this.data = date;
	}
	
}
