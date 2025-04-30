package edu.odu.cs.cs251.linkedlist;

public interface LinkedList<T> {

	/**
	 * Appends to the end of the list.
	 * @param t Element to add.
	 */
	void add(T t);
	/**
	 * Inserts element at index.
	 * @param t Element to insert.
	 * @param idx Index to insert.
	 * 
	 *	<p>
	 *	Clarify: Subsequent list.get(idx) should return t.
	 *	</p>
	 */
	void insert(T t, int idx);
	/**
	 * Get element at index idx.
	 * @param idx Index of element.
	 * @return Value at the index.
	 */
	T get(int idx);
	/**
	 * Removes element at index idx.
	 * @param idx Index to remove.
	 * @return The element that was removed.
	 */
	T remove(int idx);
	/**
	 * @return the size of the list
	 */
	int size();
	/**
	 * @return true if the list is empty, false otherwise.
	 */
	boolean isEmpty();
	/**
	 * Sets the element at idx to t
	 * @param t Value to set.
	 * @param idx Index of element.
	 */
	void set(T t, int idx);
}
