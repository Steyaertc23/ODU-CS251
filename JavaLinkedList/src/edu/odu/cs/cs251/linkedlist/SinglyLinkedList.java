package edu.odu.cs.cs251.linkedlist;



public class SinglyLinkedList<T> implements LinkedList<T> {

	private class Node {
		T val;
		Node next;
		
		Node(T val, Node next){
			this.val = val;
			this.next = next;
		}
		
	}
	
	private Node head, tail;
	private int currentSize;
	
	public SinglyLinkedList() {
		head = tail = null;
		currentSize = 0;
	}
	
	@Override
	public void add(T t) {
		++currentSize;
		if(head == null) {
			head = new Node(t, null);
			tail = head;
			return;
		}
		tail.next = new Node(t, null);
		tail = tail.next;
	}

	@Override
	public void insert(T t, int idx) {
		if (idx == 0) {
			Node newHead = new Node(t, head);
			head = newHead;
			++currentSize;
			return;
		}
		else if (idx == currentSize) {
			add(t);
			return;
		}
		
		Node itr = head;
		
		for (int i = 0; i < idx-1; ++i) {
			itr = itr.next;
		}
		Node newNode = new Node(t, itr.next);
		itr.next = newNode;
		++currentSize;
		
	}

	@Override
	public T get(int idx) {
		if(idx == 0) {
			return head.val;
		}
		else if(idx == currentSize - 1) {
			return tail.val;
		}
		
		Node itr = head;
		for (int i = 0; i < idx; ++i) {
			itr = itr.next;
		}
		return itr.val;
	}

	@Override
	public T remove(int idx) {
		if (idx == 0) {
			T returnVal = head.val;
			head = head.next;
			return returnVal;
		}
		Node itr = head;
		for(int i = 0; i < idx - 1; ++i) {
			itr = itr.next;
		}
		Node toRemove = itr.next;
		T returnVal = toRemove.val;
		itr.next = toRemove.next;
		if (toRemove == tail) {
			tail = itr;
		}
		return returnVal;
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public void set(T t, int idx) {
		if(idx == 0) {
			head.val = t;
			return;
		}
		else if(idx == currentSize - 1) {
			tail.val = t;
			return;
		}
		
		Node itr = head;
		for (int i = 0; i < idx; i++) {
			itr = itr.next;
		}
		itr.val = t;
		return;
		
	}

}
