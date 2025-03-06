import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		try {
			File file = new File ("."+ File.separator + "data"+ File.separator + "userEcho.txt");
			
			//Read file
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNextLine()) {
				System.out.println(fileReader.nextLine().toUpperCase());
			}
			fileReader.close();
			
			//writeFile
			file = new File("."+ File.separator + "data"+ File.separator + "userNumbers.txt");
			FileWriter writer = new FileWriter(file);
			System.out.println("Enter Numbers:");
			String input = "";
			do {
				writer.write(input);
				input = scanner.nextDouble() + "\n";
			}while(input.compareTo("end\n") != 0);
			
			
			// Read number and divide by 2
			fileReader = new Scanner(file);
			while(fileReader.hasNextDouble()) {
				System.out.println(fileReader.nextDouble() / 2);
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
