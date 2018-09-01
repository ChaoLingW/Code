package com.hpe.bean;


/**
 * user对象实体类 t_user表对应的实体类。  面对对象的思想。
 * 1、实现view层和控制层数据交互。
 * 2、控制层和业务层之间的数据交互。
 * 3、数据层和dao之间的数据对应。
 * 
 * 使用的DBUtil ,数据库 表中的列 和实体类的属性，一一对应。
 * @author Administrator
 *
 */
public class User {
	private int id; //主键
	private String username;// 用户名
	private String pwd;// 密码
	private String sex;// 性别
	private String love;// 爱好
	private String birthday;// 生日
	private String address;// 地址
	private String email;// 邮箱
	private String createDate;// 数据创建时间
	private String updateDate;// 数据修改时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
