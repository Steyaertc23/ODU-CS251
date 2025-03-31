package odu.edu.cs.cs251.dungeoncrawler.items;
import edu.odu.cs.cs251.dungeoncrawler.entities.Entity;

public class HealingItem extends ConsumableItem {

	private double healAmount;
	public HealingItem(String description, int numUses, double healAmount) {
		super(description, numUses);
		// TODO Auto-generated constructor stub
		this.healAmount = healAmount;
	}

	@Override
	public void use(Entity target) {
		
		target.increaseHealth(healAmount);
		numUses--;
	}
	
}
