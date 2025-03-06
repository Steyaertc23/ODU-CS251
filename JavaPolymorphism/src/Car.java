
public class Car {

	public int topSpeed;
	public int MPG;
	public int acceleration;
	
	public Car() {
		topSpeed = 0;
		MPG = 0;
		acceleration = 0;
	}
	
	public Car(int topSpeed, int MPG, int acceleration) {
		this.topSpeed = topSpeed;
		this.MPG = MPG;
		this.acceleration = acceleration;
	}
	
	public void printInformation() {
		System.out.println("Top Speed: " + topSpeed + "\nMPG: " + MPG + "\nAcceleration: " + acceleration);
	}
}
