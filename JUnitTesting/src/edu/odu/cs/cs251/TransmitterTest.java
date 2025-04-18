package edu.odu.cs.cs251;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransmitterTest {

	@Test
	void testTransmitter() {
		Transmitter transmitter = new Transmitter("text", 0, 5, 30);
		assertEquals("text", transmitter.getID());
		assertEquals(0, transmitter.getX());
		assertEquals(5, transmitter.getY());
		assertEquals(30, transmitter.getEffectiveRange());
	}

	@Test
	void testTransmitUrgent() {
		Transmitter transmitter = new Transmitter("text", 0, 5, 30);
		Receiver rInRange = new Receiver("Receiver In Range", 3, 15);
		assertEquals(true, transmitter.transmitUrgent(rInRange, "Testing"));
		Receiver rOutOfRange = new Receiver("Receiver Out Of Range", 300, 150);
		assertEquals(false, transmitter.transmitUrgent(rOutOfRange, "testing"));
	}

	@Test
	void testTransmitNormal() {
		Transmitter transmitter = new Transmitter("text", 0, 5, 30);
		Receiver rInRange = new Receiver("Receiver In Range", 3, 15);
		assertEquals(true, transmitter.transmitNormal(rInRange, "Testing"));
		Receiver rOutOfRange = new Receiver("Receiver Out Of Range", 300, 150);
		assertEquals(false, transmitter.transmitNormal(rOutOfRange, "testing"));
	}

}
