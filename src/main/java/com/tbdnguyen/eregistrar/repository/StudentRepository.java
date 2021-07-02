package com.tbdnguyen.eregistrar.repository;

import com.tbdnguyen.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
