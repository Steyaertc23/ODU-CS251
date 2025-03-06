package mainPackage;

import bicyclePackage.Bicycle;

public class Driver {

	public static void main(String[] args) {
		Bicycle bike = new Bicycle(0,0,3);
		
		System.out.println("Speed" + bike.getSpeed());
//		bike.speedUp(2);
		
		SpeedBicycle speedBike = new SpeedBicycle(3,3,4);
		speedBike.speedUp(4);
	}

}
