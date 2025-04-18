package edu.odu.cs.cs251;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import edu.cs.odu.cs251.EventAction;
import edu.cs.odu.cs251.SimBuilder;
import edu.cs.odu.cs251.StateVariable;
import edu.cs.odu.cs251.exceptions.EventScheduleException;

public class Network {
	
	private static int nextNodeID = 0;
	private static int nextDroneID = 0;
	private ArrayList<Node> nodes;
	
	public Network() {
		nodes = new ArrayList<Node>();
	}
	
	public void initNetwork(Path config, int N) {
		try (Scanner scan = new Scanner(config)){
			int numNodes = scan.nextInt();
			System.out.printf("Creating %d nodes\n\n", numNodes);
			
			/// Assign initial queue sizes and number of servers
			System.out.println("Assigning initial state variables");
			for (int i = 0; i < numNodes; i++) {
				int numS;
				numS = scan.nextInt();
				
				System.out.printf("Node %d: S:%d\n", i, numS);
				nodes.add(new Node(numS));
			}
			
			/// Assign edge connections
			System.out.println("\nAssigning network connections");
			scan.next(); /// Trailing whitespace
			
			for (int i = 0; i < numNodes; i++) {
				System.out.printf("Node %d: ", i);
				try (Scanner line = new Scanner(scan.nextLine())){
					while (line.hasNext()) {
						int id = line.nextInt();
						System.out.printf("%d ", id);
						nodes.get(i).addEdge(id);
					}
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/// Schedule N arrive at random nodes
		
		for (int i = 0; i < N; i++) {
			try {
				SimBuilder.getInstance().scheduleEventAt(new Node.SourceEA(nodes.get(getDestination())), 0);
			} catch (EventScheduleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private int getDestination() {
		Random rand = new Random();
		
		return rand.nextInt(0, nodes.size());
	}
	
	private class Node {
		private int nodeID;
		private Queue<Drone> queue;
		public serverSV numServers;
		public ArrayList<Integer> neighbors;
		public queueSV numQ;
		
		public Node(int numServers) {
			this.nodeID = nextNodeID++;
			this.numServers = new serverSV(numServers);
			this.neighbors = new ArrayList<Integer>();
			this.queue = new LinkedList<Drone>();
			this.numQ = new queueSV(queue.size());
			
			SimBuilder.getInstance().addStateVariable(this.numQ);
			SimBuilder.getInstance().addStateVariable(this.numServers);
		}
		
		public int getNodeID() {
			return nodeID;
		}
		
		public void addEdge(int id) {
			neighbors.add(id);
		}
		
		private class queueSV implements StateVariable{
			
			public int Q;
			
			public queueSV (int Q) {
				this.Q = Q;
			}
			@Override
			public void Query() {
				System.out.printf("Time: %f\t\tNode %d:\t Q:%d\n", SimBuilder.getInstance().getSimTime(), Node.this.getNodeID(),Q );
			}
			
		}
		
		private class serverSV implements StateVariable {
			
			public int S;
			
			public serverSV(int S) {
				this.S = S;
			}
			
			@Override
			public void Query() {
				System.out.printf("Time: %f\t\tNode %d:\t S:%d\n", SimBuilder.getInstance().getSimTime(),Node.this.getNodeID(),S );
			}
			
		}
		
		
		public static class SourceEA implements EventAction{
			private Node node;
			
			public SourceEA(Node n) {
				this.node = n;
			}
			
			@Override
			public void Execute() {
				node.releaseDrone();
			}
			
		}
		
		public static class ArriveEA implements EventAction {
			private Node node;
			private Drone drone;
			
			public ArriveEA(Node n, Drone d) {
				this.node = n;
				this.drone = d;
			}
			@Override
			public void Execute() {
				node.arrive(drone);
			}
		}
		
		public static class StartServeEA implements EventAction {
			private Node node;
			
			public StartServeEA(Node n) {
				this.node = n;
			}
			
			@Override
			public void Execute() {
				node.startServe();
			}
		}
		
		public static class DoneServeEA implements EventAction {
			private Node node;
			private Drone drone;
			
			public DoneServeEA(Node n, Drone d) {
				this.node = n;
				this.drone = d;
				
			}
			
			@Override
			public void Execute() {
				node.doneServe(drone);
			}
		}
		
		private void releaseDrone() {
			Drone d = new Drone(nextDroneID++, getDestination());
			
			try {
				SimBuilder.getInstance().scheduleEventAt(new ArriveEA(this, d), SimBuilder.getInstance().getSimTime());
			} catch (EventScheduleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void arrive(Drone d) {
			queue.add(d);
			numQ.Q++;
			if (numServers.S > 0) {
				// Schedule start serve at current time
				try {
					SimBuilder.getInstance().scheduleEventAt(new StartServeEA(this), SimBuilder.getInstance().getSimTime());
				} catch (EventScheduleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		private void startServe() {
			Drone d = queue.poll();
			
			if (d == null) {
				System.err.println("Warning: Tried to Serve NULL Drone");
				return;
			}
			
			numQ.Q--;
			numServers.S--;
			// Schedule done serve at future time
			try {
				SimBuilder.getInstance().scheduleEventIn(new DoneServeEA(this, d), 5);
			} catch (EventScheduleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void doneServe(Drone d) { 
			numServers.S++;
			if (d.getDestination() == this.nodeID) {
				// Sink
				d = null;
				return;
			}
			
			else {
				// Schedule arrival at a connected node
				Random rand = new Random();			
				int nextNode = rand.nextInt(0, neighbors.size());				
				Node n = nodes.get(nextNode);
				try {
					SimBuilder.getInstance().scheduleEventAt(new ArriveEA(n, d) , SimBuilder.getInstance().getSimTime());
				} catch (EventScheduleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (!queue.isEmpty()) {
				// Schedule start serve at current time
				try {
					SimBuilder.getInstance().scheduleEventAt(new StartServeEA(this), SimBuilder.getInstance().getSimTime());
				} catch (EventScheduleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		@Override
		public String toString() {
			return String.format("Node %d: Q: %d S: %d", nodeID, numQ.Q, numServers.S);
		}
	}
}
