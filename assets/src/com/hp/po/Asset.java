package com.hp.po;

import java.util.Date;

/**
 * @Description: asset表对应的实体类
 * @author chaoling
 * @date 2018年7月30日下午4:54:11
 */
public class Asset {

	private int bankId;
	private int cardNum;
	private double cardMoney;
	private Date careteDate; 
	private int userId;
	
	public int getBankId() {
		return bankId;
	}
	
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
	public int getCardNum() {
		return cardNum;
	}
	
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	
	public double getCardMoney() {
		return cardMoney;
	}
	
	public void setCardMoney(double cardMoney) {
		this.cardMoney = cardMoney;
	}
	
	public Date getCareteDate() {
		return careteDate;
	}
	
	public void setCareteDate(Date careteDate) {
		this.careteDate = careteDate;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Asset(int bankId, int cardNum, double cardMoney, Date careteDate, int userId) {
		super();
		this.bankId = bankId;
		this.cardNum = cardNum;
		this.cardMoney = cardMoney;
		this.careteDate = careteDate;
		this.userId = userId;
	}

	public Asset() {
		super();
	}

	@Override
	public String toString() {
		return "Asset [bankId=" + bankId + ", cardNum=" + cardNum + ", cardMoney=" + cardMoney + ", careteDate="
				+ careteDate + ", userId=" + userId + "]";
	}
}
