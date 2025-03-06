
public class BicycleFactory {
	private static int serialNo = 0;
	
	public static int getNextSerialNo() {
		return serialNo;
	}
	
	public Bicycle createBicycle() {
		return new Bicycle(serialNo++);
	}
}
