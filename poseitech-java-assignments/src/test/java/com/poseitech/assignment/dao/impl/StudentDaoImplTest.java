package com.poseitech.assignment.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poseitech.assignment.Application;
import com.poseitech.assignment.dao.StudentDao;
import com.poseitech.assignment.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class StudentDaoImplTest {
	
	@Autowired
	private StudentDao studentDao;
	
	@Test
	@Transactional
	public void findByHql() throws Exception {
		for (int i=1; i<=5; i++) {
			studentDao.saveOrUpdate(new Student());
		}
		System.out.println(studentDao.findById(1));
		
		String pHql = "from Student where name like :name ";
		Integer pStartRowNumber = 0;
		Integer pFectchSize = 3;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "%name%");
		List<Student> students = studentDao.findByHql(pHql, pStartRowNumber, pFectchSize, param);
		System.out.println("=== studentDao.findByHql: \n" + students);
		
		students = studentDao.findByNamedQuery("findStudentsByName", Student.class, param, pStartRowNumber, pFectchSize);
		System.out.println("=== studentDao.findByNamedQuery: \n" + students);
	}
}
