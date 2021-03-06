package com.poseitech.assignment.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poseitech.assignment.common.ObjectConverter;
import com.poseitech.assignment.entity.Student;
import com.poseitech.assignment.entity.StudentCourse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto implements Serializable, ObjectConverter<Student> {

	private static final long serialVersionUID = 3209888691671533902L;

	private Integer id;

	private String name;

	private Date birthday;

	private Date registerDate;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
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
	public Student convert(boolean relation) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setBirthday(birthday);
		student.setRegisterDate(registerDate);
		student.setRemark(remark);
		student.setStudentCourses(studentCourses);
		return student;
	}

	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", birthday=" + birthday + ", registerDate=" + registerDate
				+ ", remark=" + remark + ", studentCourses=" + studentCourses + "]";
	}
}
