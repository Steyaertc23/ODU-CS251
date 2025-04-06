import java.util.ArrayList;

public class DroneController extends Entity{
	
	private int maxNumberDrones;
	private int maxSignalRange;
	private int numberActiveDrones = 0;
	private ArrayList<Drone> systemDrones = new ArrayList<>();
	private ArrayList<Drone> systemDronesInRange = new ArrayList<>();
	
	public DroneController(int maxNumDrones, int x, int y, int maxSignal) {
		super(x, y);
		maxNumberDrones = maxNumDrones;
		maxSignalRange = maxSignal;
	}

	private double calculateDroneDistance(int[] droneLocation) {
		double distance = 0;
		int x = 0;
		int y = 0;
		
		x = droneLocation[0] - location[0];
		y = droneLocation[1] - location[1];
		
		distance = (double) Math.pow(x, 2) + (double) Math.pow(y, 2);
		distance = (double) Math.pow(distance, 1/2);
		
		
		return distance;
	}
	
	private void addDroneInRange(Drone drone) {
//		Drone[] temp = new Drone[systemDronesInRange.length + 1];
//        System.arraycopy(systemDronesInRange, 0, temp, 0, systemDronesInRange.length);
//		temp[systemDronesInRange.length] = drone;
//		systemDronesInRange = temp.clone();
		
		systemDronesInRange.add(drone);
	}
	private void resetDronesInRange() {
//		Drone[] temp = new Drone[1];
//		systemDronesInRange = temp;
		systemDronesInRange.clear();
	}
	
	
	public void scanRange() {
		resetDronesInRange();
		for (Drone drone : systemDrones){
			double distance = calculateDroneDistance(drone.getLocationXY());
			if (distance < maxSignalRange) {
				addDroneInRange(drone);	
			}
		}
	}
	
	private void addSystemDrone(Drone drone) {
//		Drone[] temp = new Drone[systemDrones.length + 1];
//        System.arraycopy(systemDrones, 0, temp, 0, systemDrones.length);
//		temp[systemDrones.length] = drone;
//		systemDrones = temp.clone();
		
		systemDrones.add(drone);
	}
	
	public boolean signalDrone(String msg, int id) {
		for (Drone drone : systemDrones)
			if(drone.getID() == id) {
				drone.setMessage(msg);
				return true;
			}
		return false;
	}
	
	public String signalDeploy(DroneDepot depot, int maxSpeed, int maxSignal, int maxPayload, String msg) {
		if (systemDrones.size() == maxNumberDrones) {
			return "Unable to deploy new Drone.";
		}
		int newDroneID = depot.createDrone(maxSpeed, maxSignal, maxPayload, msg);
//		System.out.println(newDroneID);
		Drone drone = depot.getDrone(newDroneID);
		if (drone == null)
			return "Error";
		addDroneInRange(drone);
		addSystemDrone(drone);
		
		numberActiveDrones++;
		return "Created Drone";
	}
	
	public ArrayList<Drone> getActiveDrones(){
		return systemDrones;
	}
	
	public ArrayList<Drone> getDronesInRange(){
		return systemDronesInRange;
	}
	
	private boolean setDroneIdle(int droneId) throws Exception {
		for (Drone d : systemDrones) {
			if (d.getID() == droneId) {
				return d.setIdle();
			}
		}
		throw new Exception("No drone with ID " + droneId);
	}
	
	private boolean setDroneReserved(int steps, int droneId) throws Exception {
		for (Drone d : systemDrones) {
			if (d.getID() == droneId) {
				return d.setReserved(steps);
			}
		}
		throw new Exception("No drone with ID " + droneId);
	}
	
	private boolean setDroneActive(int droneId) throws Exception {
		for (Drone d : systemDrones) {
			if (d.getID() == droneId) {
				return d.setActive();
			}
		}
		throw new Exception("No drone with ID " + droneId);
	}
	
	public boolean droneRunner(int droneId, Drone.Status s, int steps) {
		boolean completed = false;
		Drone drone = new Drone();
		for (Drone d : systemDrones) {
			if (d.getID() == droneId) {
				drone = d;
			}
		}
		if (drone.getStatus() == Drone.Status.IDLE && s != Drone.Status.RESERVE) {
			try {
				completed = setDroneActive(droneId);
				drone.decrementSteps();
				return completed;
			} catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		switch(s) {
		case Drone.Status.ACTIVE:
			try {
				completed = setDroneActive(droneId);
				if (!completed) {
					for (Drone d : systemDrones) {
						if (d.getID() == droneId) {
							d.decrementSteps();
						}
					}
				}
			} catch(Exception e) {
				completed = false;
				e.printStackTrace();
			}
			break;
		case Drone.Status.IDLE:
			try {
				completed = setDroneIdle(droneId);
			} catch(Exception e) {
				completed = false;
				e.printStackTrace();
			}
			break;
		case Drone.Status.RESERVE:
			try {
				completed = setDroneReserved(steps, droneId);
			} catch(Exception e) {
				completed = false;
				e.printStackTrace();
			}
			break;
		default:
			return false;
		}
		
		return completed;
	}

}
