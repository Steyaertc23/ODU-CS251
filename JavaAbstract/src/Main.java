
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] shapes = {new Rectangle(5,3), new Circle(3)};
		System.out.println("Areas:");
		System.out.println(shapes[0].area());
		System.out.println(shapes[1].area());
		System.out.println("Perimeters:");
		System.out.println(shapes[0].perimeter());
		System.out.println(shapes[1].perimeter());
		
	}

}
