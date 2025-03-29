import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
	static Student[] readFile(File file) throws FileNotFoundException {
		ArrayList<Student> studentArrList = new ArrayList<>();
			try(Scanner fileReader = new Scanner(file)){
			
			
			
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				
				String[] student = line.split("\t");
				
				
				studentArrList.add(new Student(student[1], student[2], student[0], student[3]));
				
			}
		}
		
		
		Student[] studentArr = new Student[studentArrList.size()];
		for (int i = 0; i < studentArrList.size(); i++) {
			studentArr[i] = studentArrList.get(i);
		}
		
		return studentArr.clone();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap <String, Student> students = new HashMap<>();
		
		String choice = "N/A";
		while (choice.compareToIgnoreCase("quit") != 0) {
			System.out.println("Which of the following do you want to do (Enter what is in all caps):");
			System.out.println(" SCAN a File");
			System.out.println(" ADD a Student");
			System.out.println(" PRINT a Student's Information");
			System.out.println(" Print ALL Students' Information");
			System.out.println(" QUIT");
			choice = scanner.nextLine();
			
			choice = choice.toUpperCase();
			
			switch (choice) {
			case "SCAN":
				try {
					System.out.println("Where is the input file?");
					Student[] newStudents = readFile(new File(scanner.nextLine()));
					for (Student s : newStudents) {
						String key = s.getFirstName().toLowerCase() + s.getLastName().toLowerCase() 
								+ s.getGradeLevel().charAt(0);
						for (Student k : students.values()) {
							if (!k.equals(s))
								students.put(key, s);
							else {
								System.err.println("Student " + s.getFirstName() + " " + s.getLastName() + 
										" is already within the system.");
							}
						}
					}
					
					
				}catch (FileNotFoundException e) {
					System.err.println("The given file doesn't exist.");
				}
				break;
			case "ADD":
				System.out.println("Please complete this form.");
				System.out.println("Enter the name");
				String[] name = scanner.nextLine().split(" ");
				System.out.println("Enter the grade level (Freshman, Sophomore, Junior, Senior)");
				String grade = scanner.nextLine();
				if (grade.toLowerCase().compareTo(grade) == 0) {
					char temp = grade.charAt(0);
					grade = Character.toUpperCase(temp) + grade.substring(1);
					
				}
				else if (grade.toUpperCase().compareTo(grade) == 0) {
					char temp = grade.charAt(0);
					grade = temp + grade.toLowerCase().substring(1);
				}
				System.out.println("Enter the link to the photo");
				String url = scanner.nextLine();
				
				Student student = new Student(name[0], name[1], grade, url);
				
				String key = name[0].toLowerCase() + name[1].toLowerCase() + grade.charAt(0);
				
				for (Student s : students.values()) {
					if (s.equals(student)) {
						System.err.println("Student " + name[0] + " " + name[1] + 
								" is already within the system.");
						break;
					}
				}
				students.put(key, student);
				
				
				break;
			case "PRINT":
				System.out.println("Who do you want to print out?");
				String fullName = scanner.nextLine();
				
				student = null;
				
				for (Student k : students.values()) {
					if (k.getFullName().compareTo(fullName) == 0) {
						student = k;
						break;
					}
				}
				
				if (student == null) {
					System.err.println("Student " + fullName + 
							" is not within the system.");
					break;
				}
				
				System.out.println(student.toString());
				
				break;
			case "ALL":
				
				for(Student s : students.values()) {
					System.out.println(s.toString());
				}
				
				break;
			case "QUIT":
				System.out.println("Quitting....");
				break;
			default:
				choice = "N/A";
				break;
			}
			
		}
		LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = currentTime.format(formatter);
		
		System.out.println("Completed execution at " + time);
		
	}

}
