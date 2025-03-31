package edu.odu.cs.cs251.dungeoncrawler.entities;
public class Enemy extends CombatEntity {

    public Enemy(int playerID, double health, double speed, double atkPower, double defPower, String name) {
        super(health, playerID, speed, atkPower, defPower, name);
    }


}
