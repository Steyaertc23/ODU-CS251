package edu.odu.cs.cs251.dungeoncrawler.entities;


public abstract class Entity implements Comparable<Entity> {

	protected double maxHealth;
	protected double currentHealth;
	protected double speed;
	protected int entityID;
	
	protected Entity(double health, int entityID, double speed) {
		this.maxHealth = health;
		this.currentHealth = health;
		this.entityID = entityID;
		this.speed = speed;
	}
	
	public void decreaseHealth(double amount) {
		if (currentHealth - amount < 0) {
			currentHealth = 0;
		}
		
		else {
			currentHealth -= amount;
		}
	}
	
	public void increaseHealth(double amount) {
		if (currentHealth + amount > maxHealth) {
			currentHealth = maxHealth;
		}
		
		else {
			currentHealth += maxHealth;
		}
	}

	public double getCurrentHealth() {
		return this.currentHealth;
	}
	
	protected double getMaxHealth() {
		return this.maxHealth;
	}

	protected double getSpeed(){
		return this.speed;
	}

	protected void setSpeed(double speed){
		this.speed = speed;
	}
	
	public int getEntityID() {
		return this.entityID;
	}
	
	public void reset() {
		currentHealth = maxHealth;
	}

	@Override
	public int compareTo(Entity other) {
		if (other.speed == this.speed)
			return 0;
		else if (this.speed < other.speed)
			return -1;
		else
			return 1;
	}
}
