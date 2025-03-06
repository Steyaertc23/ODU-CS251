

public class SUV extends Car {
	public boolean active4WD;
	
	public SUV() {
		super();
		active4WD = false;
	}
	
	public SUV(int topSpeed, int MPG, int acceleration, boolean active4WD) {
		super(topSpeed, MPG, acceleration);
		this.active4WD = active4WD;
	}
	
	@Override
	public void printInformation(){
		super.printInformation();
		System.out.println("Active 4WD: " + active4WD);
	}

}
