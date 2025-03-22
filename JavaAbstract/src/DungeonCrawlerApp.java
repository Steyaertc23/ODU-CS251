import java.util.ArrayList;

public class DungeonCrawlerApp {

	public static void main(String[] args) {
		// TODO 
		ArrayList<Item> items = new ArrayList<>();		
		
		items.add(new DamagingItem(20, 10.2, 10, 5, "Grenade"));
		//double damage, double weight, int itemID, String description
		items.add(new Weapon(45, 25, 21, "Shotgun"));
		items.add(new HealingItem(10, 5.3, 23, 3, "First Aid Kit"));
		
		Dummy d = new Dummy(200, 2, 0);
		
		for (Item obj : items) {
			if (obj instanceof DamagingItem) {
				DamagingItem item = (DamagingItem)obj;
				item.printItemID();
				item.use(d);
				System.out.println(item.getUsesLeft());
				System.out.println(d.getCurrentHealth());
			}
			else if (obj instanceof Weapon) {
				Weapon item = (Weapon) obj;
				item.printItemID();
				item.attack(d);
				System.out.println(d.getCurrentHealth());
			}
			else {
				HealingItem item = (HealingItem)obj;
				item.printItemID();
				item.use(d);
				System.out.println(item.getUsesLeft());
				System.out.println(d.getCurrentHealth());
			}
			
		}
	}

}
