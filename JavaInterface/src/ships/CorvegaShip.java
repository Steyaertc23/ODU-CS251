package ships;
import interfaces.Lander;

public class CorvegaShip implements Lander {
	public CorvegaShip(){
	}
	
	public void move() {
		System.out.println("Moving");
	}
	
	public boolean land(){
		System.out.println("CorvegaShip lands");
		return true;
	}
}
