package myboard;

public class Account {

	private String userId;
	private String name;
	private String email;
	private String pass;
	
	public Account() {
		
	}
	
	public Account(String email, String pass, String name) {
		this.name = name;
		this.email = email;
		this.pass = pass;
	}
	
	public Account(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
