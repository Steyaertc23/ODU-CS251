
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BicycleFactory factoryOne = new BicycleFactory();
		
		System.out.println("Next Serial No: " + BicycleFactory.getNextSerialNo());
		Bicycle factoryOneBikeOne = factoryOne.createBicycle();
		System.out.println("Next Serial No: " + BicycleFactory.getNextSerialNo());
		Bicycle factoryOneBikeTwo = factoryOne.createBicycle();
		
		System.out.println("Factory 1 bike 1 serial number: " + factoryOneBikeOne.serialNo);
		System.out.println("Factory 1 bike 2 serial number: " + factoryOneBikeTwo.serialNo);
		
		BicycleFactory factoryTwo = new BicycleFactory();
		
		System.out.println("Next Serial No: " + BicycleFactory.getNextSerialNo());
		Bicycle factoryTwoBikeOne = factoryTwo.createBicycle();
		System.out.println("Next Serial No: " + BicycleFactory.getNextSerialNo());
		Bicycle factoryTwoBikeTwo = factoryTwo.createBicycle();
		
		System.out.println("Factory 2 bike 1 serial number: " + factoryTwoBikeOne.serialNo);
		System.out.println("Factory 2 bike 2 serial number: " + factoryTwoBikeTwo.serialNo);

	}

}
