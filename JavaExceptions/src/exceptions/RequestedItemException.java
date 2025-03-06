package exceptions;

public class RequestedItemException extends Exception {
	private String name;
	
	public RequestedItemException(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
