package edu.odu.cs.cs251;

public class Drone {
	private int id;
	private int destination;
	
	public Drone(int id, int destination) {
		this.id = id;
		this.destination = destination;
	}
	
	public int getID() {
		return id;
	}
	
	public int getDestination() {
		return destination;
	}
}
