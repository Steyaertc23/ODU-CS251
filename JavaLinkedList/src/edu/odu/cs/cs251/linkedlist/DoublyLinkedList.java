package edu.odu.cs.cs251.linkedlist;

import java.util.Objects;

import edu.odu.cs.cs251.linkedlist.LinkedList;

public class DoublyLinkedList<T> implements LinkedList<T>{

	private class Node {
		T t;
		Node prev, next;
		Node(T t, Node prev, Node next) {
			this.t = t;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node head, tail;
	int currentSize;
	
	public DoublyLinkedList() {
		head = tail = null;
		currentSize = 0;
	}
	
	public void add(T t) {
		/*
		 * Cases:
		 * 	1) List is empty
		 * 	2) List is not empty
		 */
		if (isEmpty()) {
			head = new Node(t, null, null);
			tail = head;
		}
		else {
			// Add new tail
			tail.next = new Node(t, tail, null);
			tail = tail.next;
		}
		
		currentSize++;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return currentSize;
	}

	@Override
	public void insert(T t, int idx) {
		/*
		 * 3 cases:
		 * 	1) Adding t to the end of the list
		 * 	2) Adding t to the front of the list
		 * 	3) Adding to to somewhere in the middle of the list
		 */
		if (idx == size()) {
			add(t);
		}
		else if (idx == 0) {
			addToHead(t);
		}
		else {
			// Iterate to where to insert the node
			Node itr = head;
			
			for (int i = 0; i < idx; i++) {
				itr = itr.next;
			}
			
			/**
			 * key: [index]
			 * 
			 * [0] <----> [1] <----> [2]
			 * 
			 *  Insert newNode at index 1
			 * 
			 *  		 newNode
			 *  	      | |
			 *   -------->[1]	
			 *   |		   | 
			 *   V         V
			 *  [0]       [2] <----> [3] 
			 *  		  | |
			 *     		  itr
			 */
			// Add the new node between itr.prev and itr
			Node newNode = new Node(t, itr.prev, itr);
			/// Update links
			itr.prev.next = newNode;
			itr.prev = newNode;
			
			currentSize++;
		}
	}

	@Override
	public T remove(int idx) throws IndexOutOfBoundsException {
		if (idx > size() || idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		/*
		 * Cases:
		 * 	1) idx to remove is the last index
		 * 	2) idx to remove is the first index
		 * 	3) idx to remove is somewhere in the middle
		 */
		if (idx == size() - 1) {
			return removeTail();
		}
		else if (idx == 0) {
			return removeHead();
		}
		else {
			// Iterate to the node to remove
			Node itr = head;
			for (int i = 0; i < idx; i++) {
				itr = itr.next;
			}
			
			// Connect itr.prev to itr.next
			itr.prev.next = itr.next;
			itr.next.prev = itr.prev;
			
			// Disconnect itr from the list
			itr.prev = null;
			itr.next = null;
			
			currentSize--;
			
			return itr.t;
		}
	}

	public T removeHead() {
		// Get reference to return value
		T toReturn = head.t;
		// Update head to head.next
		head = head.next;
		// Update head.prev to be null
		head.prev = null;
		
		currentSize--;
		
		return toReturn;
	}

	public T removeTail() {
		// Get reference to return value
		T toReturn = tail.t;
		// Update tail to tail.prev
		tail = tail.prev;
		// Update tail.next to be null
		tail.next = null;
		
		currentSize--;
		
		return toReturn;
	}

	@Override
	public T get(int idx) {
		/*
		 * 3 cases:
		 * 	1) idx to get is the last index
		 * 	2) idx to get is the first index
		 * 	3) idx to get is somewhere in the middle
		 */
		
		if (idx == (size() - 1)) {
			return getLast();
		}
		else if (idx == 0) {
			return getFirst();
		}
		else {
			// Iterate to the node at idx
			Node itr = head;
			for (int i = 0; i < idx; i++) {
				itr = itr.next;
			}
			return itr.t;
		}
	}
	
	@Override
	public void set(T t, int idx) {
		/**
		 * Three cases:
		 * 	1) idx is head
		 *  2) idx is tail
		 *  3) idx is somewhere in the middle
		 */
		
		if (idx == 0) {
			head.t = t;
		}
		else if (idx == size() - 1) {
			tail.t = t;
		}
		else {
			Node itr = head;
			for (int i = 0; i < idx; i++) {
				itr = itr.next;
			}
			itr.t = t;
		}
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		StringBuffer sb = new StringBuffer("[");
		Node itr = head;
		while (itr != null) {
			sb.append("%s,".formatted(itr.t));
			itr = itr.next;
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		else if (o instanceof DoublyLinkedList<?> rhs) {
			// Different sized lists cannot be the same
			if (size() != rhs.size()) {
				return false;
			}
			
			DoublyLinkedList<?>.Node lhsItr=head, rhsItr=rhs.head;
			while (lhsItr != null) {
				if (!Objects.equals(lhsItr.t, rhsItr.t)) {
					return false;
				}
				lhsItr = lhsItr.next;
				rhsItr = rhsItr.next;
			}
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public T getLast() {
		return (tail == null ? null : tail.t);
	}
	
	public T getFirst() {
		return (head == null ? null : head.t);
	}
	
	public void addToHead(T t) {
		head.prev = new Node(t, null, head);
		head = head.prev;
		currentSize++;
	}
}
