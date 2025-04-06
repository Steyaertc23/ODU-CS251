
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bicycle bike = new Bicycle();
		
		BicycleListing listingOne = new BicycleListing(bike, BicycleListing.Condition.NEW, 200);
		System.out.println("Adjusted price for " + BicycleListing.Condition.NEW + ": " + listingOne.getAdjustedPrice());
		
		BicycleListing listingTwo = new BicycleListing(bike, BicycleListing.Condition.USED, 200);
		System.out.println("Adjusted price for " + BicycleListing.Condition.USED + ": " + listingTwo.getAdjustedPrice());
		
		BicycleListing listingThree = new BicycleListing(bike, BicycleListing.Condition.DAMAGED, 200);
		System.out.println("Adjusted price for " + BicycleListing.Condition.DAMAGED + ": " + listingThree.getAdjustedPrice());
		
	}

}
