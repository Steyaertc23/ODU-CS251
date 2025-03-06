import java.util.List;
import edu.odu.cs.cs251.Student;

public class SearchingUtils {
	public static Student sequentialSearch(List<Student> list, String query) {
		for (Student student : list) {
			if (student.getName().compareToIgnoreCase(query) == 0) {
				return student;
			}
		}
		return null;
	}
	
	public static Student binarySearch(List<Student> list, String query) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Student currentStudent = list.get(mid);
            if (currentStudent.getName().equals(query)) {
                return currentStudent;
            } else if (currentStudent.getName().compareTo(query) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
	}
}
