import java.util.List;

public interface Room {
	
	float calculateSquareFootage();
	float calculatePerimeter();
	
	List<Furniture> getFurniture();
	
	String getRoomType();
	
}
