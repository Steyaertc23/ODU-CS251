
public class Bicycle {
	
	public int cadence;
	public int gear;
	public int speed;
	public int serialNo;
	
	public Bicycle() {
		cadence = 0;
		speed = 0;
		gear = 0;
	}
	
	public Bicycle(int serialNo) {
		this.serialNo = serialNo;
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
	
	public void changeGear(int newValue) {
		gear = newValue;
	}
	
	public void applyBreaks(int decrement) {
		speed -= decrement;
	}
	
	public void speedUp(int increment) {
		speed += increment;
	}
}