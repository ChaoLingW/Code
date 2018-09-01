package com.hp.po;
/**
 * @Description: user表对应的实体类
 * @author chaoling
 * @date 2018年7月30日下午4:58:19
 */
public class Bank {
	
	private int bankId;
	private String bankName;
	private String bankTel;
	
	public int getBankId() {
		return bankId;
	}
	
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankTel() {
		return bankTel;
	}
	
	public void setBankTel(String bankTel) {
		this.bankTel = bankTel;
	}

	public Bank(int bankId, String bankName, String bankTel) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.bankTel = bankTel;
	}

	public Bank() {
		super();
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bankTel=" + bankTel + "]";
	}
}
