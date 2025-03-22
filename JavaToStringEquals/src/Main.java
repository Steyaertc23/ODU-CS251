
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BicycleListing listing = new BicycleListing(new Bicycle(9), BicycleListing.Condition.NEW, 200.90);
		
		System.out.println(listing.toString());
		
		BicycleListing listing2 = new BicycleListing(new Bicycle(9), BicycleListing.Condition.NEW, 200.90);
		
		BicycleListing listing3 = new BicycleListing(new Bicycle(100), BicycleListing.Condition.USED, 300);
		
		System.out.println("listing.equals(listing2): " + listing.equals(listing2));
		System.out.println("listing.equals(listing3): " + listing.equals(listing3));
		
	}

}
