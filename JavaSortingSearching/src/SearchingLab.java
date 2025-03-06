import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

import edu.odu.cs.cs251.Student;

public class SearchingLab {
	
	public static void mainFunc() {
		try {
			
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("."+ File.separator + "data"+ File.separator + "student-data" + File.separator + "student100.ser"))) {
			        try {
			            Object obj = in.readObject();
//			            System.out.println(obj.toString());
			            if (!(obj instanceof LinkedList)) {
			            	System.err.println("obj is not a LinkedList");
			            }
			            if (!(((LinkedList) obj).get(0) instanceof Student)) {
		            		System.err.println("obj is not LinkedList<Student>");
		            	}
		            		
							List<Student> students = (LinkedList<Student>) obj;
				            
							
							Student seqSearch = SearchingUtils.sequentialSearch(students, "qin");
							System.out.println("Sequential Search:" + seqSearch);
							
							List<Student> orderedStudents = Arrays.asList(SortingUtils.bubbleSortAlphabetical(convertToArray(students)));
							
							Student binarySearched = SearchingUtils.binarySearch(orderedStudents, "qin");
							System.out.println("Binary Search:" + binarySearched);
							
							
							

			        } 
			        catch (ClassNotFoundException e) {
			        	e.printStackTrace();
			        }
//			    }
			} 
			catch (EOFException e) {
			    // unfortunately ObjectInputStream doesn't have a good way to detect the end of the stream
			    // so just ignore this exception - it's expected when there are no more objects
			}
			
			}
			catch (IOException e){
				e.printStackTrace();
			}
	}
	
	private static Student[] convertToArray(List<Student> arr) {
		Student[] temp = new Student[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			temp[i] = arr.get(i);
		}
		return temp;
	}

}
