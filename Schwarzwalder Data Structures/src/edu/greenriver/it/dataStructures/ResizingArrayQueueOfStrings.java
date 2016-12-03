/**
 * Jami Schwarzwalder
 * Dec 2, 2016
 * ResizingArrayQueueOfStrings.java
 * Queue that resizes an array.
 */
package edu.greenriver.it.dataStructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * implements the queue abstraction with a fixed-size array, and then extends
 * your Implementation to use array resizing to remove the size restriction
 * 
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class ResizingArrayQueueOfStrings implements Queue<String>{

	private String[] queueOfStrings;
	private int tail = 0;
	private int head = 0;
	private int N;

	public ResizingArrayQueueOfStrings(int size) {
		this.N = size;
		this.queueOfStrings = new String[N];
	}

	private void resize() {
		String[] tempArray = new String[N * 2];
		tail = tail - head;
		for (int i = 0; i < tail; i++) {
			tempArray[i] = this.queueOfStrings[head + i];
		}
		head = 0;
		this.queueOfStrings = tempArray;
	}

	public boolean addAll(Collection<? extends String> arg0) {
		for (String arg : arg0){
			add(arg);
		}
		return true;
	}

	@Override
	public void clear() {
		tail = 0;
		head = 0;

	}

	@Override
	public boolean isEmpty() {
		return head == tail;
	}

	@Override
	public int size() {
		return tail - head;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String arg0) {
		if (queueOfStrings.length == tail) {
			resize();
		}

		this.queueOfStrings[tail] = arg0;
		tail++;
		return true;
	}

	@Override
	public String element() {
		String firstItem = peek();
		if (firstItem == null) {
			throw new NoSuchElementException("Your queue is empty");
		}
		return firstItem;
	}

	@Override
	public boolean offer(String arg0) {
		add(arg0);
		return true;
		
	}

	@Override
	public String peek() {
		if (!isEmpty()) {
			return this.queueOfStrings[head];
		}
		return null;
	}

	@Override
	public String poll() {
		if (!isEmpty()) {
			head++;
			return this.queueOfStrings[head - 1];
		}
		return null;
	}

	@Override
	public String remove() {
		String removedItem = poll();
		if (removedItem == null) {
			throw new NoSuchElementException("Your queue is empty");
		}
		return removedItem;
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<String> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
}
