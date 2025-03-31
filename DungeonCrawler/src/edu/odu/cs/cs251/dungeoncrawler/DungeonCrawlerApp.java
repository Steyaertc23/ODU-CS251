package edu.odu.cs.cs251.dungeoncrawler; 

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.odu.cs.cs251.dungeoncrawler.core.Instance;
import edu.odu.cs.cs251.dungeoncrawler.entities.CombatEntity;
import edu.odu.cs.cs251.dungeoncrawler.entities.Enemy;
import edu.odu.cs.cs251.dungeoncrawler.entities.Player;


public class DungeonCrawlerApp {

	public static void main(String[] args) {
		// TODO 


		List<CombatEntity> enemies = new ArrayList<CombatEntity>();
		List<Player> players = new ArrayList<Player>();

		players.add( new Player(0, 100, 8, 10, 10, "Hy"));
		players.add ( new Player(1, 100, 3, 20, 5, "Vy"));


		Path enemyData = FileSystems.getDefault().getPath("data","enemies.txt");

		try (Scanner scan = new Scanner(enemyData)){
			enemies.add( new Enemy(scan.nextInt(), scan.nextDouble(), scan.nextDouble(), scan.nextDouble(), scan.nextDouble(), scan.nextLine()));
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		Instance i1 = new Instance(players, 3, enemies);
		
		i1.startInstance();

	}

}
