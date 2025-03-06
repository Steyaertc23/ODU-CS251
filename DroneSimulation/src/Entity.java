
public class Entity {
	int[] location;
	
	public Entity() {
		this.location = new int[2];
	}
	
	public Entity(int[] location) {
		this.location = location;
	}
	
	public Entity(int x, int y) {
		location = new int[2];
		location[0] = x;
		location[1] = y;
	}
}
