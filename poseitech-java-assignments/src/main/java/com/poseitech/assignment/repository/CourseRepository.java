package com.poseitech.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poseitech.assignment.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
