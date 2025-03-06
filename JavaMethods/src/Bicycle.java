
public class Bicycle {
	
	// Three Fields
	public int cadence, gear, speed;
	
	
	// Constructor
	public Bicycle() {
		cadence = 0;
		gear = 0;
		speed = 0;
	}
	
	public Bicycle(int startCadence, int startGear, int startSpeed) {
		cadence = startCadence;
		gear = startGear;
		speed = startSpeed;
	}
	
	// Pre-Determined Methods
	public void setCadence(int newValue) {
		cadence = newValue;
	}
	
	public void setGear(int newValue) {
		gear = newValue;
	}
	
	public void applyBreak(int decrement) {
		speed -= decrement;
	}
	
	public void speedUp(int increment) {
		speed += increment;
	}
	
	// Task 1
	
	// gearUp increments the gear:
	// Increases gear number by 1 by pre-incrementing the gear.
	// Returns nothing.
	public void gearUp() {
		++gear;
	}
	
	// gearUp increments the gear:
	// Decreases gear number by 1 by pre-decrementing the gear.
	// Returns nothing.
	public void gearDown() {
		--gear;
	}
	
	
}
