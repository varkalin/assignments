package com.poseitech.assignment.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentCourse implements Serializable {

	private static final long serialVersionUID = -7085004751167334777L;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	private Student student;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseId")
	private Course course;

	@Column(name = "gradeLevel")
	private String gradeLevel;

	public StudentCourse() {
	}

	public StudentCourse(Student student, Course course, String gradeLevel) {
		super();
		this.student = student;
		this.course = course;
		this.gradeLevel = gradeLevel;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	@Override
	public String toString() {
		return "StudentCourse [student=" + student + ", course=" + course + ", gradeLevel=" + gradeLevel + "]";
	}
}
