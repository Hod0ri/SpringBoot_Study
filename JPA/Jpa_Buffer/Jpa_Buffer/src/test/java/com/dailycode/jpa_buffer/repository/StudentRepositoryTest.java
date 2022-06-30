package com.dailycode.jpa_buffer.repository;


import com.dailycode.jpa_buffer.entity.Guardian;
import com.dailycode.jpa_buffer.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
//                .guardianName("Nikhil")
//                .guardianEmail("Nikhil@gmail.com")
//                .guardianPhone("0123456789")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Nikhil")
                .email("Nikhil@gmail.com")
                .phone("0123456789")
                .build();

        Student student = Student.builder()
                .emailId("shivam@gmail.com")
                .firstName("Shivam")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void findByFirstNameContaining() {
        List<Student> studentList =
                studentRepository.findByFirstName("Sh");

        System.out.println(studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> studentList =
                studentRepository.findByGuardianName("Nikhil");

        System.out.println(studentList);
    }

    @Test
    public void printgetStudentByEmailAddress() {
        Student student = studentRepository
                .getStudentByEmailAddress("shabbir@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNative() {
        Student student = studentRepository
                .getStudentByEmailAddressNative("shabbir@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository
                .getStudentByEmailAddressNativeNamedParam("shabbir@gmail.com");
        System.out.println(student);
    }


}