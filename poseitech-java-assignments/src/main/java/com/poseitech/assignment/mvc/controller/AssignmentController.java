package com.poseitech.assignment.mvc.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poseitech.assignment.common.DataResponse;
import com.poseitech.assignment.common.GradeStats;
import com.poseitech.assignment.dto.StudentDto;
import com.poseitech.assignment.entity.Student;
import com.poseitech.assignment.service.AssignmentService;

@RestController
@RequestMapping("/assignment/api/v1/students")
public class AssignmentController {

	private static Logger LOG = LoggerFactory.getLogger(AssignmentController.class);

	@Autowired
	private AssignmentService assignmentService;

	// a.查詢特定的學生
	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
	public HttpEntity<DataResponse> queryStudentById(@PathVariable Integer studentId) {
		DataResponse resp = new DataResponse();
		try {
			Optional<Student> student = assignmentService.getStudentById(studentId);
			student.ifPresent(s -> resp.setData(s));
			student.orElseThrow(() -> new Exception("Cannot find Student"));
		} catch (Exception e) {
			e.printStackTrace();
			resp.setError(e.toString());
			return new ResponseEntity<DataResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<DataResponse>(resp, HttpStatus.OK);
	}

	// c.查詢所有學生
	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<DataResponse> queryStudents(@RequestParam(defaultValue = "0") Integer start,
			@RequestParam(defaultValue = "0") Integer limit) {
		DataResponse resp = new DataResponse();
		try {
			List<Student> students = assignmentService.getAllStudents(start, limit);
			resp.setData(students);
			return new ResponseEntity<DataResponse>(resp, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setError(e.toString());
			return new ResponseEntity<DataResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// d.新增一個學生/b.依條件查詢學生
	@RequestMapping(method = RequestMethod.POST)
	public HttpEntity<DataResponse> createOrRetrieveStudent(@RequestParam(required = true) String method,
			@RequestParam(defaultValue = "0") Integer start, @RequestParam(defaultValue = "0") Integer limit,
			@RequestBody StudentDto studentDto) {
		DataResponse resp = new DataResponse();
		// creation
		if ("c".equalsIgnoreCase(method)) {
			Optional<Student> student = null;
			try {
				student = assignmentService.createStudent(studentDto);
				student.ifPresent(s -> resp.setData(s));
				student.orElseThrow(() -> new Exception("Create Student Fail"));
			} catch (Exception e) {
				e.printStackTrace();
				resp.setError(e.toString());
				return new ResponseEntity<DataResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		// retrieval
		else if ("r".equalsIgnoreCase(method)) {
			try {
				List<Student> students = assignmentService.getAllStudents(studentDto, start, limit);
				LOG.debug("=== Retrieval students: " + students);
				resp.setData(students);
			} catch (Exception e) {
				e.printStackTrace();
				resp.setError(e.toString());
				return new ResponseEntity<DataResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<DataResponse>(resp, HttpStatus.OK);
	}

	// e.查詢各科成績的學生人數
	@RequestMapping(value = "/grades", method = RequestMethod.GET)
	public HttpEntity<DataResponse> queryStudentsGradeStats(@RequestParam String start, @RequestParam String limit) {
		DataResponse resp = new DataResponse();
		try {
			List<GradeStats> gradeStats = assignmentService.getStudentGradeStats();
			LOG.debug("=== Retrieval gradeStats: " + gradeStats);
			resp.setData(gradeStats);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setError(e.toString());
			return new ResponseEntity<DataResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<DataResponse>(resp, HttpStatus.OK);
	}
}
