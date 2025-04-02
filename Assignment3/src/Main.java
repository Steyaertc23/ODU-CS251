import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Car> cars = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		
		int input = -1;
		do {
			System.out.println("1. Print Cars \t2. Add Car \t3. Exit");
			try {
				input = scan.nextInt();
				scan.nextLine();
				switch (input){
				case 1:
					System.out.println("---------------------------------------");
					for (Car c : cars) {
						System.out.println(c.toString());
					}
					break;
				case 2:
					System.out.println("Enter VIN: ");
					String vin = scan.nextLine();
					Car c = new Car(vin);
					
					System.out.println("Checking for Information not found...");
					System.out.println("Enter the Model of the car");
					String model = scan.nextLine();
					
					System.out.println("Enter the Color of the car");
					String color = scan.nextLine();
					
					System.out.println("Enter the Brand and PSI recommendation for the tires (separated by comma[,])");
					String[] brandOfTiresAndPSI = scan.nextLine().split(",");
					String brandOfTires = brandOfTiresAndPSI[0];
					double psi = Double.parseDouble(brandOfTiresAndPSI[1]);
					
					System.out.println("Enter the Brand of Brakes");
					String brandOfBrakes = scan.nextLine();
					
					System.out.println("Enter the last date of replacement of the brakes (Use format MM-dd-yyyy)");
					Date date = null;
					
					do {
						try {
							
							String dateString = scan.nextLine();
							date = format.parse(dateString);
						
						}catch(ParseException e) {
							
							System.err.println("Invalid input. Please use MM-dd-yyyy format (Ex. 02-13-2025)");
							date = null;
						
						}
					} while(date == null);
					
					c.setMissing(model, color, brandOfTires, psi, brandOfBrakes, (Date)date.clone());
					
					cars.add(c);
					
					break;
				case 3:
					System.err.println("Exiting...");
					break;
				default:
					System.err.println("Invalid input, only inputs 1-3 are valid");
					break;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid Input");
			}
		} while(input != 3);
		
		
	}

}
