import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bachelors extends Transcript {
	
	public Bachelors() {
		
	}
	
	public Bachelors(String fileInput, String major, String semesterStart) {
		this.major = major;
		this.semesterStart = semesterStart;
		coursesTaken = new ArrayList<Course>();
		
		File file = new File(fileInput);
		name = file.getName();
		int temp = name.lastIndexOf(".");
		name = name.substring(0, temp);
		
		try(Scanner reader = new Scanner(file)){
			String line;
			while(reader.hasNextLine()) {
				line = reader.nextLine();
				addCourse(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	String printTranscript() {
		calculateGPA();
		
		String toReturn = "";
		
		toReturn += "GPA: " + gpa + "\n";
		toReturn += "Name: " + name + '\n';
		toReturn += "Major: " + major + '\n';
		toReturn += "Start Semester: " + semesterStart + '\n';
		
		toReturn += "\n\n";
		
		for (Course course : coursesTaken) {
			toReturn += course;
			toReturn += '\n';
		}
		
		return toReturn;
	}

	@Override
	void writeToFile(String file) {
		// TODO Auto-generated method stub
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
			writer.write(printTranscript());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
