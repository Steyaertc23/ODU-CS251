
public class Weapon extends Item {
	
	
	public Weapon(double damage, double weight, int itemID, String description) {
		super(damage, weight, itemID, description);
	}
	
	public void attack(Entity target) {
		target.decreaseHealth(damage);
	}
	
	@Override
	public void printItemID() {
		super.printItemID();
	}
}
