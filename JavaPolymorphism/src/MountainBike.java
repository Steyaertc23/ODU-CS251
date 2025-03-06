
public class MountainBike extends Bicycle {
	double suspension;
	
	public MountainBike() {
		super();
		suspension = 0.0;
	}
	
	public MountainBike(int cadence, int speed, int gear, double suspension) {
		super(cadence, speed, gear);
		this.suspension = suspension;
	}
	
	public double getSuspension() {
		return suspension;
	}
	
	public void setSuspension(double suspension) {
		this.suspension = suspension;
	}
	
	@Override
	public void printFields() {
		super.printFields();
		System.out.println("Suspension: " + this.suspension);
		
	}
}
