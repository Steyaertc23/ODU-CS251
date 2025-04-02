import java.util.ArrayList;

public class Clients {
	private String firstName;
	private String lastName;
	private int age;
	private double weight;
	private double height;
	private String gymName;
	private ArrayList<String> exercises;
	
	@SuppressWarnings("unchecked")
	public Clients(String fn, String ln, int a, double wgt, double hght, String gym, ArrayList<String> exerc) {
		firstName = fn;
		lastName = ln;
		age = a;
		weight = wgt;
		height = hght;
		gymName = gym;
		exercises = (ArrayList<String>) exerc.clone();
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public String getGymName() {
		return gymName;
	}
	
	public ArrayList<String> getExercises(){
		return exercises;
	}
	
	private String evenOutLines(int length, String s) {
		String temp = s;
		for (int i = 0; i < length-s.length(); i++) {
			temp += " ";
		}
		return temp + "|";
	}
	
	private String evenOutLines(int length, double d) {
		String temp = Double.toString(d);
		String tempCopy = String.valueOf(temp);
		
		for (int i = 0; i < length-tempCopy.length(); i++) {
			temp += " ";
		}
		return temp + "|";
	}
	
	private String evenOutLines(int length, int integer) {
		String temp = Integer.toString(integer);
		String tempCopy = String.valueOf(temp);
		
		for (int i = 0; i < length-tempCopy.length(); i++) {
			temp += " ";
		}
		return temp + "|";
	}
	
	public String toString() {
		String toReturn = "|";
		
		String fullName = firstName + lastName;
		toReturn += evenOutLines(28, fullName);
		
		toReturn += evenOutLines(2, age);
		
		toReturn += evenOutLines(8, weight);
		
		toReturn += evenOutLines(5, height);
		
		toReturn += evenOutLines(20, gymName);
		
		return toReturn; 
	}
	
}
