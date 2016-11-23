package com.poseitech.assignment.service;

import java.util.List;
import java.util.Optional;

import com.poseitech.assignment.common.GradeStats;
import com.poseitech.assignment.dto.ProjectDto;
import com.poseitech.assignment.dto.StudentDto;
import com.poseitech.assignment.entity.Student;

public interface AssignmentService {
   
   // 新增一個學生至系統
   public Optional<Student> createStudent(StudentDto pNewStudent) throws Exception;
   
   public Optional<Student> getStudentById(Integer pStudentId) throws Exception;

   // 以分頁方式調閱所有系統中所有學生
   // pStartRowNumber: 從第幾筆開始
   // pLimit: 此次讀取筆數
   public List<Student> getAllStudents(int pStartRowNumber, int pLimit) throws Exception;
   
   public List<Student> getAllStudents(StudentDto studentDto, int pStartRowNumber, int pLimit) throws Exception;
   
   // 自系統刪除指定的學生
   public void deleteStudent(StudentDto pNewStudent) throws Exception;
   
   public List<GradeStats> getStudentGradeStats() throws Exception;
   
   // 查詢指定的學生感興趣的所有專案
   // pStudent: 依指定的條件查詢
   @Deprecated
   public List<ProjectDto> getInterestedProjects(StudentDto pStudent) throws Exception;
   
   // 將學生指定感興趣的專案註冊到系統
   @Deprecated
   public StudentDto registerProjects(Integer pStudendId, List<ProjectDto> pProjects) throws Exception;
   
   // 將專案資料新增至系統
   @Deprecated
   public List<ProjectDto> createProjects(List<ProjectDto> pProjects) throws Exception;

   // 將專案資料自系統刪除，同時將這些專案自有感興趣的學生列表中移除。
   @Deprecated
   public boolean deleteProjects(List<ProjectDto> pProjects) throws Exception;
}
