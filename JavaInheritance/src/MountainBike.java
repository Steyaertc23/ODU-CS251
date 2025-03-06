
public class MountainBike extends Bicycle {
	double suspension;
	
	public MountainBike() {
		speed = 0;
		gear = 0;
		suspension = 0;
	}
	
	public MountainBike(int speed, int gear, double suspension) {
		this.speed = speed;
		this.gear = gear;
		this.suspension = suspension;
	}
	
	public double getSuspension() {
		return suspension;
	}
	
	public void setSuspension(double suspension) {
		this.suspension = suspension;
	}
	
	@Override
	public void printType() {
		System.out.println("MountainBike");
	}
}
