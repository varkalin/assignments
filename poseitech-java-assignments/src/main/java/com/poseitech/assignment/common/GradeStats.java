package com.poseitech.assignment.common;

import java.io.Serializable;

public class GradeStats implements Serializable {

	private static final long serialVersionUID = -2713220921302394589L;

	String level;
	String course;
	Integer count;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "GradeStats [level=" + level + ", course=" + course + ", count=" + count + "]";
	}
}
