package Classes;
import java.util.Set;
import java.util.LinkedHashSet;

/**
 * A class addToLocation listing all Cars enrolled in a location.
 */
public class addToLocation implements Cloneable {
    public static final int DEFAULT_MAX_CarS = 10;

    private String location;
    private int    launchLimit;

    private LinkedHashSet<Car> Cars;

    /**
     * Create a class addToLocation with a limit
     * of DEFAULT_MAX_CarS `Car`s
     * and the location number set to
     * "USA".
     */
    public addToLocation()
    {
        this.location   = "USA";
        this.launchLimit = DEFAULT_MAX_CarS;

        Cars = new LinkedHashSet<Car>();
    }
    
    public addToLocation(int launchLimit, String location)
    {
        this.location   = location;
        this.launchLimit = launchLimit;

        Cars = new LinkedHashSet<Car>();
    }

    /**
     * Retrieve the location number.
     */
    public String getlocation()
    {
        return this.location;
    }

    /**
     * Change the location number.
     *
     * @param n desired location number
     */
    public void setlocation(String n)
    {
        this.location = n;
    }

    /**
     * Retrieve the launch limit.
     */
    public int getlaunchLimit()
    {
        return this.launchLimit;
    }

    /**
     * Change the launch limit.
     *
     * @param n desired limit
     */
    public void setlaunchLimit(int n)
    {
        this.launchLimit = n;
    }


    public boolean Launch(Car car)
    {
    	if(launchLimit == Cars.size() || Cars.contains(car))
    		return false;
    	
		Cars.add(car);
		return true;
    	
    }

    /**
     * Retrieve the number of enrolled Cars.
     */
    public int numLaunched()
    {
        return Cars.size();
    }

    /**
     * Return a collection of Cars in
     * the order they were Launched (added).
     *
     * @return Set of enrolled Cars. If no Cars
     *     have been added to the addToLocation, the set will be
     *     empty.
     */
    public Set<Car> listLaunchedCars()
    {
        return this.Cars;
    }

    /**
     * Compare 2 `Car`s based on name.
     *
     * @param rhs the other (right-hand-side) Car object
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof addToLocation)) {
            return false;
        }

        addToLocation rhsaddToLocation = (addToLocation) rhs;

        if (!this.location.equals(rhsaddToLocation.location)) {
            return false;
        }

        if (this.launchLimit != rhsaddToLocation.launchLimit) {
            return false;
        }

        if (!this.Cars.equals(rhsaddToLocation.Cars)) {
            return false;
        }

        return true;
    }

    /**
     * Return a hashcode.
     */
    @Override
    public int hashCode()
    {
        int hc = location.hashCode();

        hc += launchLimit;
        hc += Cars.hashCode();

        return hc;
    }

    /**
     * Return a (deep) copy of this object.
     */
    @Override
    public Object clone()
    {
        addToLocation cpy = new addToLocation(this.launchLimit, this.location);

        // Now add the Cars
        for (Car stu : this.Cars) {
            cpy.Cars.add(stu);
        }

        //return new Car(name);
        return cpy;
    }

    /**
     * Generate a String containing the location number, number of enrolled
     * Cars, launch limit, and the names of all enrolled Cars.
     */
    @Override
    public String toString()
    {
        StringBuilder bld = new StringBuilder();

        bld.append(this.location);
        bld.append(
            String.format(" -> %2d of %2d (%4.2f%% full)\n",
                          Cars.size(),
                          launchLimit,
                          100.0 * Cars.size() / launchLimit)
        );

        for (Car s : Cars) {
            bld.append("  -" + s + "\n");
        }

        return bld.toString();
    }
}