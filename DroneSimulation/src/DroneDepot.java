//import java.util.LinkedList;
import java.util.HashMap;

public class DroneDepot extends Depot {
	private HashMap<Integer, Drone> drones = new HashMap<Integer, Drone>();
	
	public DroneDepot(int[] depotXY) {
		super(depotXY);
	}
	
	public DroneDepot(int[] depotXY, int startingDroneID) {
		super(depotXY, startingDroneID);
	}
	public DroneDepot(int x, int y) {
		super(x, y);
	}
	
	public int createDrone(int maxSpeed, int maxSignal, int maxPayload, String msg) {
		Drone drone = new Drone(droneID, location.clone(), maxSpeed, maxSignal, maxPayload, msg);
		drones.put(droneID, drone);
		droneID++;
		return droneID-1;
		
	}
	
	public static int getNextDroneID() {
		return droneID;
	}

	
	public Drone getDrone(int droneId) {
			return drones.get(droneId);
	}
	
	public boolean moveDroneX(int droneId, int shamt) {
		Drone drone = drones.get(droneId);
		drone.moveX(shamt);
		return true;
	}
	
	
	
	public boolean moveDroneY(int droneId, int shamt) {
		Drone drone = drones.get(droneId);
		if (drone == null) {
			return false;
		}
		drone.moveY(shamt);
		return true;
	}
	
	public boolean loadDrone(int droneId, int payload) {
		Drone drone = drones.get(droneId);
		if (drone == null)
			return false;
		
		boolean canLoad = drone.loadDrone(payload);
		return canLoad;
	}
	
	public String getDroneLocation(int droneId) {
		Drone drone = drones.get(droneId);
		if (drone == null) {
			return "Drone does not exist";
		}
		return drone.getLocation();
	}
	
	public String getCurrentPayload(int droneId) {
		Drone drone = drones.get(droneId);
		if (drone == null) {
			return "Drone does not exist";
		}
		return drone.getCurrentPayload();
	}
	
	
}