package com.poseitech.assignment.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poseitech.assignment.entity.StudentCourse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDto implements Serializable {

	private static final long serialVersionUID = 3209888691671533902L;

	private Integer id;

	private String name;

	private Date createDate;

	private String remark;

	private Set<StudentCourse> studentCourses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	@Override
	public String toString() {
		return "CourseDto [id=" + id + ", name=" + name + ", createDate=" + createDate + ", remark=" + remark
				+ ", studentCourses=" + studentCourses + "]";
	}

}
