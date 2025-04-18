package edu.odu.cs.cs251;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.odu.cs.cs251.Message.Priority;

class ReceiverTest {

	@Test
	void testReceiver() {
		Receiver r = new Receiver("abc", 0, 1);
		assertEquals("abc", r.getID());
		assertEquals(0, r.getX());
		assertEquals(1, r.getY());
	}

	@Test
	void testReceive() {
		Receiver r = new Receiver("abc", 0, 1);
		Message m = new Message(Priority.NORMAL, "A normal message");
		r.receive(m);
		assertTrue(r.hasMessage());
	}

	@Test
	void testNextMessage() {
		Receiver r = new Receiver("abc", 0, 1);
		// A message hasn't been received
		assertEquals(null, r.nextMessage());
		// After a message is received
		Message m = new Message(Priority.NORMAL, "A normal message");
		r.receive(m);
		assertEquals("A normal message", r.nextMessage());
		// The message queue should be empty now
		assertEquals(null, r.nextMessage());
	}

}
