package com.batikan.courseapp.repository;

import com.batikan.courseapp.model.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepository extends JpaRepository<Enroll,String> {
}
