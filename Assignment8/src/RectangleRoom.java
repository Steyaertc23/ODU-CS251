import java.util.ArrayList;
import java.util.List;

public class RectangleRoom implements Room {
	private float[] sides;
	private List<Furniture> furniture;
	
	public RectangleRoom(float length, float width, List<Furniture> f) {
		this.sides = new float[]{length, width};
		
		this.furniture = new ArrayList<>(f);
	}
	
	@Override
	public float calculateSquareFootage() {
		// TODO Auto-generated method stub
		return sides[0] * sides[1];
	}

	@Override
	public float calculatePerimeter() {
		// TODO Auto-generated method stub
		return (2 * sides[0]) + (2 * sides[1]);
	}

	@Override
	public List<Furniture> getFurniture() {
		// TODO Auto-generated method stub
		return new ArrayList<>(furniture);
	}
	
	private String furnitureToString() {
	    StringBuilder sb = new StringBuilder();
	    for (Furniture f : furniture) {
	        sb.append("\t\tName: ").append(f.getName()).append("\n")
	          .append("\t\tCost: ").append(f.getCost()).append("\n")
	          .append("\t\tHeight: ").append(f.getHeight()).append("\n")
	          .append("\t\tWidth: ").append(f.getWidth()).append("\n")
	          .append("\t\tWeight: ").append(f.getWeight()).append("\n")
	          .append("\t\tDescription: ").append(f.getDesc()).append("\n\n");
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
		if (sides[0] == sides[1])
			return "Square Room";
		return "Rectangle Room"; 
	}

}
