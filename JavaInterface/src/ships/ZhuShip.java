package ships;
import interfaces.InAtmosphereShip;

public class ZhuShip implements InAtmosphereShip {
	public ZhuShip() {
		
	}
	
	public void move() {
		System.out.println("Moving");
	}
	
	public boolean takeOff(){
		System.out.println("ZhuShip takes off");
		return true;
	}
}
