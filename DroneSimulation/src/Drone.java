
public class Drone extends Entity{
	private int id, topSpeed, signalRange, payloadLimit;
	private String message;
	private int payload;
	
	public Drone() {
		super();
		id = -1;
	}
	
	public Drone(int idNum, int[] posXY, int maxSpeed, 
			     int maxSignalRange, int maxPayload, String msg) {
		super(posXY);
		id = idNum;
		topSpeed = maxSpeed;
		signalRange = maxSignalRange;
		payloadLimit = maxPayload;
		message = msg;
		payload = 0;
	
	}
	
	public boolean loadDrone(int payloadWeight) {
		if (payload + payloadWeight > payloadLimit)
			return false;
		payload += payloadWeight;
		return true;
	}
	
	public String getCurrentPayload() {
		return payload + "cg";
	}
	
	public void moveX(int shamt) {
		location[0] += shamt;
	}
	
	public void moveY(int shamt) {
		location[1] += shamt;
	}
	
	public String getLocation() {
		String locationString = "X: " + location[0] + ", Y: " + location[1];
		
		return locationString;
	}
	public int[] getLocationXY() {
		return location;
	}
	public int getID() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getTopSpeed() {
		return topSpeed;
	}
	
	public int getSignalRange() {
		return signalRange;
	}
	
	public int getPayloadLimit() {
		return payloadLimit;
	}
	
	public int getPayload() {
		return payload;
	}
	
	public void setMessage(String msg) {
		message = msg;
	}
	
	public void setTopSpeed(int speed) {
		topSpeed = speed;
	}
	
	public void setSignalRange(int signal) {
		signalRange = signal;
	}
	
	public void setPayloadLimit(int limit) {
		payloadLimit = limit;
	}
	
	public void setPayload(int load) {
		payload = load;
	}
}
