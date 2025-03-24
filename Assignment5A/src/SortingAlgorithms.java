import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SortingAlgorithms {
	private HashMap<Character, Integer> asciiLetterToDec;
	private HashMap<Integer, Character> asciiDecToLetter;
	private File file;
	private ArrayList<String> fileContents;
	
	private final void initializeAsciiMap() {
		asciiLetterToDec = new HashMap<>();
		asciiDecToLetter = new HashMap<>();
		for (int i = 32; i <=126; i++ ) {
			asciiLetterToDec.put((char) i, i);
			asciiDecToLetter.put(i, (char) i);
		}
	}
	
	public SortingAlgorithms(File file) {
		initializeAsciiMap();
		this.file = file;
		fileContents = new ArrayList<>();
	}
	
	private void readInputFile() {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line;
			
			while ((line = reader.readLine()) != null) {
				fileContents.add(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int[] convertCharToInt(char[] listOfChars) {
		int[] listOfInts = new int[listOfChars.length];
		
		for (int i = 0; i < listOfChars.length; i++) {
			listOfInts[i] = asciiLetterToDec.get(listOfChars[i]);
		}
		
		return listOfInts.clone();
	}
	
	private char[] convertIntToChar(int[] listOfInts) {
		char[] listOfChars = new char[listOfInts.length];
		
		for (int i = 0; i < listOfInts.length; i++) {
			listOfChars[i] = asciiDecToLetter.get(listOfInts[i]);
		}
		
		return listOfChars.clone();
	}
	
	private int sumOfAscii(int[] asciiNums) {
		int sum = 0;
		for (int i : asciiNums) {
			sum += i;
		}
		return sum;
	}
	
	private String bubbleSort(String unsorted) {
		
		// Convert to integers for sorting and summation
		int[] convertedString = convertCharToInt(unsorted.toCharArray().clone());
		// Sorting
		int temp;
		for (int i = 0; i < convertedString.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < convertedString.length - i - 1; j++) {
                if (convertedString[j] > convertedString[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = convertedString[j];
                    convertedString[j] = convertedString[j + 1];
                    convertedString[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
		
		// Summation
		temp = sumOfAscii(convertedString.clone());
		
		// Converting the sorted int[] to String
		String sortedString = String.valueOf(convertIntToChar(convertedString.clone()));
		
		return sortedString + "\t\t" + temp;
		
	}
	
	private String insertionSort(String unsorted) {
		
		// Convert to integers for sorting and summation
		int[] convertedString = convertCharToInt(unsorted.toCharArray().clone());
		// Sort
		int n = convertedString.length;
        for (int i = 1; i < n; ++i) {
            int key = convertedString[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && convertedString[j] > key) {
            	convertedString[j + 1] = convertedString[j];
                j = j - 1;
            }
            convertedString[j + 1] = key;
        }
        
        // Summation
        n = sumOfAscii(convertedString.clone());
        
        // Converting the sorted int[] to String
		String sortedString = String.valueOf(convertIntToChar(convertedString.clone()));
		return sortedString + "\t\t" + n;
	}
	
	// Helper
	// Merges two subarrays of a[]
	void merge(int a[], int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];

          for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];

        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }
	
	// Main function that sorts a[] from l-r using
    // merge()
	private void sort(int a[], int l, int r)
    {
        if (l < r) {
          
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(a, l, m);
            sort(a, m + 1, r);

            // Merge the sorted halves
            merge(a, l, m, r);
        }
    }
	
	// Converts string to int[], then sorts it, returns the sorted string
	private String mergeSort(String unsorted) {
		
		int[] convertedString = convertCharToInt(unsorted.toCharArray().clone());
		
		int length = convertedString.length;
		
		
		sort(convertedString, 0, length-1);
		
		
		String sortedString = String.valueOf(convertIntToChar(convertedString));
		return sortedString + "\t\t" + sumOfAscii(convertedString);
		
		
	}
	
	private void writeOut(String line, boolean delete) {
		File file = new File("." + File.separator + "data" + File.separator + "sorted.txt");
		if (delete)
			file.delete();
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
			writer.write(line + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		readInputFile();
		boolean firstRun = true;
		
		// Doing sort for timing purposes
		long timeStart = System.nanoTime();
		for (String line : fileContents) {
			
//			Bubble Sort
			bubbleSort(line);
			

		}
		long timeEnd = System.nanoTime();
		
		long totalTime = timeEnd-timeStart;
		double totalTimeSec = (double) totalTime / 1_000_000_000;
		
		System.out.println("Bubble Sort Time: " + totalTime + " ns (" + totalTimeSec + " sec)");
		
		// Running for timing purposes
		timeStart = System.nanoTime();
		for (String line : fileContents) {
			
//			Insertion Sort
			insertionSort(line);
			
	
		}
		
		timeEnd = System.nanoTime();
		
		totalTime = timeEnd-timeStart;
		totalTimeSec = (double) totalTime / 1_000_000_000;
		
		System.out.println("Insertion Sort Time: " + totalTime + " ns (" + totalTimeSec + " sec)");
		
		// Running for timing purposes
		timeStart = System.nanoTime();
		for (String line : fileContents) {
			
//			Insertion Sort
			mergeSort(line);
			
	
		}
		timeEnd = System.nanoTime();
		
		totalTime = timeEnd-timeStart;
		totalTimeSec = (double) totalTime / 1_000_000_000;
		
		System.out.println("Merge Sort Time: " + totalTime + " ns (" + totalTimeSec + " sec)");
		
		// Doing sort again for writing purposes
		for (String line : fileContents) {
			
			String sorted = insertionSort(line);
			
			writeOut(sorted, firstRun);
			if (firstRun)
				firstRun = false;
			
		}
	}
		
	
}

