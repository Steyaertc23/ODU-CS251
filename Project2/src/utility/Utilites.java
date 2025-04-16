package utility;

import auctions.AllAuctions;
import auctions.Auctions;
import com.odu.Accounts;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import users.Auctioneer;
import users.Customer;

public class Utilites {
	

	 private Accounts customers;
	 private Accounts auctioneers;
	 private Accounts admin;

	
	
	private AllAuctions all;
	private ArrayList<Customer> customerList;
	private ArrayList<Auctioneer> auctioneerList;
	
	/*
	 * Create all the menu methods, refer to the instructions to see specifics
	 */
	
	public Utilites() {
//		System.out.println("Initializing Accounts");
		customers = new Accounts("C");
//		System.out.println("Initialized customers");
		auctioneers = new Accounts("A");
//		System.out.println("Initialized auctioneers");
		admin = new Accounts("ADMIN");
//		System.out.println("Initialized admin");
		all = new AllAuctions();
//		System.out.println("Initialized all autions");
		customerList = new ArrayList<>();
		auctioneerList = new ArrayList<>();
//		System.out.println("Finished initialization");
		System.out.flush();
	}
	
	public void viewMainMenu() {
//		System.out.println("Good");
		Scanner in = new Scanner(System.in);

		String sb = new String();
		sb += "1. Create User";
		sb += "\n2. Sign In";
		sb += "\n3. Quit";
		System.out.println(sb);
		do{
			
			
			String input = in.nextLine().trim();

		    int choice;
		    
		    try {
		        choice = Integer.parseInt(input);
		    } catch (NumberFormatException e) {
		        System.out.println("Invalid input. Please enter a number.");
		        continue;
		    }

			switch(choice){
				case 1 -> customerAccountCreation(in);
				case 2 -> login(in);
				case 3 -> {
					writeToAuctions();
					System.out.println("Quitting");
					in.close();
					
					LocalTime currentTime = LocalTime.now();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			        String time = currentTime.format(formatter);
					
					System.out.println("\nCompleted execution at " + time);
					return;
				}
				default -> System.out.println("Invalid Input");
			}
		}while (true);
		
		
	}
	
	
	private void viewCustomerMenu(String username, String password, Scanner in) {
		//TODO
		//MAKE SURE TO ADD THE CUSTOMER TO THE customerList if the first time being signed in
		Customer customer = new Customer(username, password, all);
		boolean found = false;
		for (Customer c : customerList) {
			if(c.getUsername().equals(username)) {customer = c; found = true; break;}
		}
		if (!found) {
			customerList.add(customer);
		}

		System.out.println("Hello Customer " + username + "!");
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to the menu, What do you want to do?\n");
		sb.append("1. View all auctions    2. Filter Auctions\n")
		  .append("3. View watch list      4. Add/Remove from Watch List\n")
		  .append("5. View your bids       6. Make a bid\n")
		  .append("7. View your balance    8. Add to balance\n")
		  .append("9. Sign out");
		
		while (true){
			System.out.println(sb.toString());
			int choice = in.nextInt(); in.nextLine();
			switch(choice){
				case 1 -> all.printAuctions(all.getAllAuctions());
				case 2 -> all.printFilteredAuctions(in, all.getAllAuctions());
				case 3 -> customer.printWatchList(all);
				case 4 -> customer.controlWatchList(all, in);
				case 5 -> customer.printBids(all);
				case 6 -> customer.makeBid(in, all, customerList);
				case 7 -> System.out.println("Your current balance is: $" + customer.getAccountBalance());
				case 8 -> customer.addToAccountBalance(in);
				case 9 -> {
					System.out.println("Signing out...");
					return;
				}
				default -> System.out.println("Invalid Input");
			}
		}

	}
	
	private void viewAdminMenu(String username, Scanner in) {
		System.out.println("Hello Admin " + username + "!");
		System.out.println("Would you like to create an auctioneer? [Y/N]");
		String choice = in.nextLine();
		if (choice.equalsIgnoreCase("y")){
			System.out.println("Please enter the username for the auctioneer:");
			String auctioneerUsername = in.nextLine();
			System.out.println("Please enter the password for the auctioneer:");
			String auctioneerPassword = in.nextLine();

			auctioneers.addAccount(auctioneerUsername, auctioneerPassword);
			return;
		}

		else if (choice.equalsIgnoreCase("n")){
			System.out.println("Returning to main menu...");
			return;
		}
		System.out.println("Invalid input, returning to main menu...");
	}
	
	private void viewAuctioneerMenu(String username, String password, Scanner in) {
		//TODO
		//MAKE SURE TO ADD THE CUSTOMER TO THE auctioneerList if the first time being signed in
		Auctioneer auctioneer = new Auctioneer(username, password, all);
		boolean found = false;
		for (Auctioneer a : auctioneerList) {
			if (a.getUsername().equals(username)) {auctioneer = a; found = true; break;}
		}
		if (!found) {
			auctioneerList.add(auctioneer);
		}

		System.out.println("Hello Auctioneer " + username + "!");

		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to the menu, What do you want to do?\n");
		sb.append("1. Create an Auction    2. View your Auctions\n")
	      .append("3. Start an Auction     4. End an Auction\n")
		  .append("5. Sign Out");

		while (true){
			System.out.println(sb.toString());
			int choice = in.nextInt(); in.nextLine();

			switch (choice) {
				case 1 -> auctioneer.addAuctions(in, all);
				case 2 -> auctioneer.printAuctions(all);
				case 3 -> auctioneer.startAuction(in, all);
				case 4 -> auctioneer.endAuction(in, all);
				case 5 -> {
					System.out.println("Signing out....");
					return;
				}
				default -> System.out.println("Invalid Input");
			}
			
		}
	}
	
	
	private void login(Scanner in) {
		boolean active = true;
		String userType;
		while(active == true) {
			System.out.println("What type of account are you logging into: C(customer), A(auctioneer), ADMIN");
			in.nextLine();
			userType = in.nextLine();
			if(userType.equals("C") || userType.equals("A") || userType.equals("ADMIN")) {
				signIn(in, userType);
				break;
			} 
			else{
				System.out.println("Incorrect Input");
			}
		}
		
	}
	
	/*
	 * Ask for the username and password. 
	 * Depending on the type of user passed in test it against either customer.signIn(), auctioneers.signIn(), or admin.signIn()
	 * If true call the correct user menu method.
	 */
	private void signIn(Scanner in, String userType) {
		System.out.println("Please enter your username:");
		String username = in.nextLine();
		System.out.println("Please enter your password:");
		String password = in.nextLine();
		switch (userType) {
			case "C" -> {
                            if (customers.signIn(username, password)) {
                                viewCustomerMenu(username, password, in);
                            }
                 }
			case "A" -> {
                            if (auctioneers.signIn(username, password)) {
                                viewAuctioneerMenu(username, password, in);
                            }
                 }
			case "ADMIN" -> {
                            if (admin.signIn(username, password)) {
                                viewAdminMenu(username, in);
                            }
                 }
			default -> {
                 }
		}
	}
	
	/*
	 * Ask for a username and password.
	 * call the addAccount method from the jar file for customers
	 */
	private void customerAccountCreation(Scanner in) {
		System.out.println("Please enter your username:");
		String username = in.nextLine();
		System.out.println("Please enter your password:");
		String password = in.nextLine();
		customers.addAccount(username, password);
	}
	
	/*
	 * Gets called at the end of main menu.
	 * Write over the Auction.txt file with the current state of all auctions list
	 * String per line: x.getItemName()+","+x.getCategory()+","+x.getPostedTime()+","+x.getStartingAmount()+","+x.getCurrentBid()+","+x.getHighestBidder()+","+x.getAuctionStatus()+","+x.getAuctioneer()
	 */
	private void writeToAuctions() {
		//TODO
		StringBuilder sb = new StringBuilder();
		for(Auctions auction : all.getAllAuctions()){
			sb.append("[");
			sb.append(auction.getItemName()).append(",")
				.append(auction.getCategory()).append(",")
				.append(auction.getStartingAmount()).append(",")
				.append(auction.getCurrentBid()).append(",")
				.append(auction.getHighestBidder()).append(",")
				.append(auction.getStatus()).append(",")
				.append(auction.getAuctioneer().getUsername());
			sb.append("]\n");
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Auctions.txt"))){
			writer.write(sb.toString());
			writer.flush();
		} catch (IOException ex) {
			System.out.println("Error writing to Auctions.txt");
		}
		
	}
}
