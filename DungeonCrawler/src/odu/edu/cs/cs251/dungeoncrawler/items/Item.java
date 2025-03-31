package odu.edu.cs.cs251.dungeoncrawler.items;


public abstract class Item {
	private int itemID;
	private String description;
	static int nextID = 0;
	
	protected Item(String description) {
		this.setItemID(nextID++);
		this.setDescription(description);
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
