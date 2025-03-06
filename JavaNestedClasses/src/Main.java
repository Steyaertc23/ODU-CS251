
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bicycle.Tyre tyre = new Bicycle.Tyre();
		
		System.out.println("Initial pressure: " + tyre.pressure);
		tyre.increasePressure(1.5);
		System.out.println("Increased pressure: " + tyre.pressure);
		tyre.decreasePressure(2);
		System.out.println("Decreased pressure: " + tyre.pressure);
	}

}
