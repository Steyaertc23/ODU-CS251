package labThirteen;

import interfaces.Interstellar;
import locations.Planet;
import locations.SolarSystem;


// Executor is a Star Destroyer from Star Wars
public class Executor implements Interstellar {
	
	public Executor() {
		
	}
	
	public void move() {
		System.out.println("Moving");
	}
	
	public void jump(SolarSystem system) {
		System.out.println("Jumping to the " + system.getSystemName() + " system");
	}
	
	public void jump(Planet p) {
		System.out.println("Jumping to " + p.getPlanetName());
		
	}
	
}
