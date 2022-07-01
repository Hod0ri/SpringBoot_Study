package com.dailycode.jpa_buffer.repository;

import com.dailycode.jpa_buffer.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {


}
