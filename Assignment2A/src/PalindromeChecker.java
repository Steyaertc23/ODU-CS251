import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeChecker {
	private static ArrayList<String> fileContentsArray = new ArrayList<>();
	private static String[] fileContentsList;
	
	private static String reverse(String word) {
		String temp = "";
		for (int i = word.length()-1; i >= 0; i--) {
			temp += word.charAt(i);
		}
		return temp.toLowerCase();
	}
	
	private static int getSizeFile(File f) {
		int length = 0;
		try (Scanner lines = new Scanner(f)) {
			
			while (lines.hasNextLine()) {
				lines.nextLine();
				length++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return length;
	}
	
	private static void readFile(File f){
		int fileLen;
		fileLen = getSizeFile(f);
		fileContentsList = new String[fileLen];
		try(Scanner fileReader = new Scanner(f)) {
			String temp;
			int counter = 0;
			while(fileReader.hasNextLine()) {
				temp = fileReader.nextLine();
				fileContentsArray.add(temp);
				fileContentsList[counter++] = temp;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static boolean determinePalindrome(String word) {
		
		if(word.compareToIgnoreCase(reverse(word)) == 0) {
			return true;
		}
		
		return false;
	}
	
	private static void appendToFile(File f, String palindrome) {
		try(BufferedWriter out = new BufferedWriter(new FileWriter(f, true))) {
	            out.write(palindrome + "\n");
	            out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void run() {
		File dataFile = new File("." + File.separator + "data" + File.separator + "words.txt");
		File saveArrayList = new File ("." + File.separator + "data" + File.separator + "arrayListpalindrome.txt");
		File saveArray = new File ("." + File.separator + "data" + File.separator + "arraypalindrome.txt");
		
		readFile(dataFile);
		for (String word : fileContentsArray) {
			if (determinePalindrome(word)) {
				appendToFile(saveArrayList, word);
			}
		}
		for (String word : fileContentsList) {
			if(determinePalindrome(word)) {
				appendToFile(saveArray, word);
			}
		}
		
	}
}
