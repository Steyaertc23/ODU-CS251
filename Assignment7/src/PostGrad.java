import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PostGrad extends Transcript {
	private String gradDate;
	
	public PostGrad(String fileInput, String major, String semesterStart) {
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
				String[] info = line.split(",");
				if (info[1].contains("-")) {
					gradDate = info[1];
					continue;
				}
				addCourse(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String centerText(String text, int width) {
        if (text.length() >= width) {
            return text;
        }
        int leftPadding = (width - text.length()) / 2;
        int rightPadding = width - text.length() - leftPadding;
        String centeredText = "";
        for (int i = 0; i < leftPadding; i++) {
            centeredText += " ";
        }
        centeredText += text;
        for (int i = 0; i < rightPadding; i++) {
            centeredText += " ";
        }
        return centeredText;
    }
	
	@Override
	String printTranscript() {
		calculateGPA();
		
		String toReturn = "";
		
		toReturn += "GPA: " + gpa + "\n";
		toReturn += "Start Semester: " + semesterStart + '\n';
		toReturn += "Graduation Date: " + gradDate + '\n';
		toReturn += "Major: " + major + '\n';
		
		
		toReturn += "\n\n";
		
		for (Course course : coursesTaken) {
			toReturn += course;
			toReturn += '\n';
		}
		
		String honors = "";
		if (gpa >= 3.5 && gpa < 3.7) {
			honors = "Cum Laude";
		}
		else if(gpa >= 3.7 && gpa < 3.9) {
			honors = "Magna Cum Laude";
		}
		else if(gpa >= 3.9) {
			honors = "Summa Cum Laude";
		}
		
		toReturn += "\n\nGPA: " + gpa + "\n";
		toReturn += "+-----------------------------------------------------+\n";
		toReturn += "|" + centerText("Old Dominion University", 53) + "|\n";
		toReturn += "|" + centerText("Bachelor of " + major, 53) + "|\n";
		toReturn += "|" + centerText(honors, 53) + "|\n";
		toReturn += "|" + centerText("upon", 53) + "|\n";
		toReturn += "|" + centerText(name, 53) + "|\n";
		toReturn += "+-----------------------------------------------------+\n";
		
		
		
		
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
