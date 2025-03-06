package labThirteen;

import interfaces.InAtmosphereShip;
import interfaces.Interplanetary;
import interfaces.Interstellar;
import interfaces.Lander;
import interfaces.Spaceship;
import locations.Planet;
import locations.SolarSystem;
import ships.CorvegaShip;
import ships.ZhuShip;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interstellar starFighter = new Executor();
		Interplanetary tieFighter = new TieFighter();
		Lander corvega = new CorvegaShip();
		Spaceship zhu = new ZhuShip();
		InAtmosphereShip ship = new ZhuShip();
		
		// Spaceship
		zhu.move();
		
		// Lander
		corvega.move();
		corvega.land();
		
		// InAtmosphereShip
		ship.takeOff();
		ship.move();
		
		// Interplanetary
		tieFighter.move();
		tieFighter.jump(new Planet("Tatooine"));
		
		//Interstellar
		starFighter.move();
		starFighter.jump(new Planet("Coruscant"));
		starFighter.jump(new SolarSystem("Yavin"));
		
	}

}
