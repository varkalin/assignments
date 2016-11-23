package com.poseitech.assignment.dao.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poseitech.assignment.dao.StudentDao;
import com.poseitech.assignment.dto.StudentDto;
import com.poseitech.assignment.entity.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public Optional<Student> saveOrUpdate(Student pStudent) throws Exception {
		Student student = entityManager.merge(pStudent);
		return Optional.ofNullable(student);
	}
	
	@Override
	public void save(Student pStudent) throws Exception {
		entityManager.persist(pStudent);
	}

	@Override
	public Optional<Student> findById(Integer pStudentId) throws Exception {
		Student student = entityManager.find(Student.class, pStudentId);
		return Optional.ofNullable(student);
	}

	@Override
	public void deleteStudent(Integer pStudentId) throws Exception {
		Optional<Student> student = findById(pStudentId);
		if (student.isPresent())
			entityManager.remove(student.get());
	}

	@Override
	public List<Student> findAllStudents(int pStartRowNumber, int pFectchSize) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String pHql = "from Student where 1=1";
		return findByHql(pHql, pStartRowNumber, pFectchSize, param);
	}

	@Override
	public List<Student> findAllStudents(StudentDto studentDto, int pStartRowNumber, int pFectchSize) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String pHql = "from Student where 1=1";
		
		if (null != studentDto.getId()) {
			pHql += " and id = :id";
			param.put("id", studentDto.getId());
		}
		if (null != studentDto.getName()) {
			pHql += " and name like :name";
			param.put("name", "%" + studentDto.getName() + "%");
		}
		if (null != studentDto.getBirthday()) {
			pHql += " and birthday = :birthday";
			param.put("birthday", studentDto.getBirthday());
		}
		if (null != studentDto.getRegisterDate()) {
			pHql += " and registerDate = :registerDate";
			param.put("registerDate", studentDto.getRegisterDate());
		}
		if (null != studentDto.getRemark()) {
			pHql += " and remark like :remark";
			param.put("remark", "%" + studentDto.getRemark() + "%");
		}
		return findByHql(pHql, pStartRowNumber, pFectchSize, param);
	}

	@Override
	public List<Student> findByHql(String pHql, int pStartRowNumber, int pFectchSize, Map<String, Object> param)
			throws Exception {
		Query query = entityManager.createQuery(pHql);
		Set<String> keys = param.keySet();
		for (String key : keys) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		if (pStartRowNumber > 0 && pFectchSize > 0) {
			query.setFirstResult(pStartRowNumber);
			query.setMaxResults(pFectchSize);
		}
		return query.getResultList();
	}

	@Override
	public List<Student> findByNamedQuery(String pNameQuery, Class<?> clazz, Map<String, Object> param, int pStartRowNumber,
			int pFectchSize) throws Exception {
		TypedQuery<Student> query = (TypedQuery<Student>) entityManager.createNamedQuery(pNameQuery, clazz);
		Set<String> keys = param.keySet();
		for (String key : keys) {
			Object value = param.get(key);
			query.setParameter(key, value);
		}
		if (pStartRowNumber > 0 && pFectchSize > 0) {
			query.setFirstResult(pStartRowNumber);
			query.setMaxResults(pFectchSize);
		}
		return query.getResultList();
	}
}
