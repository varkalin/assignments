package com.poseitech.assignment.common;

public interface ObjectConverter<T> {
	public static final Models utils = new Models();
	
	public T convert(boolean relation);
}
