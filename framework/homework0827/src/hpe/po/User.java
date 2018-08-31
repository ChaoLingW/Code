package hpe.po;

/**
 * TODO mybatis_home.user表对应的实体类
 * 
 * @author chaoling 2018年8月27日
 */
public class User {

	private int id; // ID
	private String username; // 用户名
	private String password; // 密码
	private String realName; // 真实姓名
	private String gender; // 性别

	/**
	 * 无参构造器
	 */
	public User() {
		super();
	}

	/**
	 * 有参构造器 用于设置username与password
	 * 
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * 有参构造器 用于设置除id之外的全部属性
	 * 
	 * @param username
	 * @param password
	 * @param realName
	 * @param gender
	 */
	public User(String username, String password, String realName, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.gender = gender;
	}

	/*
	 * get()/set()
	 */

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 重写toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", realName=" + realName
				+ ", gender=" + gender + "]";
	}

}
