import edu.odu.cs.cs251.Student;
import edu.odu.cs.cs251.Image;
import java.util.ArrayList;


public class SortingUtils {
	public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
      
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                  
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;

	}

	public static int[] insertionSort(int[] arr) {
		int n = arr.length;
	    for (int i = 1; i < n; ++i) {
	        int key = arr[i];
	        int j = i - 1;
	
	        while (j >= 0 && arr[j] > key) {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	    return arr;
	}
	
	public static int[] selectionSort(int[] arr) {
		int n = arr.length;
	    for (int i = 0; i < n - 1; i++) {
	        int min_idx = i;
	      
	        for (int j = i + 1; j < n; j++) {
	            if (arr[j] < arr[min_idx])
	                min_idx = j;
	        }
	
	        
	        int temp = arr[min_idx];
	        arr[min_idx] = arr[i];
	        arr[i] = temp;
	    }
	    return arr;
	}
	
	public static int[] mergeSort(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
		int[] merged = new int[leftList.size() + rightList.size()];
		
		ArrayList<Integer> leftListClone = new ArrayList<>(leftList);
		ArrayList<Integer> rightListClone = new ArrayList<>(rightList);
		int number_merged = 0;
		try {
			for (int i = 0; i < merged.length; i++) {
				
				if (leftListClone.get(0) < rightListClone.get(0)) {
					merged[i] = leftListClone.removeFirst();
					number_merged++;
				}
				else {
					merged[i] = rightListClone.removeFirst();
					number_merged++;
				}
			}
		}
		catch(IndexOutOfBoundsException e){
			if (!leftListClone.isEmpty()) {
				for (int i = number_merged; i < merged.length; i++) {
					merged[i] = leftListClone.removeFirst();
				}
			}
			if (!rightListClone.isEmpty()) {
				for (int i = number_merged; i < merged.length; i++) {
					merged[i] = rightListClone.removeFirst();
				}
			}
		}
		
		
		return merged;
	}
	
	public static Student[] bubbleSort(Student[] arr) {
		int n = arr.length;
	      
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].getAge() > arr[j + 1].getAge()) {
                  
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
	}
	
	public static Student[] insertionSort(Student[] arr) {
		int n = arr.length;
	    for (int i = 1; i < n; ++i) {
	        Student key = arr[i];
	        int j = i - 1;
	
	        while (j >= 0 && arr[j].getAge() > key.getAge()) {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	    return arr;
	}
	
	public static Student[] selectionSort(Student[] arr) {
		int n = arr.length;
	    for (int i = 0; i < n - 1; i++) {
	        int min_idx = i;
	      
	        for (int j = i + 1; j < n; j++) {
	            if (arr[j].getAge() < arr[min_idx].getAge())
	                min_idx = j;
	        }
	
	        
	        Student temp = arr[min_idx];
	        arr[min_idx] = arr[i];
	        arr[i] = temp;
	    }	
	    return arr;
	}
	
	public static Student[] mergeSort(Student[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        Student[] left = new Student[mid];
        Student[] right = new Student[array.length - mid];
        System.arraycopy(array, 0, left, 0, mid);
		System.arraycopy(array, mid, right, 0, array.length - mid);
        mergeSort(left);  // Recursively sort the left half
        mergeSort(right); // Recursively sort the right half

        merge(array, left, right); // Merge the sorted halves
		return array;
    }

    // Merge method to combine two sorted arrays
    private static void merge(Student[] array, Student[] left, Student[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getAge() <= right[j].getAge()) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
    
    public static Image[] mergeSort(Image[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        Image[] left = new Image[mid];
        Image[] right = new Image[array.length - mid];
        System.arraycopy(array, 0, left, 0, mid);
		System.arraycopy(array, mid, right, 0, array.length - mid);
        mergeSort(left);  // Recursively sort the left half
        mergeSort(right); // Recursively sort the right half

        merge(array, left, right); // Merge the sorted halves
		return array;
    }

    // Merge method to combine two sorted arrays
    private static void merge(Image[] array, Image[] left, Image[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getFileSize() <= right[j].getFileSize()) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
    
    public static Student[] bubbleSortAlphabetical(Student[] arr) {
    	
    	Student[] tempArr = arr.clone();
    	Student temp;
    	
    	for (int i = 0; i < tempArr.length; i++) {
            for (int j = i + 1; j < tempArr.length; j++) {
                // to compare one string with other strings
                if (tempArr[i].getName().compareTo(tempArr[j].getName()) > 0) {
                    // swapping
                    temp = tempArr[i];
                    tempArr[i] = tempArr[j];
                    tempArr[j] = temp;
                }
            }
        }
    	return tempArr;
    	
    }
	
}
