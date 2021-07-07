package com.tbdnguyen.eregistrar.repository;

import com.tbdnguyen.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrderByFirstName(String studentNumber, String firstName, String middleName, String lastName);

}
