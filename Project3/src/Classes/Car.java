package Classes;
public class Car implements Cloneable {
    /**
     * Constant defining the default Car name.
     */
    public static final String DEFAULT_NAME = "British Motor Works";

    private String name;

    /**
     * Create a Car with the default name
     * of British Motor Works.
     */
    public Car()
    {
        this.name = DEFAULT_NAME;
    }
    
    public Car(String name)
    {
        this.name = name;
    }

    
    /**
     * Get the Name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Change the Car name.
     *
     * @param n desired name
     */
    public void setName(String n)
    {
        name = n;
    }

    /**
     * Compare 2 `Car`s based on name.
     *
     * @param rhs the other (right-hand-side) Car object
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Car)) {
            return false;
        }

        return (this.name).equals(((Car) rhs).name);
    }

    /**
     * Return a hashcode.
     */
    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    /**
     * Return a (deep) copy of this object.
     */
    @Override
    public Object clone()
    {
        return new Car(name);
    }

    @Override
    public String toString()
    {
        return name;
    }
}