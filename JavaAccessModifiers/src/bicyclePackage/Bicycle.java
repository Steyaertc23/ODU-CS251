package bicyclePackage;

public class Bicycle {
	
	private int cadence;
	private int gear;
	private int speed;
	
	public Bicycle() {
		cadence = 0;
		speed = 0;
		gear = 0;
	}
	
	public Bicycle(int startCadence, int startSpeed, int startGear) {
		cadence = startCadence;
		speed = startSpeed;
		gear = startGear;
	}
	
	public void setCadence(int newValue) {
		cadence = newValue;
	}
	
	public void setGear(int newValue) {
		gear = newValue;
	}
	
	public void applyBreak(int decrement) {
		speed -= decrement;
	}
	
	protected void speedUp(int increment) {
		speed += increment;
	}
	
	public void gearUp() {
		gear++;
	}
	
	public void gearDown() {
		gear--;
	}
	
	public int getCadence() {
		return cadence;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getGear() {
		return gear;
	}
	
}
