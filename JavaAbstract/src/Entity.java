
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
	
	protected void decreaseHealth(double amount) {
		if (currentHealth - amount < 0) {
			currentHealth = 0;
		}
		
		else {
			currentHealth -= amount;
		}
	}
	
	protected void increaseHealth(double amount) {
		if (currentHealth + amount > maxHealth) {
			currentHealth = maxHealth;
		}
		
		else {
			currentHealth += amount;
		}
	}

	protected double getCurrentHealth() {
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
	
	protected int getEntityID() {
		return this.entityID;
	}
	
	protected void reset() {
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
