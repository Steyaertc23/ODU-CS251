import java.util.ArrayList;

public class RepairDepot extends Depot{
	private int[] depotLocation = new int[2];
	public ArrayList<RepairDrone> repairDrones = new ArrayList<>();
	
	
	public RepairDepot(int locationX, int locationY) {
		super(locationX, locationY);
	}
	
	class RepairDrone extends Entity{
		private int[] location = new int[2];
		private int droneID;
		
		RepairDrone(int id, int[] deployLocation) {
			super(deployLocation.clone());
			droneID = id;
			
		}
		
		public void moveX(int dx) {
			location[0] += dx;
		}
		
		public void moveY(int dy) {
			location[1] += dy;
		}
		
		public void repair(Drone d) {
			 d.setTopSpeed( d.getTopSpeed() * 2);
		}
		
		public int[] getLocation() {
			return location.clone();
		}
		
	}
	
	public void repair(Drone d) {
		d.setTopSpeed( d.getTopSpeed() * 3);
	}
	
	public void DeployDrone() {
		RepairDrone d = new RepairDrone(droneID, depotLocation.clone());
		repairDrones.add(d);
		increaseID();
	}
}
