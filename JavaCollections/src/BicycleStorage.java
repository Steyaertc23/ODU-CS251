import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class BicycleStorage {
	
	private ArrayList <Bicycle> bicycles;
	
	
	
	public BicycleStorage() {
		
		bicycles = new ArrayList<Bicycle>();
		
	}
	
	
	public void addBicycle(Bicycle bike) {
		bicycles.add(bike);
	}
	
	public void removeBicycle(int bicycleLocation) throws IndexOutOfBoundsException, ConcurrentModificationException {
		bicycles.remove(bicycleLocation);
	}
	
	public Bicycle getBicycle(int bicycleLocation) throws IndexOutOfBoundsException, ConcurrentModificationException{
		return bicycles.get(bicycleLocation);
	}
	
	
}
