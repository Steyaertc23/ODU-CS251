
public class BicycleListing {
	
	enum Condition {
		NEW(1.0),
		USED(0.5),
		DAMAGED(0.25);
		
		double price_mod;
		Condition(double mod) {
			price_mod = mod;
		}
		
		double calcPrice(double price) {
			return price_mod * price;
		}
	}
	
	private double orig_price;
	private Bicycle bicycle;
	private Condition condition;
	
	public BicycleListing(Bicycle bicycle, Condition condition, double price) {
		this.bicycle = bicycle;
		this.condition = condition;
		this.orig_price = price;
	}
	
	void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	Condition getCondition() {
		return condition;
	}
	
	double getOrigPrice() {
		return orig_price;
	}
	
	void setOrigPrice(double price) {
		orig_price = price;
	}
	
	double getAdjustedPrice() {
		return condition.calcPrice(orig_price);
	}
	
	@Override
	public String toString() {
		String formattedPrice = String.format("%.2f", getAdjustedPrice());
		return "Bicycle " + bicycle.serialNo + ": " + "Price: $" + formattedPrice + " Condition: " + getCondition();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (!(obj instanceof BicycleListing)) {
			return false;
		}
		BicycleListing rhs = (BicycleListing) obj;
		return (this.bicycle.serialNo == rhs.bicycle.serialNo && this.getAdjustedPrice() == rhs.getAdjustedPrice() && 
				this.condition == rhs.condition);
	}
}
