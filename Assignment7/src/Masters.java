import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Masters extends Transcript {
	private String previousUni;
	private ArrayList<String> research;
	
	
	public Masters(String fileInput, String major, String semesterStart) {
		research = new ArrayList<>();
		coursesTaken = new ArrayList<Course>();
		this.major = major;
		this.semesterStart = semesterStart;
		
		
		File file = new File(fileInput);
		name = file.getName();
		int temp = name.lastIndexOf(".");
		name = name.substring(0, temp);
		
		
		try(Scanner reader = new Scanner(file)){
			String line;
			int idx = 0;
			while(reader.hasNextLine()) {
				line = reader.nextLine();
				String[] info = line.split(",");
				if (idx++ == 0) {
					previousUni = info[1];
					continue;
				}
				if (info.length == 2 && info[0].compareTo("Research") == 0) {
					research.add(info[1]);
					++idx;
					continue;
				}
				addCourse(line);
				++idx;
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
		toReturn += "Research: \n";
		toReturn += "Start Semester: " + semesterStart + '\n';
		toReturn += "Major: " + major + '\n';
		toReturn += "Previous College: " + previousUni + '\n';
		
		toReturn += "\n\n";
		
		for (Course course : coursesTaken) {
			toReturn += course;
			toReturn += '\n';
		}
		
		toReturn += "\n\nGPA: " + gpa + "\n";
		
		toReturn += "Research:\n";
		for (String s : research) {
			toReturn += '\t' + s + '\n';
		}
		
		
		return toReturn;
	}

	@Override
	void writeToFile(String file) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
			writer.write(printTranscript());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
