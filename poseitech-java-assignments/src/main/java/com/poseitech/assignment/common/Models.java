package com.poseitech.assignment.common;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Models {
	public static <T> List<T> transfer(Collection<? extends ObjectConverter<T>> list){
		return list.stream()
			.map(o->o.convert(true))
			.collect(toList());
	}
	
	public static <T> Comparison<T> compare(Collection<T> oldList, Collection<T> newList, ObjectComparable<T> p){
		List<T> addList = new CopyOnWriteArrayList<>();
		List<T> delList = new CopyOnWriteArrayList<>();
		newList.stream()
			.forEach(o1->oldList.stream()
				.filter(o2->p.compare(o1, o2))
				.findAny()
				.map(o2->oldList.remove(o2))
				.orElseGet(()->addList.add(o1)));
		if(!oldList.isEmpty()){
			delList.addAll(oldList);
		}
		return new Comparison<T>(addList, delList);
	}
	
	public static <T> Comparison<T> compare(Collection<T> oldList, Collection<T> newList){
		return compare(oldList, newList, (o1,o2)->o1.equals(o2));
	}
}
