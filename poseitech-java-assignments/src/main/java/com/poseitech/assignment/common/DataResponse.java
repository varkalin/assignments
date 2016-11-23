package com.poseitech.assignment.common;

import java.io.Serializable;

public class DataResponse implements Serializable {

	private static final long serialVersionUID = 4546282737458011065L;

	private Object data;

	private String error;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return "DataResponse [data=" + data + ", error=" + error + "]";
	}
}
