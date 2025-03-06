
public class LousyBikeMechanic {
	
	public Bicycle bike;
	
	public LousyBikeMechanic(Bicycle bicycle) {
		bike = bicycle;
	}
	
	
	public void repairBike(Bicycle brokenBike) {
		System.out.println(bike == brokenBike);
		brokenBike.gear = -100;
		brokenBike = new Bicycle(100,100,100);
		System.out.println(brokenBike == bike);
	}
	
	public void printBikes(Bicycle...bike) {
		if (bike.length == 0) {
			System.out.println("Nothing to check");
		}
		else {
			for (int i=0; i < bike.length; i++)
				System.out.println(i + " " + bike[i].gear);
		}
		
	}
	
}
