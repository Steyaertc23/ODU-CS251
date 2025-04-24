package Tests;

import Classes.Car;
import Classes.addToLocation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.IsSame;

/**
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 *
 * 1 Test per mutator
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestaddToLocation {
    // Cars - will not be changed during tests
    Car BMW  = new Car("BMW");
    Car Mercedes   = new Car("Mercedes");
    Car Ferrari   = new Car("Ferrari");
    Car Porsche = new Car("Porsche");

    // Car "lists" - will not be changed during tests
    Car[] firstThreeCars = {BMW, Mercedes, Ferrari};
    Car[] allCars        = {BMW, Mercedes, Ferrari, Porsche};

    // Course addToLocations - will possibly change in each test
    addToLocation defaultCar;
    addToLocation emptyCanada;

    @BeforeEach
    public void setUp()
    {
    	defaultCar = new addToLocation();
        emptyCanada    = new addToLocation(3, "Canada");
    }

    @Test
    public void testDefaultConstructor()
    {
        assertThat(defaultCar.getlocation(), equalTo("USA"));
        assertThat(defaultCar.getlaunchLimit(),
                   equalTo(addToLocation.DEFAULT_MAX_CarS));

        assertThat(defaultCar.numLaunched(), equalTo(0));

        // No Cars have been added
        assertThat(defaultCar.listLaunchedCars(), notNullValue());
        assertThat(defaultCar.listLaunchedCars().size(), equalTo(0));

        // Test equals
        addToLocation anotherDefault = new addToLocation();
        assertThat(defaultCar, equalTo(anotherDefault));

        // Test hashCode
        assertThat(defaultCar.hashCode(), equalTo(anotherDefault.hashCode()));

        // test toString
        assertThat(defaultCar.toString(), containsString("USA"));
        assertThat(defaultCar.toString(),
                   containsString(Integer.toString(defaultCar.numLaunched())));
        assertThat(defaultCar.toString(),
                   containsString(Integer.toString(addToLocation.DEFAULT_MAX_CarS)));
    }

    @Test
    public void testNonDefaultConstructor()
    {
    	assertThat(emptyCanada.getlocation(), equalTo("Canada"));
        assertThat(emptyCanada.getlaunchLimit(),
                   equalTo(3));

        assertThat(emptyCanada.numLaunched(), equalTo(0));

        // No Cars have been added
        assertThat(emptyCanada.listLaunchedCars(), notNullValue());
        assertThat(emptyCanada.listLaunchedCars().size(), equalTo(0));

        // Test equals
        addToLocation anotherCanada = new addToLocation(3, "Canada");
        assertThat(emptyCanada, equalTo(anotherCanada));

        // Test hashCode
        assertThat(emptyCanada.hashCode(), equalTo(anotherCanada.hashCode()));

        // test toString
        assertThat(emptyCanada.toString(), containsString("Canada"));
        assertThat(emptyCanada.toString(),
                   containsString(Integer.toString(emptyCanada.numLaunched())));
        assertThat(emptyCanada.toString(),
                   containsString(Integer.toString(3)));
    }

    @Test
    public void testSetlocation()
    {
        addToLocation Germany = new addToLocation();

        int oldHashCode = Germany.hashCode();

        Germany.setlocation("Germany");

        assertThat(Germany.getlocation(), equalTo("Germany"));
        assertThat(Germany.getlaunchLimit(),
                   equalTo(addToLocation.DEFAULT_MAX_CarS));

        assertThat(defaultCar.numLaunched(), equalTo(0));

        // No Cars have been added
        assertThat(Germany.listLaunchedCars(), notNullValue());
        assertThat(Germany.listLaunchedCars().size(), equalTo(0));

        // NOT skipping hashcode
        assertThat(Germany.hashCode(), not(equalTo(oldHashCode)));
        // NOT skipping equals
        assertThat(Germany, not(equalTo(defaultCar)));

        // test toString
        assertThat(Germany.toString(), containsString("Germany"));
        assertThat(Germany.toString(),
                   containsString(Integer.toString(Germany.numLaunched()))); // fixed mistake
        assertThat(Germany.toString(),
                   containsString(Integer.toString(addToLocation.DEFAULT_MAX_CarS)));
    }

    @Test
    public void testSetLaunchLimit()
    {
        emptyCanada.setlaunchLimit(2);

        assertThat(emptyCanada.getlocation(), equalTo("Canada"));
        assertThat(emptyCanada.getlaunchLimit(), equalTo(2));

        assertThat(defaultCar.numLaunched(), equalTo(0));

        // No Cars have been added
        assertThat(emptyCanada.listLaunchedCars(), notNullValue());
        assertThat(emptyCanada.listLaunchedCars().size(), equalTo(0));

        // NOT skipping hashcode
        assertThat(emptyCanada.hashCode(), not(equalTo(defaultCar.hashCode())));
        // NOT skipping equals
        assertThat(emptyCanada, not(equalTo(defaultCar)));

        // test toString
        assertThat(emptyCanada.toString(), containsString("Canada"));
        assertThat(emptyCanada.toString(),
                   containsString(Integer.toString(emptyCanada.numLaunched())));
        assertThat(emptyCanada.toString(), containsString(Integer.toString(2)));
    }

    @Test
    public void testLaunch()
    {
        //This is where the fun starts
        addToLocation India = new addToLocation(3, "India");

        int oldHashCode = India.hashCode();

        // try to add 4 Cars
        assertThat(India.Launch(BMW), is(true));
        assertThat(India.Launch(Mercedes), is(true));
        assertThat(India.Launch(Ferrari), is(true));
        assertThat(India.Launch(Porsche), is(false)); // should fail (limit of 3)

        assertThat(India.getlocation(), equalTo("India"));
        assertThat(India.getlaunchLimit(), equalTo(3));
        assertThat(India.numLaunched(), equalTo(3)); // fixed mistake

        // 3 Cars have been added
        assertThat(India.listLaunchedCars(), notNullValue());
        assertThat(India.listLaunchedCars().size(), equalTo(3));
        assertThat(India.listLaunchedCars().toArray(),
                   equalTo(firstThreeCars));

        assertThat(India.hashCode(), not(equalTo(oldHashCode)));

        oldHashCode = India.hashCode();

        // Change the limit to 4
        India.setlaunchLimit(4); // mistake - this should be India
        assertThat(India.getlaunchLimit(), equalTo(4)); // mistake - this should be India

        // try to add a 4th Car with the new limit of 4
        assertThat(India.Launch(Porsche), is(true)); // should succeed (limit of 4)

        // 4 Cars have been added
        assertThat(India.listLaunchedCars(), notNullValue());
        assertThat(India.listLaunchedCars().size(), equalTo(4));
        assertThat(India.listLaunchedCars().toArray(),
                   equalTo(allCars));

        // NOT skipping hashcode
        assertThat(India.hashCode(), not(equalTo(oldHashCode)));
        // NOT skipping equals
        assertThat(India, not(equalTo(defaultCar)));

        // **test flaw** - did not exercise adding the same Car twice
        assertThat(India.Launch(Mercedes), is(false)); // should fail

        // test toString
        assertThat(India.toString(), containsString("India"));
        assertThat(India.toString(),
                   containsString(Integer.toString(India.numLaunched())));
        assertThat(India.toString(),
                   containsString(Integer.toString(4)));

        assertThat(India.toString(), containsString(allCars[0].toString()));
        assertThat(India.toString(), containsString(allCars[1].toString()));
        assertThat(India.toString(), containsString(allCars[2].toString()));
        assertThat(India.toString(), containsString(allCars[3].toString()));
    }

    @Test
    public void testClone()
    {
        //This is where the fun continues
        addToLocation India = new addToLocation(3, "India");

        India.Launch(BMW);
        India.Launch(Mercedes);
        India.Launch(Ferrari);

        // Make the copy
        addToLocation copyIndia = (addToLocation) India.clone();

        // Both addToLocations should still be identical
        assertThat(copyIndia.getlocation(), equalTo(India.getlocation()));
        assertThat(copyIndia.getlaunchLimit(), equalTo(India.getlaunchLimit()));
        assertThat(copyIndia.numLaunched(), equalTo(India.numLaunched()));
        assertThat(copyIndia.hashCode(), equalTo(India.hashCode()));
        assertThat(copyIndia, equalTo(India));
        assertThat(copyIndia.toString(), equalTo(India.toString()));

        // But distinct
        assertThat(copyIndia, not(sameInstance(India)));
        assertThat(copyIndia.listLaunchedCars(),
                   not(sameInstance(India.listLaunchedCars())));

        // Change the limit to 4
        copyIndia.setlaunchLimit(4);
        assertThat(copyIndia.getlaunchLimit(), equalTo(4));
        assertThat(copyIndia.Launch(Porsche), is(true));

        assertThat(copyIndia.listLaunchedCars(), notNullValue());
        assertThat(copyIndia.listLaunchedCars().size(), equalTo(4));
        assertThat(copyIndia.listLaunchedCars().toArray(), equalTo(allCars));

        assertThat(copyIndia.hashCode(), not(equalTo(India.hashCode())));
        assertThat(copyIndia, not(equalTo(defaultCar)));
        assertThat(copyIndia, not(equalTo(India)));

        // India should be unchanged
        assertThat(India.listLaunchedCars().size(), equalTo(3));
        assertThat(India.listLaunchedCars().toArray(),
                   equalTo(firstThreeCars));

        // test toString
        assertThat(copyIndia.toString(), containsString("India"));
        assertThat(copyIndia.toString(),
                   containsString(Integer.toString(copyIndia.numLaunched())));
        assertThat(copyIndia.toString(),
                   containsString(Integer.toString(4)));

        assertThat(copyIndia.toString(), containsString(allCars[0].toString()));
        assertThat(copyIndia.toString(), containsString(allCars[1].toString()));
        assertThat(copyIndia.toString(), containsString(allCars[2].toString()));
        assertThat(copyIndia.toString(), containsString(allCars[3].toString()));

        assertThat(copyIndia.toString(), not(equalTo(India.toString())));
    }
}
