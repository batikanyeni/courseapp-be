package com.batikan.courseapp.dto;

import com.batikan.courseapp.model.Course;

import java.util.List;

public record TeacherDto(
        String id,

        String name,

        String Surname,

        String email,

        String telno,

        List<TeacherCourseDto> courses
) {
}
