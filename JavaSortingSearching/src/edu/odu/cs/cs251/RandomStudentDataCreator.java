package edu.odu.cs.cs251;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomStudentDataCreator {

	private Random rand;
	
	public RandomStudentDataCreator() {
		rand = new Random();
	}
	
	public List<Student> generateRandomStudentSet(int numStudents){
		List<Student> students = new LinkedList<>();
		
		for (int i = 0; i < numStudents; i++) {
			students.add(generateRandomStudent());
			Utils.progressBar(i, numStudents);
		}
		Utils.progressBar(numStudents, numStudents);

		
		return students;
	}
	
	public Student generateRandomStudent() {
		int nameLength = rand.nextInt(3,10);
		String name = generateRandomName(nameLength);
		int age = rand.nextInt(18, 99);
		double gpa = rand.nextDouble(4.0d);
		
		return new Student(name, age, gpa);
	}
	
	private String generateRandomName(int length) {
		String alphabet = "abcdefghijklnmopqrstuvwxyz";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int idx = rand.nextInt(alphabet.length());
			sb.append(alphabet.charAt(idx));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		RandomStudentDataCreator creator = new RandomStudentDataCreator();
		Student qin = new Student("qin", 28, 4.0);
		List<Integer> nums = List.of(10, 100, 1000, 10000, 100000, 1000000, 10000000);
		for (int n : nums) {
			System.out.println("Generating %d student set...".formatted(n));
			List<Student> students = creator.generateRandomStudentSet(n-1);
			students.add(new Random().nextInt(n), qin);
			// Write serialized data
			try {
				byte[] serialized = Utils.serialize((Serializable) students);
				Files.write(Path.of("student%d.ser".formatted(n)), serialized);
			} catch (IOException e) {
				System.out.println("Something went wrong. File may not be valid.");
			}
			System.out.println();
		}
	}
}
