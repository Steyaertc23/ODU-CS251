package edu.odu.cs.cs251.dungeoncrawler.entities;
import odu.edu.cs.cs251.dungeoncrawler.items.Consumable;
import odu.edu.cs.cs251.dungeoncrawler.items.Weapon;

public abstract class CombatEntity extends Entity {

    protected double atkPower;
    protected double defPower;
    protected String name;

    public CombatEntity(double health, int eID, double speed, double atkPower, double defPower, String name) {
        super(health, eID, speed);
        this.atkPower = atkPower;
        this.defPower = defPower;
        this.name = name;
    }

    public void attack(Entity target) {
        target.decreaseHealth(atkPower);
    }

    public void attack(Weapon w, Entity target) {
        w.attack(target);
    }

    public void defend(Weapon w){
        increaseHealth(w.getDefValue());
    }

    public void useItem(Consumable i, Entity target){
        i.use(target);
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

}
