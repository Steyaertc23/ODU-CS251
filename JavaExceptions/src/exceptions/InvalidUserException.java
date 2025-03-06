package exceptions;

public class InvalidUserException extends Exception {
	private String userID;
	
	public InvalidUserException(String userID) {
		this.userID = userID;
		
	}
	
	public String getUserID() {
		return userID;
	}
}
