
public class HealingItem extends ConsumableItem {

	
	
	public HealingItem(double damage, double weight, int itemID, int uses, String description) {
		super(damage, weight, itemID, uses, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(Entity target) {
		// TODO Auto-generated method stub
		target.increaseHealth(damage);
		decrementUsesLeft();
	}

	@Override
	protected void decrementUsesLeft() {
		// TODO Auto-generated method stub
		usesLeft--;
	}
	
	@Override
	public void printItemID() {
		super.printItemID();
	}
	
	@Override
	public int getUsesLeft() {
		return usesLeft;
	}

}
