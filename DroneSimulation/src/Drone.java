
public class Drone extends Entity{
	private int id, topSpeed, signalRange, payloadLimit;
	private String message;
	private int payload, timeSteps;
	private Status currentStatus, prevStatus;
	
	public enum Status{
		ACTIVE,
		IDLE,
		RESERVE;
		
	}
	
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
		currentStatus = Status.ACTIVE;
		timeSteps = 0;
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
	
	public boolean setIdle() {
		prevStatus = currentStatus;
		currentStatus = Status.IDLE;
		if (prevStatus != Status.RESERVE) {
			return true;
		}
		currentStatus = prevStatus;
		return false;
	}
	
	public boolean setReserved(int steps) {
		prevStatus = currentStatus;
		currentStatus = Status.RESERVE;
		if (prevStatus == Status.IDLE) {
			timeSteps = steps;
			return true;
		}
		currentStatus = prevStatus;
		return false;
	}
	
	public boolean setActive() {
		prevStatus = currentStatus;
		currentStatus = Status.ACTIVE;
		if (prevStatus != Status.RESERVE || timeSteps == 0) {
			timeSteps = 0;
			return true;
		}
		currentStatus = prevStatus;
		return false;
		
	}
	
	public void decrementSteps() {
		--timeSteps;
	}
	
	public int getTimeSteps() {
		return timeSteps;
	}
	
	public Status getStatus() {
		return currentStatus;
	}
}
