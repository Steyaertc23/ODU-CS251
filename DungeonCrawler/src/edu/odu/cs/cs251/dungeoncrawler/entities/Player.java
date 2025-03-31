package edu.odu.cs.cs251.dungeoncrawler.entities;
public class Player extends CombatEntity {


    public Player(int playerID, double health, double speed, double atkPower, double defPower, String name) {
        super(health, playerID, speed, atkPower, defPower, name);
    }

}
