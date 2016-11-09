package vo;

public class UserVo {
	private String user_name;
	private String password;
	
	public UserVo(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getUser_name() {
		return this.user_name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
}
