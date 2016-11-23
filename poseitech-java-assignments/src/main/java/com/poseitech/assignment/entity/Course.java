package com.poseitech.assignment.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.poseitech.assignment.common.ObjectConverter;
import com.poseitech.assignment.dto.CourseDto;

@Entity
public class Course implements Serializable, ObjectConverter<CourseDto> {

	private static final long serialVersionUID = -2963645174621888934L;

	public Course() {
		studentCourses = new HashSet<>();
	}

	public Course(String name, Date createDate, String remark) {
		super();
		this.name = name;
		this.createDate = createDate;
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Integer id;
	private String name;
	private Date createDate;
	private String remark;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
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
	public CourseDto convert(boolean relation) {
		CourseDto courseDto = new CourseDto();
		courseDto.setId(id);
		courseDto.setName(name);
		courseDto.setCreateDate(createDate);
		courseDto.setRemark(remark);
		return courseDto;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", createDate=" + createDate + ", remark=" + remark + "]";
	}
}
