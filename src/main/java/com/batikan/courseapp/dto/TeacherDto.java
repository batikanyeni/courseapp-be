package com.batikan.courseapp.dto;

import java.util.List;

public record TeacherDto(
        String id,

        String name,

        String Surname,

        String email,

        String password,

        String telno,

        List<TeacherCourseDto> courses
) {
}
