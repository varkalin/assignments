package com.poseitech.assignment.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseitech.assignment.common.GradeStats;
import com.poseitech.assignment.dao.StudentDao;
import com.poseitech.assignment.dto.ProjectDto;
import com.poseitech.assignment.dto.StudentDto;
import com.poseitech.assignment.entity.Student;
import com.poseitech.assignment.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private StudentDao studentDao;

	public Optional<Student> createStudent(StudentDto pNewStudent) throws Exception {
		return studentDao.saveOrUpdate(pNewStudent.convert(true));
	}

	@Override
	public Optional<Student> getStudentById(Integer pStudentId) throws Exception {
		return studentDao.findById(pStudentId);
	}

	@Override
	public List<Student> getAllStudents(int pStartRowNumber, int pLimit) throws Exception {
		return studentDao.findAllStudents(pStartRowNumber, pLimit);
	}

	@Override
	public List<Student> getAllStudents(StudentDto studentDto, int pStartRowNumber, int pLimit) throws Exception {
		return studentDao.findAllStudents(studentDto, pStartRowNumber, pLimit);
	}

	@Override
	public void deleteStudent(StudentDto pNewStudent) throws Exception {
		studentDao.deleteStudent(pNewStudent.getId());
	}

	@Override
	public List<GradeStats> getStudentGradeStats() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectDto> getInterestedProjects(StudentDto pStudent) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDto registerProjects(Integer pStudendId, List<ProjectDto> pProjects) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectDto> createProjects(List<ProjectDto> pProjects) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProjects(List<ProjectDto> pProjects) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
