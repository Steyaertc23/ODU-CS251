
import java.util.HashMap;
import java.util.Scanner;

import exceptions.InsufficientFundsException;
import exceptions.InvalidUserException;
import exceptions.RequestedItemException;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.InputMismatchException;

public class Main
{
	static ArrayList<PrizeMachine> machines = new ArrayList<>();
	static HashMap<String, User> users = new HashMap<>();
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
    	PrizeStore store = PrizeStore.getInstance();
    	try {
			store.addPrizes(FileSystems.getDefault().getPath("data", "prizes.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        machines.add(new PrizeMachine(store));
        machines.add(new PrizeMachine(store));
        User u = new User("abcd", 0);
        
        User nonExistent = new User("Nines", 0);
        users.put(u.getUID(), u);

		try {
			RedeemTickets(u, machines.get(0),scan);
		} catch (InvalidUserException | RequestedItemException | InsufficientFundsException e) {
			e.printStackTrace();
		}  
		
		try {
			RedeemTickets(nonExistent, machines.get(1),scan);
		} catch (InvalidUserException | RequestedItemException | InsufficientFundsException e) {
			e.printStackTrace();
		}
		scan.close();
    }


    private static void RedeemTickets(User u, PrizeMachine p, Scanner scan) throws InvalidUserException, RequestedItemException,
    																			   InsufficientFundsException {
    	p.printPrizeStore();
    	try {
    		System.out.println("Choose something");
	    	int item = scan.nextInt();
	    	
	    	if (!users.containsValue(u)) {
//	    		System.out.printf("User %s does not exist\n", u.getUID());
	    		throw new InvalidUserException(u.getUID());
	    	}
	    	
	    	if (p.vendItem(item)) {	
	    		int diff = u.getTickets() - PrizeStore.getInstance().get(item).getValue();
	    		if (diff > 0) {
	    			u.setTickets(diff);
	    		}
	    		else {
//	    			System.out.println("Not enough tickets");
	    			throw new InsufficientFundsException(u.getTickets(), PrizeStore.getInstance().get(item).getValue());
	    		}
	    	}
	    	else {
//	    		System.out.println("No items");
	    		throw new RequestedItemException(PrizeStore.getInstance().get(item).getName());
	    	}
    	} catch (InputMismatchException e) {
			e.printStackTrace();
		}
    }
}
