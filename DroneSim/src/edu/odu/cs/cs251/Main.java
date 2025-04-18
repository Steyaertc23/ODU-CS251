package edu.odu.cs.cs251;

import java.nio.file.FileSystems;

import edu.cs.odu.cs251.SimBuilder;
import edu.cs.odu.cs251.exceptions.TimeMismatchException;

public class Main {

	public static void main(String[] args) {
		SimBuilder builder = SimBuilder.getInstance();
		
		Network network = new Network();
		network.initNetwork(FileSystems.getDefault().getPath("src", "data","network0.dat"), 5);
		
		System.out.println("Running simulation");
		try {
			builder.runSimulation(500);
		} catch (TimeMismatchException e) {
			e.printStackTrace();
			return;
		}
		System.out.printf("Simulation ended at: %f", builder.getSimTime());
	}

}
