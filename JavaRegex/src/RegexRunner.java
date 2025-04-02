import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRunner {
	private static Scanner scan = new Scanner(System.in);
	private static void optionOne() {
		try{
			System.out.println("Enter a regular expression");
			String regex = scan.nextLine();
			
			/// Compile the pattern
			Pattern pattern = Pattern.compile(regex);
			
			System.out.println("Enter some strings");
			System.out.println("Enter -exit- to end this portion of the program");
			System.out.println("Enter -new- to write a different regex");
			while(scan.hasNext()) {
				String compare = scan.nextLine();
				if (compare.equals("-exit-")) {
					break;
				}
				
				else if (compare.equals("-new-")) {
					System.out.println("Enter a regular expression");
					regex = scan.nextLine();
					/// Compile the pattern
					pattern = Pattern.compile(regex); 
					System.out.println("Enter some strings");
				}
				
				else {		
					/// Compare using a Matcher
					Matcher matcher = pattern.matcher(compare);
					/// Print whether it matches or not 
					if (matcher.matches())
						System.out.printf("%s matches the regex %s\n", compare, pattern.toString());
					
					else
						System.out.printf("%s does not match the regex %s\n", compare, pattern.toString());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void optionTwo() {
		try{
			String regex = "[a-z]{5}+[0-9]{3}+@odu\\.edu";
			
			/// Compile the pattern
			Pattern pattern = Pattern.compile(regex);
			
			System.out.println("Enter some emails with the MIDAS@odu.edu regex");
			System.out.println("Enter -exit- to end this portion of the program");
			while(scan.hasNext()) {
				String compare = scan.nextLine();
				if (compare.equals("-exit-")) {
					break;
				}
				else {		
					/// Compare using a Matcher
					Matcher matcher = pattern.matcher(compare);
					/// Print whether it matches or not 
					if (matcher.matches())
						System.out.printf("%s matches the MIDAS@odu.edu regex \n", compare);
					
					else
						System.out.printf("%s does not match the MIDASID@odu.edu regex \n", compare);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void run() {
		int choice = -1;
		while (choice != 3) {
			System.out.println("Select One of the following: ");
			System.out.println("1. Enter Your Own Regex");
			System.out.println("2. Enter an Email");
			System.out.println("3. Exit");
			
			choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
			case 1:
				optionOne();
				break;
			case 2:
				optionTwo();
				break;
			case 3:
				System.out.println("Exiting the program...");
				break;
			default:
				System.err.println("Please choose choice 1, 2, or 3.");
			}
		}
		
		System.out.println("Program completed at");
		LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = currentTime.format(formatter);
		
		System.out.println("\nCompleted execution at " + time);
		
	}
	
}
