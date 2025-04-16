package users;

import auctions.AllAuctions;
import auctions.Auctions;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Users{

	private float accountBalance;
	private ArrayList<Auctions> bids = new ArrayList<>();
	private ArrayList<Auctions> watchList = new ArrayList<>();
	
	public Customer(String username, String password, AllAuctions obj) {
		//Uncomment once constructor for user is created
		super(username, password);
		accountBalance = 0;
		generateBids(obj);
	}
	
	//CREATE SETTERS AND GETTERS

	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float balance) {
		this.accountBalance = balance;
	}

	public ArrayList<Auctions> getBids() {
		return bids;
	}

	public void setBids (ArrayList<Auctions> bids){
		this.bids = bids;
	}

	public ArrayList<Auctions> getWatchList() {
		return watchList;
	}

	public void setWatchList(ArrayList<Auctions> watchList) {
		this.watchList = watchList;
	}
	
	/*
	 * If AllAuctions arraylist is not null, store all auctions that belong to the user into bids arrayList
	 */
	private void generateBids(AllAuctions obj) {
		if (obj.getAllAuctions() != null) {
			for (Auctions auction : obj.getAllAuctions()) {
				if (auction.getHighestBidder().equals(this.getUsername())){
					bids.add(auction);
				}
			}
		}
	}
	
	/*
	 * Ask how much they want to add to the account. Add that amount to account.
	 */
	public void addToAccountBalance(Scanner in) {
		System.out.println("How much do you want to add to the account?");
		float amount = in.nextFloat();
		if (amount > 0) {
			accountBalance += amount;
			System.out.println("Account balance is now: " + accountBalance);
		}
		else {
			System.out.println("Invalid amount. Please enter a positive number.");
		}
	}
	
	
	private void subtractFromAccountBalance(float subtraction) {
		accountBalance = accountBalance-subtraction;
	}
	
	/*
	 * This method is called when a bid is made. It credits the previous top bidder with the amount that they bidded.
	 */
	private void addAfterFailedBid(float addition, String previousTopBidder, ArrayList<Customer> customers) {
		for (Customer c : customers) {
			if (c.getUsername().equals(previousTopBidder)) {
				c.accountBalance += addition;
				break;
			}
		}
	}
	
	
	private void addToWatchList(Auctions obj) {
		if (obj.getStatus() == Auctions.Status.COMPLETE || obj.getStatus() == Auctions.Status.UPCOMING) {
			watchList.add(obj);
		}
	}
	private void removeFromWatchList(Auctions obj) {
		watchList.remove(obj);
	}
	
	public void printBids(AllAuctions obj) {
		obj.printAuctions(bids);
	}

	public void printWatchList(AllAuctions obj) {
		obj.printAuctions(watchList);
	}
	
	/*
	 * Used as the driver to make bids. Prints all the auctions, asks which auction they want to bid on and how much.
	 * Create a auction object of the selected auction 
	 * Check if the bid is valid. 
	 * If it is call the following methods [addAfterFailedBid() from this class,setCurrentBid() for the Auction Class, and subtractFromAccountBalance() from this class]
	 * Add it to the customers bids list
	 */

	public void makeBid(Scanner in, AllAuctions obj, ArrayList<Customer> customers) {
		obj.printAuctions(obj.getAllAuctions());
		System.out.println("Which auction do you want to bid on? (Enter the number)");
		int choice = in.nextInt();
		if (choice < 0 || choice > obj.getAllAuctions().size()-1) {
			System.out.println("Invalid Choice. Please try again");
			return;
		}
		Auctions auction = obj.getAllAuctions().get(choice);
		if (auction.getStatus() == Auctions.Status.COMPLETE || auction.getStatus() == Auctions.Status.UPCOMING || auction.getStatus() == Auctions.Status.UNKNOWN){
			System.out.println("This auction is not open for bidding.");
			return;
		}
		System.out.println("How much do you want to bid?");
		float bid = in.nextFloat();

		if (bid <= auction.getCurrentBid()) {
			System.out.println("Invalid bid. Please enter a higher amount.");
			return;
		}
		if (bid > accountBalance) {
			System.out.println("Insufficient funds. Please add money to your account.");
			return;
		}
		if(auction.getHighestBidder() != null) {
			addAfterFailedBid(auction.getCurrentBid(), auction.getHighestBidder(), customers);
		}
		auction.setCurrentBid(bid);
		auction.setHighestBidder(this.getUsername());
		subtractFromAccountBalance(bid);
		bids.add(auction);
		System.out.println("Bid placed successfully!");
		System.out.println("Your current balance is: " + accountBalance);

	}
	
	/*
	 * Used as the driver to add and delete auctions from watch list. 
	 * Ask if the customer wants to add or remove from watch list.
	 * IF ADDING
	 * 	Print All the Auctions and ask which one the want to add.
	 * 	add that auction to watchlist with addToWatchList()
	 * IF removing
	 * 	Print Watch List and ask which one they want to remove
	 *  Remove it from the watchlist with removeFromWatchList()
	 */
	public void controlWatchList(AllAuctions obj, Scanner in) {
		
		System.out.println("Do you want to add or remove from the watch list? [A(dd) or R(emove)]");
		String choice = in.nextLine();
            switch (choice) {
                case "A", "a" -> {
                    obj.printAuctions(obj.getAllAuctions());
                    System.out.println("Which auction do you want to add to the watch list? (Enter the number)");
                    int auctionChoice = in.nextInt();
                    in.nextLine();
                    if (auctionChoice < 0 || auctionChoice > obj.getAllAuctions().size()-1) {
                        System.out.println("Invalid Choice. Please try again.");
                        return;
                    }
                    Auctions auction = obj.getAllAuctions().get(auctionChoice);
                    if (auction.getStatus() == Auctions.Status.COMPLETE || auction.getStatus() == Auctions.Status.UNKNOWN) {
                        System.out.println("This auction is not open for bidding in the future. ");
                        return;
                    }
                    addToWatchList(auction);
                    System.out.println("Auction added to watch list.");
                }
                case "R", "r" -> {
                    printWatchList(obj);
                    System.out.println("Which auction do you want to remove from the watch list? (Enter the number)");
                    int auctionChoice = in.nextInt();
                    in.nextLine();
                    if (auctionChoice < 0 || auctionChoice > obj.getAllAuctions().size()-1) {
                        System.out.println("Invalid Choice. Please try again.");
                        return;
                    }
                    removeFromWatchList(watchList.get(auctionChoice));
                    System.out.println("Auction has been removed from the watch list");
				}
                default -> System.out.println("Invalid choice, please try again.");
            }

	}
}
