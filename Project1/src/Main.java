
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		SeatingManagement manager = new SeatingManagement();
//		
//		manager.readSeatingFile();
//		
//		do {
//			System.out.println("1. Book a seat");
//			System.out.println("2. Cancel Reservation");
//			System.out.println("3. Find N adjacent available seats");
//			System.out.println("4. Save and Exit");
//			
//		} while (manager.menu());
		int [] seating = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		for (int i = 0; i <= seating.length; i++) {
			if (i == 0)
				System.out.print(i + " ");
			else if (i%10 == 0)
				
				System.out.print(i/10);
			else
				System.out.print(" ");
		}
		
		
	}

}
