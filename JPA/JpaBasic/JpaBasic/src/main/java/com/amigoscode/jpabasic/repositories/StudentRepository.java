package com.amigoscode.jpabasic.repositories;

import com.amigoscode.jpabasic.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
