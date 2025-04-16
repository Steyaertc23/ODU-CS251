package users;

import auctions.AllAuctions;
import auctions.Auctions;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Auctioneer extends Users{
	private  ArrayList<Auctions> auctions = new ArrayList<>();
	
	public Auctioneer(String username, String password, AllAuctions obj) {
		super(username, password);
		//TODO
		setAuctions(obj);
	}
	
	public ArrayList<Auctions> getAuctions() {
		return auctions;
	}
	/*
	 * Loop through all auctions and if any belong to the auctioneer add it to the auctions list
	 */
	public void setAuctions(AllAuctions obj) {
		for (Auctions auction : obj.getAllAuctions()) {
			if (auction.getAuctioneer().equals(this)){
				auctions.add(auction);
			}
		}
	}
	

	public void addAuctions(Scanner in, AllAuctions obj) {
		System.out.println("Do you want to manually upload an auction? (Y or N)");
		String choice = in.next();
		if(choice.equals("Y")||choice.equals("y")) {
			manualAddition(in, obj);
		} else if(choice.equals("n")||choice.equals("N")) {
			System.out.println("Returning");
		} else {
			System.out.println("Incorrect Input");
		}
	}
	
	/*
	 * Writes to the Auctions.txt file when a new auctions is added
	 * STRING TO WRITE:
	 * obj.getItemName()+","+obj.getCategory()+","+obj.getStartingAmount()+","+obj.getCurrentBid()+","+obj.getHighestBidder()+","+obj.getAuctionStatus()+","+obj.getAuctioneer()
	 */
	private void writeToAuctions(Auctions obj) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Auctions.txt", true))) {
			String sb = new String();
			sb += "[";
			sb += obj.getItemName() + ",";
			sb += obj.getCategory() + ",";
			sb += obj.getStartingAmount() + ",";
			sb += obj.getCurrentBid() + ",";
			sb += obj.getHighestBidder() + ",";
			sb += obj.getStatus() + ",";
			sb += obj.getAuctioneer().getUsername();
			sb += "]";
			writer.write(sb);
			writer.newLine();
		} catch (Exception e) {
		}
	}
	
	/*
	 * Asks for the Name, category, and starting amount. 
	 * Create an auction object
	 * Add it to the all auctions list, call the writeToAuctions() method, and add it to auctioneers auction list
	 */
	private void manualAddition(Scanner in, AllAuctions allAuctionsObj) {
		//TODO
		System.out.println("Enter the name of the item: ");
		String name = in.nextLine();
		System.out.println("Enter the category of the item: ");
		String category = in.nextLine();
		System.out.println("Enter the starting amount: ");
		float startingAmount = in.nextFloat(); in.nextLine();
		Auctions auction = new Auctions(null, name, category, "Upcoming" , startingAmount, Float.NaN, null);
		allAuctionsObj.addAuction(auction);
		writeToAuctions(auction);
		auctions.add(auction);
	}
	
	/*
	 * Print the auctioneers auctions and ask which one they would like to start
	 * change the status to "In Progress"
	 */
	public void startAuction(Scanner in, AllAuctions obj) {
		//TODO
		printAuctions(obj);
		System.out.println("Enter the name of the auction item you want to start: ");
		String name = in.nextLine();
		for (Auctions auction : auctions) {
			if (auction.getItemName().equals(name)) {
				// Remove the auction from the AllAuctions object and remove it from the auctioneer's list to update the status
				obj.removeAuction(auction);
				auctions.remove(auction);
				// Set the auction status to "In Progress"
				auction.setStatus("In Progress");
				// Add teh auction back into the All Auctions object and the auctioneer's list
				obj.addAuction(auction);
				auctions.add(auction);
				System.out.println("Auction for " + name + " has been started.");
				break;
			}
		}
	}
	/*
	 * Print the auctioneers auctions and ask which one they would like to end
	 * change the status to "Completed"
	 */
	public void endAuction(Scanner in, AllAuctions obj) {
		printAuctions(obj);
		System.out.println("Enter the name of the auction item you want to end:");
		String name = in.nextLine();
		for (Auctions auction : auctions){
			if (auction.getItemName().equals(name)) {
				obj.removeAuction(auction);
				auction.setStatus("Completed");
				obj.addAuction(auction);
				System.out.println("Auction for " + name + " has been ended.");
				break;
			}
		}
	}
	
	public void printAuctions(AllAuctions obj) {
		obj.printAuctions(auctions);
	}

}
