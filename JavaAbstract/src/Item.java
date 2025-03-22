
public abstract class Item {
	protected double damage;
	protected double weight;
	protected int itemID;
	protected String description;
	
	public Item() {
		
	}
	
	public Item(double damage, double weight, int itemID, String description) {
		this.damage = damage;
		this.weight = weight;
		this.itemID = itemID;
		this.description = description;
	}
	
	public void printItemID() {
		System.out.println("Item ID: " + itemID);
	}
	
}
