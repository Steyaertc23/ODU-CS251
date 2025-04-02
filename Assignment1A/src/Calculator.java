import java.util.Scanner;

public class Calculator {
	private int[] numbers;
	private int sum, diff, product, mod, firstSquared, secondSquared;
	private double quotient;
	
	private int[] consoleInput() {
		Scanner in = new Scanner(System.in);
		boolean validInput = false;
		int[] numberArray = new int[2];
	 
		
		// Asks user for 2 integers separated by a single space. If not followed,
		// the loop will continue until the numbers can be assigned to the numberArray
		
		while(validInput != true) {
			System.out.println("Enter two integers separated by a space:");
			String numbers = in.nextLine();
			
			try {
				numberArray[0] = Integer.parseInt(numbers.split(" ")[0]);
				numberArray[1] = Integer.parseInt(numbers.split(" ")[1]);
				validInput = true;
			}
			catch (Exception e){
				System.out.println("Improper input, try again");
			}
		}
		in.close();
		return numberArray;
	}
	
	// Calculation Methods
	
	private int add(int a, int b) {
		return a + b;
	}
	
	private int subtract(int a, int b) {
		return a - b;
	}
	
	private int multiply(int a, int b) {
		return a * b;
	}
	
	private double divide(int a, int b) {
		return a / b;
	}
	
	private int square(int a) {
		int a_squared = (int)Math.pow(a, 2);
		
		return a_squared;
	}
	
	private int modulus(int a, int b) {
		return a % b;
	}
	
	
	// Runs all the calculations and outputs them to the screen
	public void run() {
		numbers = consoleInput();
		
		sum = add(numbers[0], numbers[1]);
		diff = subtract(numbers[0], numbers[1]);
		product = multiply(numbers[0], numbers[1]);
		quotient = divide(numbers[0], numbers[1]);
		firstSquared = square(numbers[0]);
		secondSquared = square(numbers[1]);
		mod = modulus(numbers[0], numbers[1]);
		
		
		System.out.println("Addidtion: " + sum);
		System.out.println("Subtraction: " + diff);
		System.out.println("Multiplication: " + product);
		System.out.println("Division: " + quotient);
		System.out.println("Square of the first: " + firstSquared);
		System.out.println("Square of the second: " + secondSquared);
		System.out.println("Modulus : " + mod);
		
	}
	
}
