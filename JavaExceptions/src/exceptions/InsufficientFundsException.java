package exceptions;

public class InsufficientFundsException extends Exception {
	private double userAmount, requiredAmount;

	public InsufficientFundsException(double userAmount, double requiredAmount) {
		this.userAmount = userAmount;
		this.requiredAmount = requiredAmount;
	}
	
	public double getUserAmount() {
		return userAmount;
	}
	
	public double getRequiredAmout() {
		return requiredAmount;
	}
}
