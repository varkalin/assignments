package com.poseitech.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poseitech.assignment.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
