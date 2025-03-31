 package edu.odu.cs.cs251.dungeoncrawler.core;

import java.util.Map;
import java.util.Random;

import edu.odu.cs.cs251.dungeoncrawler.entities.CombatEntity;
import edu.odu.cs.cs251.dungeoncrawler.entities.Player;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Instance {

	private Map<Integer, CombatEntity> entities;
	private List<Player> players;
	private int numEncounters;
	
	private class Encounter{
		List<CombatEntity> enemies;
		int encounterID;
		
		Encounter(int encounterID, int... entityIDs) {
			this.encounterID = encounterID;
			enemies = new ArrayList<CombatEntity>();
			for (int i : entityIDs) {
				enemies.add(entities.get(i));
 			}
		}
		
		void startEncounter() {
			System.out.println("Beginning encounter " + encounterID);

			PriorityQueue<CombatEntity> turnOrder = new PriorityQueue<CombatEntity>();

			for (CombatEntity e : enemies){
				turnOrder.add(e);
			}
			for (CombatEntity p : Instance.this.players) {
				turnOrder.add(p);
			}
			
			for (CombatEntity e : turnOrder) {
				System.out.println(e.getEntityID() + " " + e.getName());
			}
		}
		
		
	}
	
	public Instance(List<Player> players, int numEncounters, List<CombatEntity> entities) {
		this.players = players;
		this.numEncounters = numEncounters;
		this.entities = new HashMap<Integer, CombatEntity>();
		for (CombatEntity e : entities) {
			this.entities.put(e.getEntityID(), e);
		}
	}
	
	public void startInstance() {
		ArrayList<Encounter> encounters = new ArrayList<Encounter>();
		
		for (int i = 0; i < numEncounters; i++) {
			encounters.add(new Encounter(i, chooseRandomEntities(i+1)));
		}
		
		for (Encounter e : encounters) {
			e.startEncounter();
			resetEntities();
			resetPlayers();
		}
	}
	
	private int[] chooseRandomEntities(int numEntities) {
		
		int[] ids = new int[numEntities];
		var keys = entities.keySet().toArray();
		Random rand = new Random();
		for (int i = 0; i < numEntities; i++) {
			ids[i] = (int) keys[rand.nextInt(keys.length)];
		}
		
		return ids;
	}
	
	private void resetEntities() {
		for (var k : entities.keySet()) {
			entities.get(k).reset();
		}
	}

	private void resetPlayers(){
		for (Player p : players){
			p.reset();
		}
	}
}
