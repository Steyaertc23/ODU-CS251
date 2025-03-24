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
	
	private String[] convertArrListToArr() {
		
		String[] toReturn = new String[fileContents.size()];
		
		for (int i = 0; i < toReturn.length; i++) {
			toReturn[i] = fileContents.get(i);
		}
		
		return toReturn;
	}
	
	private int sumOfAscii(int[] asciiNums) {
		int sum = 0;
		for (int i : asciiNums) {
			sum += i;
		}
		return sum;
	}
	
	private String[] bubbleSort() {
		
		String[] fileContentsArray = convertArrListToArr();
		
		// Sorting
		String temp;
		for (int i = 0; i < fileContentsArray.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < fileContentsArray.length - i - 1; j++) {
            	
                if (Integer.parseInt(fileContentsArray[j].split("\t")[1]) > Integer.parseInt(fileContentsArray[j + 1].split("\t")[1])) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = fileContentsArray[j];
                    fileContentsArray[j] = fileContentsArray[j + 1];
                    fileContentsArray[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
		
		// Converting the sorted int[] to String
		
		return fileContentsArray;
		
	}
	
	private String[] insertionSort() {
		
		
		String[] fileContentsArray = convertArrListToArr();
		// Sort
		int n = fileContentsArray.length;
        for (int i = 1; i < n; ++i) {
            String key = fileContentsArray[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && Integer.parseInt(fileContentsArray[j].split("\t")[1]) > Integer.parseInt(key.split("\t")[1])) {
            	fileContentsArray[j + 1] = fileContentsArray[j];
                j = j - 1;
            }
            fileContentsArray[j + 1] = key;
        }
        
        
		return fileContentsArray;
	}
	
	// Helper
	// Merges two subarrays of a[]
	void merge(String a[], int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;

        String L[] = new String[n1];
        String R[] = new String[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];

          for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];

        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].split("\t")[1].compareTo(R[j].split("\t")[1]) <= 0) {
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
	private void sort(String a[], int l, int r)
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
	
	
	private String[] mergeSort() {
		
		
		
		int length = fileContents.size();
		String[] fileContentsArray = convertArrListToArr();
		
		sort(fileContentsArray, 0, length-1);
		
		return fileContentsArray;
		
		
	}
	
	private void writeOut(String[] lines, boolean delete) {
		File file = new File("." + File.separator + "data" + File.separator + "sorted.txt");
		if (delete)
			file.delete();
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
			for (String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		readInputFile();
		ArrayList<String> temp = new ArrayList<>();
		
		for (int i = 0; i < fileContents.size(); i++) {
			String newContents = fileContents.get(i);
			newContents += "\t" + sumOfAscii(convertCharToInt(newContents.toCharArray()));
			temp.add(newContents);
			System.out.println(newContents);
		}
		
		fileContents = temp;
		
		// Doing sort for timing purposes
		long timeStart = System.nanoTime();
		bubbleSort();
		long timeEnd = System.nanoTime();
		
		long totalTime = timeEnd-timeStart;
		double totalTimeSec = (double) totalTime / 1_000_000_000;
		
		System.out.println("Bubble Sort Time: " + totalTime + " ns (" + totalTimeSec + " sec)");
		
		// Running for timing purposes
		timeStart = System.nanoTime();
		
		insertionSort();
		
		timeEnd = System.nanoTime();
		
		totalTime = timeEnd-timeStart;
		totalTimeSec = (double) totalTime / 1_000_000_000;
		
		System.out.println("Insertion Sort Time: " + totalTime + " ns (" + totalTimeSec + " sec)");
		
		// Running for timing purposes
		timeStart = System.nanoTime();	
//			merge Sort
		String[] writing = mergeSort();
			
	
		
		timeEnd = System.nanoTime();
		
		totalTime = timeEnd-timeStart;
		totalTimeSec = (double) totalTime / 1_000_000_000;
		
		System.out.println("Merge Sort Time: " + totalTime + " ns (" + totalTimeSec + " sec)");
		
		writeOut(writing, true);
		
		
	}
		
	
}

