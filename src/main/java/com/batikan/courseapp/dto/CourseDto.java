package com.batikan.courseapp.dto;

import java.util.Date;
import java.util.List;

public record CourseDto(
        String id,

        String name,

        Date date,

        CourseTeacherDto teacher,

        List<CourseEnrollDto> courseEnrollments




) {
}
