package com.dailycode.jpa_buffer.repository;

import com.dailycode.jpa_buffer.entity.Course;
import com.dailycode.jpa_buffer.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    Course course = Course.builder()
            .title("Java")
            .credits(6)
            .build();

    @Test
    public void saveCourseMaterial() {
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com/java")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(">> " + courseMaterials);
    }
}