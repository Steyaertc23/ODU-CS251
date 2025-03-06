package mainPackage;

import bicyclePackage.Bicycle;

public class SpeedBicycle extends Bicycle {
	public SpeedBicycle(int cadence, int speed, int gear) {
		super(cadence, speed, gear);
	}
	
	public void speedUp(int increment) {
		super.speedUp(increment);
	}
}
