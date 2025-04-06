
public class Course {
	int courseCredits, crn;
	String courseName, gradeRecieved, semesterTaken, subject;
	
	
	public Course(String courseInfo) {
		String[] info = courseInfo.split(",");
		
		this.subject = info[0];
		this.courseName = info[1];
		this.crn = Integer.parseInt(info[2]);
		this.semesterTaken = info[3];
		this.courseCredits = Integer.parseInt(info[4]);
		this.gradeRecieved = info[5];
		
	}
	
	public int getCourseCredits() {
		return courseCredits;
	}
	
	public int getCrn() {
		return crn;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public String getGradeRecieved() {
		return gradeRecieved;
	}
	
	public String getSemesterTaken() {
		return semesterTaken;
	}
	
	public String getSubject() {
		return subject;
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		
		toReturn += semesterTaken;
		toReturn += '\n';
		toReturn += "|Subject|Course|Name                |Credits|Grade|\n";
		toReturn += "---------------------------------------------------\n";
		toReturn += "|" + subject; 
		for (int i = 0; i < 7-subject.length(); ++i) {
			toReturn += " ";
		}
		
		toReturn += "|" + String.valueOf(crn);
		for (int i = 0; i < 6-String.valueOf(crn).length(); ++i) {
			toReturn += " ";
		}
		toReturn += "|" + courseName;
		for (int i = 0; i < 20-courseName.length(); ++i) {
			toReturn += " ";
		}
		toReturn += "|" + String.valueOf(courseCredits);
		for (int i = 0; i < 7-String.valueOf(courseCredits).length(); ++i) {
			toReturn += " ";
		}
		toReturn +=  "|" + gradeRecieved;
		for (int i = 0; i < 5-gradeRecieved.length(); ++i) {
			toReturn += " ";
		}
		toReturn += "|";
		
		
		return toReturn;
	}
	
	
}
