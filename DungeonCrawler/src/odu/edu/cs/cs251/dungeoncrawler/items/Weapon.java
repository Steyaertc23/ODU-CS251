 package odu.edu.cs.cs251.dungeoncrawler.items;
import edu.odu.cs.cs251.dungeoncrawler.entities.Entity;

public abstract class Weapon extends Item implements Equippable {

	private double atkValue;
	private double defValue;
	
	protected Weapon(String description, double atkValue, double defValue) {
		super(description);
		// TODO Auto-generated constructor stub
		this.setAtkValue(atkValue);
		this.setDefValue(defValue);
	}

	public void attack(Entity target) {
		target.decreaseHealth(atkValue);
	}

	public double getDefValue() {
		return defValue;
	}

	public void setDefValue(double defValue) {
		this.defValue = defValue;
	}
	
	public double getAtkValue() {
		return atkValue;
	}
	
	public void setAtkValue(double atkValue) {
		this.atkValue = atkValue;
	}
}
