
public class Depot extends Entity {
	protected static int droneID;
	
	public Depot(int[] location) {
		super(location);
	}
	
	public Depot(int[] depotXY, int startingDroneID) {
		super(depotXY);
		droneID = startingDroneID;
	}
	
	public Depot(int x, int y) {
		super(x, y);
	}
	
	protected void increaseID() {
		droneID++;
	}
}
