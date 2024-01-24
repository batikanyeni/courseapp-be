package com.batikan.courseapp.dto;

import java.util.Date;
import java.util.List;

public record TeacherCourseDto(
        String id,

        String name,

        Date date,

        List<EnrollDto> courseEnrollments
) {
}
