
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car[] cars = new Car[3];
		
		cars[0] = new Car();
		cars[1] = new Sedan(120, 60, 5, Sedan.Drivetrain_2WD.RWD);
		cars[2] = new SUV(100, 50, 4, true);
		
		for(Car c : cars) {
			c.printInformation();
		}
	}

}
