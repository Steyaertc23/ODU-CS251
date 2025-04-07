
public class StarDestroyer implements Interstellar_v2 {

	public StarDestroyer() {}
	
	@Override
	public void jump(Planet p) {
		// TODO Auto-generated method stub
		System.out.println("StarDestroyer jumps to " + p.name);
	}

	@Override
	public void jump(SolarSystem s) {
		// TODO Auto-generated method stub
		System.out.println("StarDestroyer jumps to " + s.name);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("StarDestroyer moves");
	}

	@Override
	public boolean checkStatus(int limit) {
		// TODO Auto-generated method stub
		if (limit < 100) {
			return true;
		}
		return false;
	}
}
