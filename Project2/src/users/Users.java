package users;

public class Users {

	//FOLLOW INSTRUCTIONS, CREATE VARIABLES, SETTERS AND GETTERS, AND CONSTRUCTOR
	//NEED TO DO
	protected String username;
	protected String password;

	public Users(String username, String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	protected String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
