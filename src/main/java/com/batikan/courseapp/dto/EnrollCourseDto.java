package com.batikan.courseapp.dto;

import java.util.Date;

public record EnrollCourseDto(
        String id,

        String name,

        Date date,

        TeacherDto teacher
) {
}
