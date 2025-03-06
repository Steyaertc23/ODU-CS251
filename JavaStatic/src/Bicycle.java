
public class Bicycle {
	public int cadence;
	public int gear;
	public int speed;
	public int serialNo;
	
	class Tyre {
		double pressure;
		double size;
		
		Tyre() {
			pressure = 1.0;
			size = 1.0;
		}
		
		void increasePressure(double increment) {
			pressure += increment;
		}
		
		void decreasePressure(double decrement) {
			pressure -= decrement;
		}
	}
	
	public Bicycle() {
		cadence = 0;
		speed = 0;
		gear = 0;
		serialNo = 0;
	}
	
	public Bicycle(int serialNo) {
		this.serialNo = serialNo;
		cadence = 0;
		speed = 0;
		gear = 0;
	}
	
	public Bicycle(int startCadence, int startSpeed, int startGear, int serialNo) {
		cadence = startCadence;
		speed = startSpeed;
		gear = startGear;
		this.serialNo = serialNo;
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
