
public class Sedan extends Car {

	enum Drivetrain_2WD{
		FWD, RWD;
	}
	
	public Drivetrain_2WD type;
	
	public Sedan() {
		super();
		type = Drivetrain_2WD.FWD;
	}
	
	public Sedan(int topSpeed, int MPG, int acceleration, Drivetrain_2WD type) {
		super(topSpeed, MPG, acceleration);
		this.type = type;
	}
	
	@Override
	public void printInformation() {
		super.printInformation();
		System.out.println("Type: " + type);
	}

}
