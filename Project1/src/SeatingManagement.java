import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SeatingManagement {
	private enum Seating{
		Available, Unavailable, NotASeat;
	}
	
	private final File originalSeatingFile = new File("."+ File.separator + "data"+ File.separator + "seating1.txt");
	private final File updatedSeatingFile = new File("."+ File.separator + "data"+ File.separator + "updated-seating.txt");
	
	private final char booked = '◼';
	private final char available = '◻';
	private final char notASeat = '-';
	
	private Seating[][] seating;
	private int noAvailableSeats;
	private int noBookedSeats;
	private int totalSeats;
	
	private static Scanner scanner = new Scanner(System.in);
	
	
	public SeatingManagement() {
		seating = new Seating[1][1];
		noBookedSeats = 0;
		noAvailableSeats = 0;
		
	}
		
	private void readOriginalSeatingFile() {
		
		try(Scanner fileReader = new Scanner(originalSeatingFile)){
			int lineNo = -1;
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				if (lineNo == -1) {
					String[] temp = line.split(" ");
					seating = new Seating[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])];
				}
				else {
					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == booked) {
							seating[lineNo][i] = Seating.Unavailable;
							noBookedSeats++;
							totalSeats++;
						}
						else if (line.charAt(i) == available) {
							seating[lineNo][i] = Seating.Available;
							noAvailableSeats++;
							totalSeats++;
						}
						else if (line.charAt(i) == notASeat){
							seating[lineNo][i] = Seating.NotASeat;
						}
						else {
							continue;
						}
					}
				}
				++lineNo;
			}
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readSeatingFile() {
		
		
		
		// Determine if the updated seating file or the original seating file needs to be used.
		// If the updated seating file doesn't exist, will read from original seating file
		// Otherwise, will read from updated seating file.
		if(!updatedSeatingFile.exists())
			readOriginalSeatingFile();
		else {
		// Reading from the updated seating file
			try(Scanner fileReader = new Scanner(updatedSeatingFile)){
				int lineNo = -3;
				while (fileReader.hasNextLine()) {
					String line = fileReader.nextLine();
					if (lineNo == -3) {
						String[] temp = line.split(" ");
						seating = new Seating[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])];
					}
					else if (lineNo != -2 || lineNo != -1){
						String row = line.split(" ")[1];
						for (int i = 0; i < row.length(); i++) {
							if (row.charAt(i) == booked) {
								seating[lineNo][i] = Seating.Unavailable;
								noBookedSeats++;
								totalSeats++;
							}
							else if (row.charAt(i) == available) {
								seating[lineNo][i] = Seating.Available;
								noAvailableSeats++;
								totalSeats++;
							}
							else if (row.charAt(i) == notASeat){
								seating[lineNo][i] = Seating.NotASeat;
							}
							else {
								continue;
							}
						}
					}
					++lineNo;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	private void deleteUpdatedFile() {
		try {
            if (updatedSeatingFile.delete()) {
//                System.out.println(updatedSeatingFile.getName() + " deleted successfully.");
            } 
        } catch (SecurityException e) {
            System.err.println("Deletion of \"" + updatedSeatingFile.getName() + "\" not permitted");
        }

	}
	
	private void writeSeatingFile() {
		deleteUpdatedFile();
		try(PrintWriter writer = new PrintWriter(new FileWriter(updatedSeatingFile))){
			writer.println(seating.length + " " + seating[0].length);
			for (int i = 0; i <= seating[0].length; i++) {
				if (i%10 == 0)
					if (i != 0) 
						writer.print(i/10);	
					else	
						writer.print(i + " ");
				else
					writer.print(" ");
			}
			writer.println();

			for (int i = 0; i <= seating[0].length; i++) {
				if (i != 0) {
					writer.print(i%10);
					
				}
				else {
					writer.print("  ");
				}
			}
			writer.println();
			for (int i = 0; i < seating.length; i++) {

				// Sets the row letter
				String rowLetter = "";
				switch (i) {
				case 0: 	rowLetter = "A "; break;
				case 1: 	rowLetter = "B "; break;
				case 2: 	rowLetter = "C "; break;
				case 3: 	rowLetter = "D "; break;
				case 4: 	rowLetter = "E "; break;
				case 5: 	rowLetter = "F "; break;
				default: 	rowLetter = "DNE"; break;
				}
				
				String rowString = rowLetter;
				// Appends each seat of the row to the row string to print the row out
				for (Seating seat : seating[i]) {
					if (seat == Seating.Unavailable) {
						rowString += booked;
					}
					else if (seat == Seating.Available) {
						rowString += available;
					}
					else {
						rowString += notASeat;
					}
				}
				writer.println(rowString);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void printSeating() {
		for (int i = 0; i <= seating[0].length; i++) {
			if (i%10 == 0)
				System.out.print(i/10);
			else
				System.out.print(" ");
		}
		System.out.println();
		
		for (int i = 0; i <= seating[0].length; i++) {
			if (i == 0) {
				System.out.print(" ");
			}
			else {
				System.out.print(i%10);
			}
		}
		System.out.println();
		for (int i = 0; i < seating.length; i++) {

			// Sets the row letter
			String rowLetter = "";
			switch (i) {
			case 0: 	rowLetter = "A"; break;
			case 1: 	rowLetter = "B"; break;
			case 2: 	rowLetter = "C"; break;
			case 3: 	rowLetter = "D"; break;
			case 4: 	rowLetter = "E"; break;
			case 5: 	rowLetter = "F"; break;
			default: 	rowLetter = "DNE"; break;
			}
			
			String rowString = rowLetter;
			// Appends each seat of the row to the row string to print the row out
			for (Seating seat : seating[i]) {
				if (seat == Seating.Unavailable) {
					rowString += booked;
				}
				else if (seat == Seating.Available) {
					rowString += available;
				}
				else {
					rowString += notASeat;
				}
			}
			System.out.println(rowString);
		}
		System.out.println("Booked Seats: " + noBookedSeats + "/" + totalSeats);
		System.out.println("Available Seats: " + noAvailableSeats + "/" + totalSeats);
	}
	
	private boolean bookASeat() {
		try{
			String location = scanner.nextLine();
			int[] seatID = SeatingChart.rowColumnIndexFromSeatID(location.toUpperCase());
			if (seatID[0] >= seating.length || seatID[0] < 0) {
				char[] rowLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
									 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
				System.err.println("Invalid Row. Please enter row letter A-" + String.valueOf(rowLetters[seating.length-1]));
				return false;
			}
			else if (seatID[1] >= seating[0].length || seatID[1] < 0) {
				System.err.println("Invalid Column, please enter column number 1 - " + seating[0].length );
				return false;
			}
			else if (Seating.Unavailable == seating[seatID[0]][seatID[1]]) {
				System.err.println("The seat has already been booked.");
				return false;
			}
			else if (Seating.NotASeat == seating[seatID[0]][seatID[1]]) {
				System.err.println("The given location is not a seat.");
				return false;
			}
			
			seating[seatID[0]][seatID[1]] = Seating.Unavailable;
			
			noBookedSeats++;
			noAvailableSeats--;
			
			return true;
		}catch (Exception e){
			return false;
		}
	}

	private boolean cancelBooking() {
		try{
			String location = scanner.nextLine();
			int[] seatID = SeatingChart.rowColumnIndexFromSeatID(location);
			if (seatID[0] >= seating.length || seatID[0] < 0) {
				char[] rowLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
									 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
				System.err.println("Invalid Row. Please enter row letter A-" + String.valueOf(rowLetters[seating.length-1]));
				return false;
			}
			else if (seatID[1] >= seating[0].length || seatID[1] < 0) {
				System.err.println("Invalid Column, please enter column number 1 - " + seating[0].length );
				return false;
			}
			else if (Seating.Available == seating[seatID[0]][seatID[1]]) {
				System.err.println("The seat is already been available.");
				return false;
			}
			
			seating[seatID[0]][seatID[1]] = Seating.Available;
			
			noBookedSeats--;
			noAvailableSeats++;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	private String findAdjacentSeats(int numberAdjacent){
		
		ArrayList<String> adjacentSeats = new ArrayList<>();
		
		boolean foundNumberAdjacent = false;
		
		for (int i = 0; i < seating.length; i++) {
			int location = 0;
			
			while (numberAdjacent != adjacentSeats.size()) {
				if (seating[i][location] == Seating.Available) {
					adjacentSeats.add(SeatingChart.seatIDFromRowColumnIndex(i, location));
					location++;
					if (adjacentSeats.size() == numberAdjacent) {
						foundNumberAdjacent = true;
						break;
					}
				}
				else {
					adjacentSeats.clear();
					location++;
				}
			}
			if (foundNumberAdjacent) break;
		}
		if (foundNumberAdjacent) return adjacentSeats.getFirst();
		
		return null;
	}
	
	private void bookAdjacentSeats(int numberAdjacentSeats, String startingPos) {
		int[] seatID = SeatingChart.rowColumnIndexFromSeatID(startingPos);
		for (int i = seatID[1]; i < seatID[1] + numberAdjacentSeats; i++) {
			seating[seatID[0]][i] = Seating.Unavailable;
		}
	}
	
	private boolean menu() {		
		
		try{
			int input = scanner.nextInt();
			scanner.nextLine();
			switch (input) {
			case 1 -> {
				printSeating();
				boolean seatBooked = false;
				do {
					System.out.println("Which seat would you like to book? Enter with format ROW COLUMN (e.g. A 15)");
					seatBooked = bookASeat();
				} while (!seatBooked);
				
				System.out.println("Updated Seating Chart: ");
				printSeating();
				return true;
				
			}
			case 2 -> {
				printSeating();
				
				boolean canceled = false;
				do {
					System.out.println("Enter Seat to Cancel booking for: Enter with format ROW COLUMN (e.g. A 15)");
					canceled = cancelBooking();
				}while (!canceled);
				
				System.out.println("Updated Seating Chart: ");
				printSeating();
				return true;
			}
			case 3 -> {
				
				System.out.println("Enter number of adjacent seats:");
				int adjacent = scanner.nextInt();
				scanner.nextLine();
				String starting = findAdjacentSeats(adjacent);
				if (null == starting) 
					System.err.println("Unable to find " + adjacent + " available seats.");
				
				else
					bookAdjacentSeats(adjacent, starting);
				
				return true;
			}
			
			case 4 -> {
				printSeating();
				return true;
			}

			case 5 -> {
				writeSeatingFile();
				System.out.println("Saving and exiting....");
				return false;
			}
			default -> {
				System.err.println("Invalid Input, please enter number 1-5");
				return true;
			}
				
			}
		}catch (Exception e) {
			return true;
		}
		
	}
	
	public void run() {
		readSeatingFile();
		boolean run = true;
		while (run) {
			System.out.println("1. Book a seat");
			System.out.println("2. Cancel Reservation");
			System.out.println("3. Find N adjacent available seats");
			System.out.println("3. Show current seating chart");
			System.out.println("4. Save and Exit");
			System.out.println("Enter Your Choice:");
			run = menu();	
		}
	}
	
}
