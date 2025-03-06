public class Bicycle {
	
	public int cadence;
	public int gear;
	public int speed;
	
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
	

	public void changeGear(int gear) {
		this.gear = gear;
	}
	

	public void speedUp(int increment) {
		speed += increment;
	}
	
	public void applyBreaks(int decrement) {
		speed -= decrement;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setGear(int gear) {
		this.gear = gear;
	}
	
	public int getGear() {
		return gear;
	}
	
	public void printType() {
		System.out.println("Bicycle");
	}
	
	public void printFields() {
		System.out.println("Cadence: " + cadence);
		System.out.println("Speed: " + speed);
		System.out.println("Gear: " + gear);
	}
}