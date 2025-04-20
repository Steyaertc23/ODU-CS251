import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();

        boolean running = true;
        try (Scanner sc = new Scanner(System.in);){
	        while (running) {
	            System.out.println("Choose an option\n1.View Houses   2.Add House\n3.Quit");
	            int input = sc.nextInt();
	            sc.nextLine();
	
	            switch (input) {
	                case 1:
	                    // Print all added houses
	                    for (House h : houses) {
	                        System.out.println(h);
	                    }
	                    break;
	
	                case 2:
	                	// Get input for house info
	                    House house = new House();
	                    house.addHouse(sc);
	                    houses.add(house);
	                    break;
	
	                case 3:
	                    // Show finish time and exit
	                    System.out.println("\nFinished at: " + LocalTime.now());
	                    running = false;
	                    break;
	
	                default:
	                    System.out.println("Invalid option");
	            }
	        }
        }

    }
}
