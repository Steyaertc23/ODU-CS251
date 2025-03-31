package odu.edu.cs.cs251.dungeoncrawler.items;
import edu.odu.cs.cs251.dungeoncrawler.entities.Entity;

public abstract class ConsumableItem extends Item implements Consumable {

	protected int numUses;
	
	protected ConsumableItem(String description, int numUses) {
		super(description);
		// TODO Auto-generated constructor stub
		
		this.numUses = numUses;
	}

	public abstract void use(Entity target); 
}
