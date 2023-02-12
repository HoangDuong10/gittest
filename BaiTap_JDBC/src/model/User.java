package model;

public class User {
	String username;
	String password;
	String hoten;
	public User() {
		super();
	}
	public User(String username, String password, String hoten) {
		super();
		this.username = username;
		this.password = password;
		this.hoten = hoten;
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
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", hoten=" + hoten + "]";
	}
	
}
