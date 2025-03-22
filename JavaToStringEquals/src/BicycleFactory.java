
public class BicycleFactory {

	private int serialNo;
	private static int nextSerialNo = 0;
	
	public BicycleFactory() {
		serialNo = 0;
	}
	
	public Bicycle createBicycle() {
		return new Bicycle(nextSerialNo++);
	}
	
	public static int getNextSerialNo() {
		return nextSerialNo;
	}
}
