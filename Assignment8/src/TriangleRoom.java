import java.util.ArrayList;
import java.util.List;

public class TriangleRoom implements Room {

	private float[] sides;
	
	List<Furniture> furniture;
	
	public TriangleRoom(float[] sides, List<Furniture> f) {
		if (sides.length != 3)
			throw new IllegalArgumentException("Triangle must have 3 sides.");
		this.sides = new float[3];
		this.sides[0] = sides[0];
		this.sides[1] = sides[1];
		this.sides[2] = sides[2];
		
		this.furniture = new ArrayList<>(f);
	}
	
	@Override
	public float calculateSquareFootage() {
		float halfPer = calculatePerimeter() / 2;
		return (float) Math.sqrt(halfPer * (halfPer - this.sides[0]) * 
				(halfPer - this.sides[1]) * (halfPer - this.sides[2]));
	}

	@Override
	public float calculatePerimeter() {
		// TODO Auto-generated method stub
		
		return sides[0] + sides[1] + sides[2];
	}

	@Override
	public List<Furniture> getFurniture() {
		// TODO Auto-generated method stub
		return new ArrayList<>(furniture);
	}
	
	private String furnitureToString() {
	    StringBuilder sb = new StringBuilder();
	    for (Furniture f : furniture) {
	        sb.append("\t\t\t\tName: ").append(f.getName()).append("\n")
	          .append("\t\t\t\tCost: ").append(f.getCost()).append("\n")
	          .append("\t\t\t\tHeight: ").append(f.getHeight()).append("\n")
	          .append("\t\t\t\tWidth: ").append(f.getWidth()).append("\n")
	          .append("\t\t\t\tWeight: ").append(f.getWeight()).append("\n")
	          .append("\t\t\t\tDescription: ").append(f.getDesc()).append("\n\n");
	    }
	    return sb.toString();
	}

	
	@Override
	public String toString() {
	    return "\t\tSquare Footage: " + calculateSquareFootage() +
	           "\n\t\tPerimeter: " + calculatePerimeter() +
	           "\n\t\tFurniture:\n" + furnitureToString();
	}
	
	@Override
	public String getRoomType() {
		return "Triangle Room"; 
	}

}
