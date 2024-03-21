package com.walmart.codingQuestions;

import java.util.Iterator;
import java.util.LinkedList;

public class PeekingIterator implements Iterator<Integer> {
	// Java Iterator interface reference:
	// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

	LinkedList<Integer> queue = new LinkedList<Integer>();

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		while (iterator.hasNext())
			queue.add(iterator.next());
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (!queue.isEmpty())
			return queue.peek();
		return -1;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (!queue.isEmpty())
			return queue.poll();
		return -1; // we need to think abt this
	}

	@Override
	public boolean hasNext() {
		if (!queue.isEmpty() && queue.peek() != null) // need to check if this
			return true;
		return false;
	}
}
