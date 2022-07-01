package com.dailycode.jpa_buffer.repository;

import com.dailycode.jpa_buffer.entity.Course;
import com.dailycode.jpa_buffer.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    Course courseCS = Course.builder()
            .title("Computer Science")
            .credits(3)
            .build();

    Course courseAN = Course.builder()
            .title("Android")
            .credits(6)
            .build();

//    @Test
//    public void saveTeacher() {
//        Teacher teacher = Teacher.builder()
//                .firstName("John")
//                .lastName("Doe")
//                .courses(List.of(courseAN, courseCS))
//                .build();
//
//        teacherRepository.save(teacher);
//    }

}