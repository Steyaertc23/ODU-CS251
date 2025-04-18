package edu.odu.cs.cs251;

public class Message implements Comparable<Message>{

	public enum Priority {
		URGENT, NORMAL;
	}
	
	private Priority priority;
	private String message;
	
	public Message(Priority priority, String message) {
		this.priority = priority;
		this.message = message;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public int compareTo(Message m) {
		return (this.priority.compareTo(m.priority));
	}
}
