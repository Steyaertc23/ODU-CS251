
public class BicycleListing {
	enum Condition{
		NEW(1.0),
		USED(0.5),
		DAMAGED(0.25);
		
		double price_mod;
		
		Condition(double mod){
			price_mod = mod;
		}
		
		double calcPrice(double price) {
			return price * price_mod;
		}
	}
	
	private Bicycle bicycle;
	private Condition condition;
	private double price;
	
	public BicycleListing(Bicycle bicycle, Condition condition, double price){
		this.bicycle = bicycle;
		this.condition = condition;
		this.price = price;
	}
	
	void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	Condition getCondition() {
		return condition;
	}
	
	double getOrigPrice() {
		return price;
	}
	
	void setOrigPrice(double price) {
		this.price = price;
	}
	
	double getAdjustedPrice() {
		return condition.calcPrice(price);
	}
	
	
}
