
public class Student {
	private String firstName;
	private String lastName;
	private String gradeLevel;
	private String photoUrl;
	
	public Student(String firstName, String lastName, String gradeLevel, String photoUrl) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeLevel = gradeLevel;
		this.photoUrl = photoUrl;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getGradeLevel() {
		return gradeLevel;
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		
		Student rhs = (Student) obj;
		if (this.firstName == rhs.getFirstName() && this.lastName == rhs.getLastName() && 
				this.gradeLevel == rhs.getGradeLevel()) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		
		String toReturn = "";
		toReturn += "|------------------------------|\n";
		toReturn += "|          |                   |\n";
		toReturn += "|          |                   |\n";
		toReturn += "|          |                   |\n";
		if (gradeLevel.compareToIgnoreCase("senior") == 0 || gradeLevel.compareToIgnoreCase("junior") == 0) {
			toReturn += "|   " + gradeLevel + " |                   |\n";
		}
		else if (gradeLevel.compareToIgnoreCase("sophomore") == 0) {
			toReturn += "|" + gradeLevel + " |                   |\n";
		}
		else if (gradeLevel.compareToIgnoreCase("freshman") == 0) {
			toReturn += "| " + gradeLevel + " |                   |\n";
		}
		toReturn += "|          |                   |\n";
		toReturn += "|          |                   |\n";
		toReturn += "|          |                   |\n";
		toReturn += "|          |                   |\n";
		toReturn += "|          +-------------------|\n"; 
		String temp = "|          " + firstName + " " + lastName;
		int length = temp.length();
		while(length != 31) {
			temp += " ";
			++length;
		}
		toReturn += temp + "|\n";
		toReturn += "|------------------------------|\n";
		toReturn += "Link: " + photoUrl + "\n";
		
		
		
		
		return toReturn;
	}
	
}
