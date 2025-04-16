package auctions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class AllAuctions {
	
	private  ArrayList<Auctions> allAuctions = new ArrayList<>();
	
	public AllAuctions() {
		setAllAuctions();
	}
	
	/*
	 * Create Auctions.txt if it does not already exist. Can use new File("Auctions.txt").createNewFile();
	 * Read auctions line by line from the file and store them into allAuctions ArrayList.
	 * 
	 */
	private void setAllAuctions() {
		File auctions = new File("Auctions.txt");
		boolean fileExists = auctions.exists();
		if (!fileExists){
            try {
                auctions.createNewFile();
			} 
			catch (IOException ex) {
            }
		}
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		try(Scanner scanner = new Scanner(System.in);) {
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				line = line.replace("[","").replace("]","");
				String[] info = line.split(",");

				if (!fileExists){
					Auctions auction = new Auctions(null, null, null, null, Float.NaN, Float.NaN, null);
					allAuctions.add(auction);
				}
				else{
					try {
						LocalDateTime time = LocalDateTime.parse(info[0], formatter);
						Auctions auction = new Auctions(time, info[1], info[2], info[3], Float.parseFloat(info[4]), 
													Float.parseFloat(info[5]), info[6]);
						allAuctions.add(auction);
					} catch (DateTimeParseException e) {
						 System.err.println("Error parsing datetime string: " + e.getMessage());
					}
					
				}
			}
		} catch(Exception e) {
		}

	}
	
	//Create getter for allAuctions
	//TODO
	
	public void addAuction(Auctions obj) {
		allAuctions.add(obj);
	}

	public void removeAuction(Auctions obj) {
		allAuctions.remove(obj);
	}
	
	public ArrayList<Auctions> getAllAuctions() {
		return allAuctions;
	}
	
	/*
	 * Takes in an ArrayList of Auctions, prints the auctions in format shown in instructions
	 */
	public void printAuctions(ArrayList<Auctions> obj) {
		String sb = new String();
		if(allAuctions == null) {
			System.out.println("No auctions!");
			return;
		}
		sb += "|     |Status     |Item Name      |Category       |Current Bid|Top Bidder     |";
		sb += "\n------|-----------|---------------|---------------|-----------|----------------\n";
		
		for (int i = 0; i < obj.size(); i++) {
			Auctions auction = obj.get(i);
			sb += "|" + String.valueOf(i+1);
			for (int j = 0; j < 5-String.valueOf(i+1).length(); j++){
				sb += " ";
			}
			sb += "|" + auction.getStatus();
			for (int j = 0; j < 11-auction.getStatus().toString().length();j++){
				sb += " ";
			}
			sb += "|" + auction.getItemName();
			for (int j = 0; j < 15-auction.getItemName().length(); j++){
				sb += " ";
			}
			sb += "|" + auction.getCategory();
			for(int j = 0; j < 15-auction.getCategory().length(); j++){
				sb += " ";
			}
			sb += "|" + auction.getCurrentBid();
			for (int j = 0; j < 11-String.valueOf(auction.getCurrentBid()).length(); j++){
				sb +=" ";
			}
			sb += "|" + auction.getHighestBidder();
			for (int j = 0; j < 15-auction.getHighestBidder().length(); j++){
				sb += " ";
			}
			sb += "|\n";
		}
		
		sb += "------|-----------|---------------|---------------|-----------|----------------|\n";
		
		System.out.println(sb);
		
	}
	
	public void printFilteredAuctions(Scanner in, ArrayList<Auctions> obj) {
		ArrayList<Auctions> filteredAuctions = new ArrayList<>();
		if(allAuctions == null) {
			System.out.println("No auctions!");
			return;
		}
		System.out.println("What Category Do you want to filter");
		System.out.print("\nAppliances\tClothing\tElectronics"
				+"\nFurniture\tToys");
		
		String choice = in.next(); in.nextLine();

		for(Auctions x : obj) {
			if (x.getCategory().equals(choice)) {
				filteredAuctions.add(x);
			}
		}
		
		printAuctions(filteredAuctions);
	}
	
}
