package com.poseitech.assignment.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

import com.poseitech.assignment.common.ObjectConverter;
import com.poseitech.assignment.dto.StudentDto;

@NamedNativeQueries({
		@NamedNativeQuery(name = "findStudentsByName", query = "select * from Student where name like :name", resultClass = Student.class) })

@Entity
public class Student implements Serializable, ObjectConverter<StudentDto> {

	private static final long serialVersionUID = 4012534442879056855L;

	public Student() {
	}

	public Student(String name, Date birthday, Date registerDate, String remark, Set<StudentCourse> studentCourses) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.registerDate = registerDate;
		this.remark = remark;
		this.studentCourses = studentCourses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Date birthday;
	private Date registerDate;
	private String remark;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
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
	public StudentDto convert(boolean relation) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(id);
		studentDto.setName(name);
		studentDto.setBirthday(birthday);
		studentDto.setRegisterDate(registerDate);
		studentDto.setRemark(remark);
		studentDto.setStudentCourses(studentCourses);
		return studentDto;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", registerDate=" + registerDate
				+ ", remark=" + remark + ", studentCourses=" + studentCourses + "]";
	}
}
