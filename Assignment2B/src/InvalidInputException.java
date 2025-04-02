
public class InvalidInputException extends Exception {
	private int min, max, input;
	
	public InvalidInputException(int min, int max, int input) {
		this.min = min;
		this.max = max;
		this.input = input;
	}
	
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getInput() {
		return input;
	}
}
