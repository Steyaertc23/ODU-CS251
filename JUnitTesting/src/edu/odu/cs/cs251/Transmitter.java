package edu.odu.cs.cs251;


import edu.odu.cs.cs251.Message.Priority;

public class Transmitter {
	
	private String id; 
	private int x, y;
	private double effectiveRange;
	
	public Transmitter(String id, int x, int y, double effectiveRange) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.effectiveRange = effectiveRange;
	}

	/**
	 * Transmit an urgent message to a receiver.
	 * @param receiver
	 * @param message
	 * @return
	 */
	public boolean transmitUrgent(Receiver receiver, String message) {
		return transmit(receiver, message, Priority.URGENT);
	}
	
	/**
	 * Transmit an normal message to a receiver
	 * @param receiver
	 * @param message
	 * @return
	 */
	public boolean transmitNormal(Receiver receiver, String message) {
		return transmit(receiver, message, Priority.NORMAL);
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
	
	public double getEffectiveRange() {
		return effectiveRange;
	}
	
	private double distanceTo(int x, int y) {
		return Math.sqrt( Math.pow((x - this.x), 2) + (Math.pow((y-this.y),2)) );
	}
	
	/**
	 * Transmit message to receiver
	 * 
	 * @param receiver
	 * @param message
	 * @return Whether the receiver received the message
	 */
	private boolean transmit(Receiver receiver, String message, Priority p) {
		
		if (distanceTo(receiver.getX(), receiver.getY()) < effectiveRange) {
			
			return receiver.receive(new Message(p, message));
		}
	
		return false;
	}
}
