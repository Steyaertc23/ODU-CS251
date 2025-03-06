
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bicycle bike = new Bicycle(10, 5, 4);
		new LousyBikeMechanic(bike).repairBike(bike);
	}

}
