package com.tbdnguyen.eregistrar.service.impl;

import com.tbdnguyen.eregistrar.model.Student;
import com.tbdnguyen.eregistrar.repository.StudentRepository;
import com.tbdnguyen.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("firstName"));
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getById(studentId);
    }

    @Override
    public List<Student> findStudentsByStudentNumber(String studentNumber) {
        return studentRepository.findByStudentNumberLike(studentNumber);
    }
}
