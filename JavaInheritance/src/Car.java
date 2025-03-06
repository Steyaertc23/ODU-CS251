
public class Car {

	public int speed;
	public int gear;
	

	public void changeGear(int gear) {
		// TODO Auto-generated method stub
		this.gear = gear;
	}

	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		speed += increment;
	}


	public void applyBreaks(int decrement) {
		// TODO Auto-generated method stub
		speed -= decrement;
	}
	
	public boolean checkStatus(int limit) {
		return (speed < limit);
	}
}
