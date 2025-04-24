package Tests;

import Classes.Car;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.core.IsNull;

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
public class TestCar {

    Car Car;

    @BeforeEach
    public void setUp()
    {
        Car = new Car();
    }

    @Test
    public void testDefaultConstructor()
    {
    	String desiredName = "British Motor Works";
    	Car defaultCar = new Car();
    	assertThat(defaultCar.getName(), equalTo(desiredName));
    	assertThat(defaultCar.hashCode(),
                equalTo(Car.hashCode()));

	    assertThat(defaultCar.toString(), equalTo(desiredName));
	    assertThat(defaultCar.toString(), containsString(desiredName));
	
	    assertThat(defaultCar, equalTo(Car));
    }

    @Test
    public void testNonDefaultConstructor()
    {
        String  desiredName = "Mercedes Benz";
        Car Mercedes       = new Car(desiredName);

        assertThat(Mercedes.getName(), equalTo(desiredName));

        assertThat(Mercedes.hashCode(),
                   not(equalTo(Car.hashCode())));

        assertThat(Mercedes.toString(), equalTo(desiredName));
        assertThat(Mercedes.toString(), containsString(desiredName));

        assertThat(Mercedes, not(equalTo(Car)));
    }

    @Test
    public void testSetName()
    {
        Car BMW    = new Car();
        String  newName = "British Motors Works";

        int oldHashCode = BMW.hashCode();

        BMW.setName(newName);

        assertThat(BMW.getName(), equalTo(newName));
        assertThat(BMW.hashCode(), not(oldHashCode));

        // assertThat(BMW.toString(), equalTo(newName));
        assertThat(BMW.toString(), containsString(newName));

        assertThat(BMW, not(equalTo(Car)));
    }

    @Test
    public void testClone()
    {
        fail("Left as an Exercise");
    }
}
