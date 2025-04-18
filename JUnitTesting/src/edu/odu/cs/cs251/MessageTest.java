package edu.odu.cs.cs251;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.odu.cs.cs251.Message.Priority;

class MessageTest {

	@Test
	void testMessage() {
		Message message = new Message(Priority.NORMAL, "Test");
		assertEquals(message.getMessage(), "Test");
		assertEquals(message.getPriority(), Priority.NORMAL);
	}

	@Test
	void testCompareTo() {
		Message m = new Message(Priority.NORMAL, "Test");
		assert(m.compareTo(m) == 0);
		Message m2 = new Message(Priority.URGENT, "Test");
		assert(m.compareTo(m2) > 0);
		assert(m.compareTo(m2) < 0);
	}

}
