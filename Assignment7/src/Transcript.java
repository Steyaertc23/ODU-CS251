import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public abstract class Transcript {
	
	protected String degreeType, major, name;
	protected String semesterStart;
	protected double gpa;
	protected ArrayList<Course> coursesTaken;
	
	private enum grade{
		a(4),
		aMinus(3.7),
		bPlus(3.3),
		b(3),
		bMinus(2.7),
		cPlus(2.3),
		c(2),
		cMinus(1.7),
		dPlus(1.3),
		d(1), 
		dMinus(0.7),
		f(0);	
		
		
		private final double gradeValue;
		
		grade(double gradeValue) {
			this.gradeValue = gradeValue;
		}
		
		public double calculatePoints(int credits) {
			return gradeValue * credits;
		}
		
	}
	
	
	abstract String printTranscript();
	
	abstract void writeToFile(String file);
	
	
	double calculateGPA() {
		int numberCredits = 0;
		for (Course course : coursesTaken) {
			String courseGrade = course.getGradeRecieved();
			switch(courseGrade) {
			case "A":
				gpa += grade.a.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "A-":
				gpa += grade.aMinus.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "B+":
				gpa += grade.bPlus.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "B":
				gpa += grade.b.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "B-":
				gpa += grade.bMinus.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "C+":
				gpa += grade.cPlus.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "C":
				gpa += grade.c.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "C-":
				gpa += grade.cMinus.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "D+":
				gpa += grade.dPlus.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "D":
				gpa += grade.d.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "D-":
				gpa += grade.dMinus.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			case "F":
				gpa += grade.f.calculatePoints(course.getCourseCredits());
				numberCredits += course.getCourseCredits();
				break;
			default:
				break;
				
			}
		}
		
		gpa /= numberCredits; 
		
		return gpa;
	}
	
	protected final void addCourse(String info) {
		Course course = new Course(info);
		coursesTaken.add(course);
	}
	
	HashMap<String, ArrayList<String>> coursePerSemester(){
		
		HashMap<String, ArrayList<String>> coursesPerSemester = new HashMap<>();
		
		for (Course course : coursesTaken) {
			String semester = course.getSemesterTaken();
			ArrayList<String> temp;
			if (!coursesPerSemester.containsKey(semester)) {
				temp = new ArrayList<>();
				temp.add(course.toString());
				coursesPerSemester.put(semester, temp);
			}
			else {
				temp = coursesPerSemester.get(semester);
				temp.add(course.toString());
				coursesPerSemester.replace(semester, temp);
			}
		}
		
		return coursesPerSemester;
	}
	
}
