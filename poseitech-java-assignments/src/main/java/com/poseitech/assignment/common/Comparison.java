package com.poseitech.assignment.common;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Comparison<T> {
	private List<T> increase = new CopyOnWriteArrayList<>();
	
	private List<T> decrease = new CopyOnWriteArrayList<>();
	
	public Comparison(List<T> increase, List<T> decrease){
		if(increase!=null&&!increase.isEmpty()){
			this.increase.addAll(increase);
		}
		if(decrease!=null&&!decrease.isEmpty()){
			this.decrease.addAll(decrease);
		}
	}

	public List<T> getIncrease() {
		return increase;
	}

	public List<T> getDecrease() {
		return decrease;
	}

	public void setIncrease(List<T> increase) {
		this.increase = increase;
	}

	public void setDecrease(List<T> decrease) {
		this.decrease = decrease;
	}
}
