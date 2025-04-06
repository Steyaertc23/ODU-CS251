import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the input text file (studentName.txt)");
		String file = scanner.nextLine();
		System.out.println("Enter starting semester (SemesterYYYY)");
		String startingSemester = scanner.nextLine();
		System.out.println("Enter the major");
		String major = scanner.nextLine();
		System.out.println("Where do you want the transcript to be outputted?");
		String outfile = scanner.nextLine();
		
		
		
		Transcript transcript = new Bachelors();
		try(Scanner read = new Scanner(new File(file))){
			String line = read.nextLine();
			String[] info = line.split(",");
			if (info.length > 2) {
				transcript = new Bachelors(file, major, startingSemester);
			}
			else if(line.contains("-")) {
				transcript = new PostGrad(file, major, startingSemester);
			}
			else {
				transcript = new Masters(file, major, startingSemester);
			}
			System.out.println("\n\n");
			System.out.println(transcript.printTranscript());
			transcript.writeToFile(outfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = currentTime.format(formatter);
		
		System.out.println("\nCompleted execution at " + time);
	}

}
