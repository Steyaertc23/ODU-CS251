

public class Driver {

	public static void main(String[] args) {
		
		
		Bicycle bikeOne = new Bicycle ();
		
		Bicycle bikeTwo = new Bicycle (5,4,8);
		
		System.out.println("Initial States\n\n  Bicycle 1:");
		
		System.out.println("\tCadence: \t" + bikeOne.cadence + 
						   "\n\tGear: \t\t" + bikeOne.gear + 
						   "\n\tSpeed: \t\t" + bikeOne.speed
				);
		
		System.out.println("\n  Bicycle 2:");
		
		System.out.println("\tCadence: \t" + bikeTwo.cadence + 
						   "\n\tGear: \t\t" + bikeTwo.gear + 
						   "\n\tSpeed: \t\t" + bikeTwo.speed
				);
		
		
		
		System.out.println("\n\nCalling Methods for Bicycle 2");
		
		bikeTwo.setCadence(8);
		System.out.println("  setCadence()\n\tNew Cadence: \t" + bikeTwo.cadence);
		bikeTwo.setGear(5);
		System.out.println("  setGear()\n\tNew Gear: \t" + bikeTwo.gear);
		bikeTwo.gearUp();
		System.out.println("  gearUp()\n\tNew Gear: \t" + bikeTwo.gear);
		bikeTwo.gearDown();
		System.out.println("  gearDown()\n\tNew Gear: \t" + bikeTwo.gear);
		bikeTwo.speedUp(3);
		System.out.println("  speedUp()\n\tNew Speed: \t" + bikeTwo.speed);
		bikeTwo.applyBreak(6);
		System.out.println("  applyBreak()\n\tNew Speed: \t" + bikeTwo.speed);
		
		
	}

}
