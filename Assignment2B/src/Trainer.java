import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Trainer {
	
	static ArrayList<Exercises> allExercises = new ArrayList<>();
	static ArrayList<Clients> allClients = new ArrayList<>();
	static ArrayList<Gyms> allGyms = new ArrayList<>();
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void readExercises() {
		try( Scanner fileReader = new Scanner(new File("." + File.separator + "data" + File.separator + "Exercises.txt"))){
			
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] exerciseInfo = line.split(",");
				
				Exercises exercise = new Exercises(exerciseInfo[0], exerciseInfo[1], exerciseInfo[2], Boolean.getBoolean(exerciseInfo[3]));
				
				allExercises.add(exercise);
				
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void readClients() {
		try( Scanner fileReader = new Scanner(new File("." + File.separator + "data" + File.separator + "Clients.txt"))){
			
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
//				System.out.println(line);
				String[] clientInfo = line.split(",");
				String clientFirst = clientInfo[0];
				String clientLast = clientInfo[1];
//				for (String s : clientInfo) {
//					System.out.println(s);
//				}
				
				
				
				ArrayList<String> clientExercises = new ArrayList<>(Arrays.asList(clientInfo[6].split(";")));

				Clients client = new Clients(clientFirst, clientLast, Integer.parseInt(clientInfo[2]), Double.valueOf(clientInfo[3]),
											 Double.valueOf(clientInfo[4]), clientInfo[5], clientExercises);
				
				allClients.add(client);
				
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void readGyms() {
		try( Scanner fileReader = new Scanner(new File("." + File.separator + "data" + File.separator + "Gyms.txt"))){
			
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] gymInfo = line.split(",");
				
				Gyms exercise = new Gyms(gymInfo[0], gymInfo[1]);
				
				allGyms.add(exercise);
				
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Exercises getExercise(String exercise) {
		
		for (Exercises e : allExercises) {
			if (exercise.compareToIgnoreCase(e.getName()) == 0) {
				return e;
			}
		}
		return null;
	}
	
	
	public static int validInput(String inp) throws NumberFormatException, InvalidInputException{
		int input = Integer.parseInt(inp);
		if (0 < input && input < 6) {
			return input;
		}
		throw new InvalidInputException(1,5,input);
	}
	
	public static void printOptions() {
		System.out.println("1. Print all Clients");
		System.out.println("2. Print all Exercises");
		System.out.println("3. Print all Gyms");
		System.out.println("4. Print a Client's Exercises");
		System.out.println("5. Exit");
	}
	
	public static int getInput() {
		int input = -1;
		
		printOptions();
		
		while (input == -1) {
			try {
				String inp = scanner.nextLine();
				input = validInput(inp);
			}catch(NumberFormatException | InvalidInputException e) {
//				e.printStackTrace();
				System.err.println("Input invalid.");
			}
		}
		return input;
	}
	
	
	
	public static void run() {
		readExercises();
		readClients();
		readGyms();
		int input = -1;
		do {
			input = getInput();
			switch (input){
			// if input is 1
			case 1:
				for(Clients c : allClients) {
					System.out.println(c.toString());
				}
				System.out.println();
				break;
			case 2:
				for(Exercises e : allExercises) {
					System.out.println(e.toString());
				}
				System.out.println();
				break;
			case 3:
				for(Gyms g : allGyms) {
					System.out.println(g);
				}
				System.out.println();
				break;
			case 4:
				System.out.println("Enter Client's Name (first last)");
				String fullName = scanner.nextLine();
				String firstName = fullName.split(" ")[0];
				String lastName = fullName.split(" ")[1];
				boolean found = false;
				for (Clients c : allClients) {
					if (firstName.compareToIgnoreCase(c.getFirstName()) == 0 && lastName.compareToIgnoreCase(c.getLastName()) == 0) {
						ArrayList<String> exercises = c.getExercises();
						for (String e : exercises) {
							System.out.println(getExercise(e).toString());
						}
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("Client is not in database.");
				}
				System.out.println();
				break;
			default:
					System.out.println("Exiting...");
			}
			
		}while (input != 5);
		System.err.println("Done.");
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}

}
