package com.batikan.courseapp.dto;

import com.batikan.courseapp.model.Enroll;
import com.batikan.courseapp.model.Teacher;

import java.util.Date;
import java.util.List;

public record CourseDto(
        String id,

        String name,

        String weekday,

        CourseTeacherDto teacher,

        List<CourseEnrollDto> enrollList
) {
}
