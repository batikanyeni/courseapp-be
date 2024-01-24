package com.batikan.courseapp.repository;

import com.batikan.courseapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}
