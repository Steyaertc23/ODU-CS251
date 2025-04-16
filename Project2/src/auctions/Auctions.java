package auctions;

import java.time.LocalDateTime;
import users.Auctioneer;

public class Auctions {
	/*
	 * Initialize variables for the auction class. Refer to instructions. 
	 * Below is the date time object used. 
	 */
	public enum Status{
		INPROGRESS("In Progress"),
		UPCOMING("Upcoming"),
		COMPLETE("Completed"),
		UNKNOWN("Unknown");
		
		String status;
		
		Status(String status){
			this.status = status;
		}
		
	}
	
	private String name, category;
	private LocalDateTime timePosted; // The time it was posted 
	private Status status;
	private float startingAmount, currentBid;
	private String highestBidder;
	private Auctioneer auctioneer;
	

	/*
	 * Auctions created in two way:
	 * Previous auctions from a txt file or new auctions being created from an auctioneer.
	 * 
	 * This means that for auctionStatus, highestBidder, and timePosted needs a conditional statement. 
	 * See below for example
	 */
	public Auctions(LocalDateTime timePosted, String itemName, String category, String status, float startingAmount, 
					float currentBid, String highestBidder) {
		if(timePosted!=null) {this.timePosted = timePosted;}
		else {setPostedTime();}
		//FINISH THE CONSTRUCTOR
		//TODO
		if (itemName != null) {this.name = itemName;}
		if (status != null) {
			if (status.compareTo("Upcoming") == 0) {this.status = Status.UPCOMING;}
			else if (status.compareTo("In Progress") == 0) {this.status = Status.INPROGRESS;}
			else if (status.compareTo("Complete") == 0){this.status = Status.COMPLETE;}
			else {this.status = Status.UNKNOWN;}
		}
		else {this.status = Status.UNKNOWN;}
		if (highestBidder != null) {this.highestBidder = highestBidder;}
		if (category != null) {this.category = category;}
		if (startingAmount != Float.NaN) {this.startingAmount = startingAmount;}
		else {this.startingAmount = Float.NaN;}
		if (currentBid != Float.NaN) {this.currentBid = currentBid;}
		else {this.currentBid = startingAmount;}
	}
	
	//DO NOT EDIT, SETS THE TIME FOR A NEW AUCTION
	private void setPostedTime() {
		this.timePosted = LocalDateTime.now();
	}
	
	//CREATE SETTERS AND GETTERS
	//TODO
	//In your setter for current bid make sure to check that the current bid is smaller then the new bid being passed in
	
	public LocalDateTime getPostedTime() {
		return timePosted;
	}
	
	public void setStatus(String status) {
		if (status.compareTo("Upcoming") == 0) {this.status = Status.UPCOMING;}
		else if (status.compareTo("In Progress") == 0) {this.status = Status.INPROGRESS;}
		else if (status.compareTo("Complete") == 0){this.status = Status.COMPLETE;}
		else {this.status = Status.UNKNOWN;}
	}
	
	public Status getStatus() {
		return status;
	}
	
	public boolean setCurrentBid(Float bid) {
		if (currentBid < bid) { 
			currentBid = bid; 
			return true;
		}
		return false;
	}
	
	public float getCurrentBid() {
		return currentBid;
	}
	
	public void setHighestBidder(String bidder) {
		highestBidder = bidder;
	}
	
	public String getHighestBidder() {
		return highestBidder;
	}
	
	public void setItemName(String name) {
		this.name = name;
	}
	
	public String getItemName() {
		return name;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	public float getStartingAmount() {
		return startingAmount;
	}

	public void setStartingAmount(float startingAmount) {
		this.startingAmount = startingAmount;
	}
	
	public Auctioneer getAuctioneer() {
		return auctioneer;
	}
	
}
