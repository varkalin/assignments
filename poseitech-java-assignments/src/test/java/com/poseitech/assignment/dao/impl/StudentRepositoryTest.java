package com.poseitech.assignment.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poseitech.assignment.Application;
import com.poseitech.assignment.entity.Course;
import com.poseitech.assignment.entity.Student;
import com.poseitech.assignment.entity.StudentCourse;
import com.poseitech.assignment.repository.CourseRepository;
import com.poseitech.assignment.repository.StudentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	@Transactional
	public void testCRUD() throws Exception {
		Student studentA = new Student();
		studentA.setName("Student A");
		studentA.setBirthday(new Date());
		studentA.setRegisterDate(new Date());
		studentA.setRemark("Student A");

		Course courseA = new Course();
		courseA.setName("Course A");
		courseA.setCreateDate(new Date());
		courseA.setRemark("Course A");

		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setStudent(studentA);
		studentCourse.setCourse(courseA);
		studentCourse.setGradeLevel("A");
		courseA.getStudentCourses().add(studentCourse);

		// Creation
		studentRepository.save(studentA);
		courseRepository.save(courseA);

		// Update
		courseA.getStudentCourses().remove(studentCourse);
		courseRepository.save(courseA);
		Assert.assertEquals(courseA.getStudentCourses().size(), 0);

		// Retrieval
		List<Student> students = studentRepository.findAll();
		System.out.println(students);

		// Delete
		studentRepository.deleteAll();
		Assert.assertEquals(studentRepository.findAll().size(), 0);
	}
}
