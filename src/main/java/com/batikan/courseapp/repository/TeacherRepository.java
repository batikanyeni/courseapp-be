package com.batikan.courseapp.repository;

import com.batikan.courseapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,String> {
}
