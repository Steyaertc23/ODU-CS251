package edu.odu.cs.cs251;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Transmitter> transmitters;
	private static ArrayList<Receiver> receivers;
	
	public static void main(String[] args) {
		transmitters = new ArrayList<>();
		receivers = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		int choice;
		do {
			choice = Integer.parseInt(menu(scan));
			
			switch (choice) {
			case 1:
				createTransmitter(scan);
				break;
			case 2:
				createReceiver(scan);
				break;
			case 3:
				transmitMessage(scan);
				break;
			case 4:
				checkReceiverStatus(scan);
				break;
			case 5:
			default:
				break;
			}
		} while (choice != 5);
		
		scan.close();
	}
	
	public static String printTransmittersWithMenu(Scanner scan) {
		System.out.println("Choose a transmitter");
		for (int i = 0; i < transmitters.size(); i++) {
			System.out.printf("%d) %s\n", i, transmitters.get(i).getID());
		}
		return scan.nextLine();
	}
	
	public static String printReceiversWithMenu(Scanner scan) {
		System.out.println("Choose a receiver");
		for (int i = 0; i < receivers.size(); i++) {
			System.out.printf("%d) %s\n", i, receivers.get(i).getID());
		}
		return scan.nextLine();
	}
	
	public static String menu(Scanner scan) {
		System.out.println("Choose an option");
		System.out.println("1) Create a transmitter");
		System.out.println("2) Create a receiver");
		System.out.println("3) Transmit a message");
		System.out.println("4) Check receiver status");
		System.out.println("5) Exit");
		return scan.nextLine();
	}
	
	public static void createTransmitter(Scanner scan) {
		System.out.println("Enter transmitter ID");
		String id = scan.nextLine();
		
		System.out.println("Enter the x-coordinate of the transmitter");
		int x = scan.nextInt();
		
		System.out.println("Enter the y-coordinate of the transmitter");
		int y = scan.nextInt();
		
		System.out.println("Enter the effective range of the transmitter");
		double effectiveRange = scan.nextDouble();
		
		transmitters.add(new Transmitter(id, x, y, effectiveRange));
		scan.nextLine(); // trash any trailing newline
	}
	
	public static void createReceiver(Scanner scan) {
		System.out.println("Enter receiver ID");
		String id = scan.nextLine();
		
		System.out.println("Enter the x-coordinate of the receiver");
		int x = scan.nextInt();
		
		System.out.println("Enter the y-coordinate of the receiver");
		int y = scan.nextInt();
		
		receivers.add(new Receiver(id, x, y));
		scan.nextLine(); // trash any trailing newline
	}
	
	public static void transmitMessage(Scanner scan) {
		System.out.println("Enter your message");
		String message = scan.nextLine();
		
		System.out.println("Enter the priority of your message (0: NORMAL or 1: URGENT");
		int pri = scan.nextInt();
		
		scan.nextLine();
		System.out.println("Which transmitter do you want to use?");
		
		int idx = Integer.parseInt(printTransmittersWithMenu(scan));
		
		Transmitter t = transmitters.get(idx);
		for (Receiver r : receivers) {
			if (pri == 0) {
				t.transmitNormal(r, message);
			}
			else {
				t.transmitUrgent(r, message);
			}
		}
	}
	
	public static void checkReceiverStatus(Scanner scan) {
		int idx = Integer.parseInt(printReceiversWithMenu(scan));
		
		System.out.println(receivers.get(idx));
	}
}
