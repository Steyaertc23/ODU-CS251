package edu.odu.cs.cs251;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

public class Student implements Serializable, Comparable<Student> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4871755999788113524L;

	/**
	 * Deserializes a given byte array into a List of Students
	 * @param bytes Byte array
	 * @return List<Student> or null if an exception is thrown
	 */
	public static List<Student> deserializeStudentList(byte[] bytes) {
		try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais)) {
			return (List<Student>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error deserializing byte array");
			return null;
		}
	}
	
	private String name;
	private int age;
	private double gpa;
	
	public Student(String name, int age, double gpa) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getGpa() {
		return gpa;
	}

	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, age=%s, gpa=%s]", name, age, gpa);
	}
	
	
}
