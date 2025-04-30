package edu.odu.cs.cs251.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {
	
	private DoublyLinkedList<Integer> dll;
	
	@BeforeEach
	void setUp() {
		// Create a new instance for each test
		dll = new DoublyLinkedList<>();
	}

	@Test
	void testDoublyLinkedList() {
		assertThat(dll, is(not(nullValue())));
	}

	@Test
	void testAdd() {
		dll.add(0);
		dll.add(1);
		dll.add(2);
		
		assertThat(dll.size(), 		is(3));
		assertThat(dll.get(1), 		is(1));
		assertThat(dll.getFirst(), 	is(0));
		assertThat(dll.getLast(), 	is(2));
		assertThat(dll.toString(), is("[0,1,2]"));
	}

	@Test
	void testInsert() {
		dll.add(0);
		dll.add(2);
		dll.add(4);
		int size = dll.size();
		// initial: [0,2,4]
		assertThat(dll.toString(), is("[0,2,4]"));
		
		// Insert at idx=1 between 0 and 2
		// expected: [0,1,2,4]
		dll.insert(1, 1);
		assertThat(dll.get(1), is(1));
		assertThat(dll.size(), is(++size));
		assertThat(dll.toString(), is("[0,1,2,4]"));

		
		// Insert at idx=3 between 2 and 4
		// expected: [0,1,2,3,4]
		dll.insert(3, 3);
		assertThat(dll.get(3), is(3));
		assertThat(dll.size(), is(++size));
		assertThat(dll.toString(), is("[0,1,2,3,4]"));

		// Insert at head
		// expected: [-1,0,1,2,3,4]
		dll.insert(-1, 0);
		assertThat(dll.get(0), is(-1));
		assertThat(dll.size(), is(++size));
		assertThat(dll.toString(), is("[-1,0,1,2,3,4]"));
		
		// Insert at tail
		// expected: [-1,0,1,2,3,4,6]
		dll.insert(6, 6);
		assertThat(dll.get(6), is(6));
		assertThat(dll.size(), is(++size));
		assertThat(dll.toString(), is("[-1,0,1,2,3,4,6]"));

		
		// Sanity check that it's not inserting idx at idx
		// expected: [-1,0,-2,1,2,3,4,5]
		dll.insert(-2, 2);
		assertThat(dll.get(2), is(-2));
		assertThat(dll.size(), is(++size));
		assertThat(dll.toString(), is("[-1,0,-2,1,2,3,4,6]"));

	}

	@Test
	void testRemove() {
		dll.add(0);
		dll.add(1);
		dll.add(2);
		
		// Head remove
		assertThat(dll.remove(0), is(0));
		assertThat(dll.size(), is(2));
		
		// Tail remove
		assertThat(dll.remove(1), is(2));
		assertThat(dll.size(), is(1));
		
		// Somewhere in the middle remove
		dll.add(0);
		dll.add(2);
		assertThat(dll.remove(1), is(0));
		assertThat(dll.size(), is(2));
	}
	
	@Test
	void testSet() {
		dll.add(0);
		dll.add(1);
		dll.add(2);
		
		// Head set
		dll.set(3, 0);
		assertThat(dll.get(0), is(3));
		// Tail set
		dll.set(6, 2);
		assertThat(dll.get(2), is(6));
		// Somewhere in the middle set
		dll.set(25, 1);
		assertThat(dll.get(1), is(25));
	}
}
