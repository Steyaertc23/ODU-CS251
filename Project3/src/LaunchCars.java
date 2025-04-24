import Classes.Car;
import Classes.addToLocation;

/**
 * Demonstrate simple addToLocation and Car ADTs.
 */
class LaunchCars {
    /**
     * This is a non-trivial main function.
     *
     * @param args not used in this program
     */
    public static void main(String[] args)
    {
    	//Initializing the car company to car agency by creating an instance of Car class.
        Car BMW  = new Car("BMW");
        Car Mercedes   = new Car("Mercedes");
        Car Ferrari   = new Car("Ferrari");
        Car Porsche = new Car("Porsche");

        Car[] allCars = {BMW, Mercedes, Ferrari, Porsche};
        
        addToLocation carCollection = new addToLocation(4, "Europe");
        
        for (Car c : allCars) {
        	boolean launched = carCollection.Launch(c);
        	if (launched)
        		System.out.println(c + " launched in" + carCollection.getlocation() + "by A-One Car Agency");
        	else
        		System.out.println("Unable to launch " + c);
        }
        carCollection.toString();
        

        

        System.out.println();

    }
}