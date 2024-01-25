package com.batikan.courseapp.dto;

import com.batikan.courseapp.model.Course;
import com.batikan.courseapp.model.Student;

public record EnrollDto(
        String id,

        EnrollStudentDto student,

        EnrollCourseDto course
) {
}
