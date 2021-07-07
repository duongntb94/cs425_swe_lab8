package com.tbdnguyen.eregistrar.service;

import com.tbdnguyen.eregistrar.model.Student;

import java.util.*;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    void deleteStudent(Long studentId);
    Student getStudentById(Long studentId);
    List<Student> findStudents(String keyword);
}
