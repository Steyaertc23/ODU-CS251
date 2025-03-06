package labThirteen;

import interfaces.Interplanetary;
import locations.Planet;

public class TieFighter implements Interplanetary {
	
	
	public void jump(Planet p) {
		System.out.println("Jumping to " + p.getPlanetName());
		
	}
	
	public void move() {
		System.out.println("Moving");
	}
}
