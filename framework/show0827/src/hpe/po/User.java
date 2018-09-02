package hpe.po;

/**
 * 
 * @author chaoling
 *
 */
public class User {

	private int id;				//�û�ID
	private String username;	//�û���
	private String pwd;			//����
	private String birhday;
	private String sex;
	private String address;
	
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
	public String getBirhday() {
		return birhday;
	}
	public void setBirhday(String birhday) {
		this.birhday = birhday;
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
	
	//�вι�����
	public User(int id, String username, String pwd, String birhday, String sex, String address) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.birhday = birhday;
		this.sex = sex;
		this.address = address;
	}
	
	//�޲ι�����
	public User() {	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", birhday=" + birhday + ", sex=" + sex
				+ ", address=" + address + "]";
	}
	
	
	
}