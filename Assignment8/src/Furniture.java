
public class Furniture {
	private String name, desc;
	private float cost, height, width, weight;
	
	public Furniture(String name, String desc, float cost, float height, float width, float weight) {
		this.name = name;
		this.desc = desc;
		this.cost = cost;
		this.height = height;
		this.width = width;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public float getCost() {
		return cost;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getWeight() {
		return weight;
	}
}
