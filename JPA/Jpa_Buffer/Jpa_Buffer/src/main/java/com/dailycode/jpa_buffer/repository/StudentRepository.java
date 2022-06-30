package com.dailycode.jpa_buffer.repository;

import com.dailycode.jpa_buffer.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    // JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String EmailId);

    @Query(
            value = "select * from tbl_student where email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String EmailId);

    @Query(
            value = "select * from tbl_student where email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String EmailId);

}

