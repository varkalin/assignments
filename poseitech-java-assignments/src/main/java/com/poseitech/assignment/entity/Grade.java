package com.poseitech.assignment.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grade implements Serializable {

	private static final long serialVersionUID = 6248727724258523107L;

	@Id
	private String level;
	private String remark;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
