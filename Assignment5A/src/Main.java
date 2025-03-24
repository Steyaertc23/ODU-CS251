import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		SortingAlgorithms sorts = new SortingAlgorithms(new File("." + File.separator + "data" + File.separator + "input.txt"));
		
		sorts.run();
	}

}
