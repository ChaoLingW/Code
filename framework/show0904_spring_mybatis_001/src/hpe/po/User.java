package hpe.po;

/**
 * mybatis.user对应的实体类
 * 
 * @author jntcf
 *
 */
public class User {
	private int id;				//用户ID
	private String username;	//用户名
	private String pwd;			//
	private String birthday;
	private String sex;
	private String address;
	
	//……
	public User() {
		
	}
	
	//……
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	//……
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", birthday=" + birthday + ", sex=" + sex
				+ ", address=" + address + "]";
	}
	
	
	
	
}



/*
mysql> desc user;
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | int(11)      | NO   | PRI | NULL    | auto_increment |
| username | varchar(32)  | NO   |     | NULL    |                |
| pwd      | varchar(20)  | NO   |     | 123     |                |
| birthday | date         | YES  |     | NULL    |                |
| sex      | char(1)      | YES  |     | NULL    |                |
| address  | varchar(256) | YES  |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
6 rows in set 
 * mysql> select database();
+------------+
| database() |
+------------+
| mybatis    |
+------------+
1 row in set * 
 * */
 