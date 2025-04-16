package users;

import com.odu.Accounts;
import java.util.Scanner;

public class Admin extends Users{
	
	public Admin(String username, String password) {
		//Uncomment once constructor for user is created
		//TODO
		super(username, password);
	}
	
	//ASKS FOR A USERNAME AND PASSWORD for a new auctioneer account. Call the addAccount method from the jar file
	public void createAuctioneer(Scanner in, Accounts obj) {
		//TODO
		System.out.println("Enter a username for the new auctioneer account: ");
		String user = in.nextLine();
		System.out.println("Enter a password for the new auctioneer account: ");
		String pass = in.nextLine();
		
		obj.addAccount(user, pass);
	}
}
