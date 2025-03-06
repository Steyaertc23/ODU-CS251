import edu.odu.cs.cs251.Student;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;


public class SortingLab {
	@SuppressWarnings({"rawtypes"})
	
	public void main(String[] args) {
		try {
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("."+ File.separator + "data"+ File.separator + "student-data" + File.separator + "student100.ser"))) {
		        try {
		            Object obj = in.readObject();
//		            System.out.println(obj.toString());
		            if (!(obj instanceof LinkedList)) {
		            	System.err.println("obj is not a LinkedList");
		            }
		            if (!(((LinkedList) obj).get(0) instanceof Student)) {
	            		System.err.println("obj is not LinkedList<Student>");
	            	}
	            		
						List<Student> students = (LinkedList<Student>) obj;
			            Student[] unorderedStudents = convertToArray(students);
			            
			            Student[] bubbleSorted = SortingUtils.bubbleSort(unorderedStudents.clone());
			            Student[] insertionSorted = SortingUtils.insertionSort(unorderedStudents.clone());
			            Student[] selectionSorted = SortingUtils.selectionSort(unorderedStudents.clone());
			            Student[] mergeSorted = SortingUtils.mergeSort(unorderedStudents.clone());
			            
			            System.out.println("Bubble Sort:");
			            for (int i = 0; i < 5; i++) {
			            	System.out.println(bubbleSorted[i]);
			            }
			            
			            System.out.println("Insertion Sort:");
			            for (int i = 0; i < 5; i++) {
			            	System.out.println(insertionSorted[i]);
			            }
			            
			            System.out.println("Selection Sort:");
			            for (int i = 0; i < 5; i++) {
			            	System.out.println(selectionSorted[i]);
			            }
			            
			            System.out.println("Merge Sort:");
			            for (int i = 0; i < 5; i++) {
			            	System.out.println(mergeSorted[i]);
			            }

		        } 
		        catch (ClassNotFoundException e) {
		        	e.printStackTrace();
		        }
//		    }
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
	
	private Student[] convertToArray(List<Student> arr) {
		Student[] temp = new Student[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			temp[i] = arr.get(i);
		}
		return temp;
	}
}
