package com.batikan.courseapp.repository;

import com.batikan.courseapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
