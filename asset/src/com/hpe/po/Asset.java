package com.hpe.po;

import java.util.Date;

/**
 * @Description:asset表对应的实体类
 * @author chaoling
 * @date 2018年8月3日
 */
public class Asset {

	private int bankId;
	private String cardNum;
	private double cardMoney;
	private Date createDate;
	private int userId;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public double getCardMoney() {
		return cardMoney;
	}

	public void setCardMoney(double cardMoney) {
		this.cardMoney = cardMoney;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Asset(int bankId, String cardNum, double cardMoney, Date createDate, int userId) {
		super();
		this.bankId = bankId;
		this.cardNum = cardNum;
		this.cardMoney = cardMoney;
		this.createDate = createDate;
		this.userId = userId;
	}

	public Asset() {
		super();
	}

	@Override
	public String toString() {
		return "Asset [bankId=" + bankId + ", cardNum=" + cardNum + ", cardMoney=" + cardMoney + ", createDate="
				+ createDate + ", userId=" + userId + "]";
	}

}
