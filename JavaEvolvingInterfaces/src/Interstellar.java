
public interface Interstellar extends Interplanetary{
	void jump(SolarSystem s);
	default boolean chargeImpulse(int charge) {
		return (charge > 9);
	}
}
