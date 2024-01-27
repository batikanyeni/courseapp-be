package com.batikan.courseapp.dto;

import com.batikan.courseapp.model.Teacher;

import java.util.Date;

public record EnrollCourseDto(
        String id,

        String name,

        String weekday,

        CourseTeacherDto teacher


) {
}
