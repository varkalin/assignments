package com.poseitech.assignment.common;

@FunctionalInterface
public interface ObjectComparable<T> {
	public boolean compare(T o1, T o2);
}
