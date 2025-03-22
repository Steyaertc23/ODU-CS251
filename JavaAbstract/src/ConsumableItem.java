
public abstract class ConsumableItem extends Item implements Consumable {
	protected int usesLeft;
	
	public ConsumableItem() {
		super();
	}
	
	public ConsumableItem(double damage, double weight, int itemID, int uses, String description) {
		super(damage, weight, itemID, description);
		this.usesLeft = uses;
	}

	abstract protected void decrementUsesLeft();
	
	abstract public int getUsesLeft();
	
	public void printItemID() {
		super.printItemID();
	}

}
