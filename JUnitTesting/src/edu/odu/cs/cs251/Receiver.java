package edu.odu.cs.cs251;

import java.util.PriorityQueue;

public class Receiver {
	
	private String id;
	private int x, y;
	private PriorityQueue<Message> messageQueue;
	
	public Receiver(String id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.messageQueue = new PriorityQueue<>();
	}
	
	/**
	 * Store message in message queue.
	 * @param message
	 * @return Where the message was added to the message queue
	 */
	public boolean receive(Message message) {
		
		return messageQueue.add(message);
	}
	
	/**
	 * Get the next message in the message queue
	 * @return Next message in the queue, or null if queue is empty
	 */
	public String nextMessage() {
		if (!hasMessage())
			return null;
		else {
			return messageQueue.poll().getMessage();
		}
	}
	
	/**
	 * Whether the receiver has any messages
	 * @return Whether the message queue is empty
	 */
	public boolean hasMessage() {
		return !messageQueue.isEmpty();
	}
	
	@Override
	public String toString() {
		return String.format("%s: has message? %b", id, hasMessage());
	}
	
	public String getID() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
