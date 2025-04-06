import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		
		DroneController controller = new DroneController(5, 0, 0, 10);
		DroneDepot depot1 = new DroneDepot(5,5);
		controller.signalDeploy(depot1, 30, 50, 20, null);
		
		Random gen = new Random();
		int direction;
		for(int i = 0; i < 20; i++) {
			for (int j = 0; j < controller.getActiveDrones().size(); j++) {
				direction = gen.nextInt(2);
				if (controller.getActiveDrones().get(j).getStatus() == Drone.Status.IDLE)
					continue;
				if (direction == 0) {
					controller.getActiveDrones().get(j).moveX(gen.nextInt(-2,2));
				}
				else {
					controller.getActiveDrones().get(j).moveY(gen.nextInt(-2,2));
				}
			}
			controller.scanRange();
			
			
			int number = gen.nextInt(5);
			
			int droneID = gen.nextInt(controller.getActiveDrones().size());
			Drone drone = new Drone();
			for (Drone d : controller.getActiveDrones()) {
				if (d.getID() == droneID)
					drone = d;
			}
			
			for (Drone d : controller.getActiveDrones())
				controller.droneRunner(d.getID(), Drone.Status.ACTIVE, 0);
			
			
			if(number == 0) {
				controller.signalDeploy(depot1, 20, 30, 20, null);
			}
			else  if (number == 1){
				controller.signalDrone("MSG", droneID);
			}
			else if (number == 2) {
				controller.droneRunner(droneID, Drone.Status.ACTIVE, 0);
			}
			else if (number == 3) {
				controller.droneRunner(droneID, Drone.Status.IDLE, 0);
			}
			else {
				if (drone.getStatus() == Drone.Status.IDLE) {
					for (Drone d : controller.getActiveDrones()) {
						if (d.getID() == droneID)
							controller.droneRunner(droneID, Drone.Status.IDLE, 0);
					}
					controller.droneRunner(droneID, Drone.Status.RESERVE, gen.nextInt(10));
				}
			}
			
			
			System.out.println("Step " + i);
			System.out.println("DroneID\tposX\tposY\tStatus\tMessage");
			for (Drone d : controller.getActiveDrones()) {
				if (d == null)
					break;
				System.out.println(d.getID() + "\t" + d.getLocation() + "\t" + d.getStatus() + "\t" + d.getMessage());
			}
		}
		
		
		/// In case there are no active to idle to reserve to (attempted) active:
		System.out.println("\n\nExtra Step 0:");
		controller.droneRunner(0, Drone.Status.ACTIVE, 0);
		System.out.println(controller.getActiveDrones().getFirst().getID() + "\t" + controller.getActiveDrones().getFirst().getLocation() 
				+ "\t" + controller.getActiveDrones().getFirst().getStatus() + "\t" + controller.getActiveDrones().getFirst().getMessage());
		
		System.out.println("DroneID\tposX\tposY\tStatus\tMessage");
		System.out.println("Extra Step 1:");
		System.out.println("DroneID\tposX\tposY\tStatus\tMessage");
		controller.droneRunner(0, Drone.Status.IDLE, 0);
		System.out.println(controller.getActiveDrones().getFirst().getID() + "\t" + controller.getActiveDrones().getFirst().getLocation() 
							+ "\t" + controller.getActiveDrones().getFirst().getStatus() + "\t" + controller.getActiveDrones().getFirst().getMessage());
		
		System.out.println("Extra Step 2:");
		System.out.println("DroneID\tposX\tposY\tStatus\tMessage");
		controller.droneRunner(0, Drone.Status.RESERVE, 20);
		System.out.println(controller.getActiveDrones().getFirst().getID() + "\t" + controller.getActiveDrones().getFirst().getLocation() 
				+ "\t" + controller.getActiveDrones().getFirst().getStatus() + "\t" + controller.getActiveDrones().getFirst().getMessage());
		
		System.out.println("Extra Step 3:");
		System.out.println("DroneID\tposX\tposY\tStatus\tMessage");
		controller.droneRunner(0, Drone.Status.ACTIVE, 0);
		System.out.println(controller.getActiveDrones().getFirst().getID() + "\t" + controller.getActiveDrones().getFirst().getLocation() 
				+ "\t" + controller.getActiveDrones().getFirst().getStatus() + "\t" + controller.getActiveDrones().getFirst().getMessage());
		
		
		
	}

}
