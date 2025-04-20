import java.util.ArrayList;
import java.util.List;

public class CircleRoom implements Room {

	private float radius;
	private List<Furniture> furniture;
	
	
	public CircleRoom(float radius, List<Furniture> furniture) {
		this.radius = radius;
		furniture = new ArrayList<>(furniture);
	}
	
	
	
	@Override
	public float calculateSquareFootage() {
		
		return (float) (Math.PI * radius * radius);
	}


	@Override
	public List<Furniture> getFurniture() {
		// TODO Auto-generated method stub
		return new ArrayList<>(furniture);
	}

	@Override
	public float calculatePerimeter() {
		return (float) (2 * Math.PI * radius);
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
		return "Circle Room"; 
	}

}
