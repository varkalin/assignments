package com.poseitech.assignment.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.poseitech.assignment.dto.StudentDto;
import com.poseitech.assignment.entity.Student;

public interface StudentDao// extends JpaRepository<Student, Integer> 
{
//	// save or update student to database
	public Optional<Student> saveOrUpdate(Student pStudent) throws Exception;

	public void save(Student pStudent) throws Exception;
//
//	// load student by identification
	public Optional<Student> findById(Integer pStudentId) throws Exception;
//
//	// find all projects by the student interested
//	public List<Student> findStudentByProjectId(Integer pProjectId) throws Exception;
//
//	// delete student.
	public void deleteStudent(Integer pStudentId) throws Exception;
//
//	// find all students by paging.
	public List<Student> findAllStudents(int pStartRowNumber, int pFectchSize) throws Exception;

	// find all students by paging.
	public List<Student> findAllStudents(StudentDto studentDto, int pStartRowNumber, int pFectchSize) throws Exception;
	//
	public List<Student> findByHql(String pHql, int pStartRowNumber, int pFectchSize, Map<String, Object> param)
			throws Exception;
	//
	public List<Student> findByNamedQuery(String pNameQuery, Class<?> clazz, Map<String, Object> param, int pStartRowNumber,
			int pFectchSize) throws Exception;
}
