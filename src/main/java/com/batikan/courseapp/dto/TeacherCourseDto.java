package com.batikan.courseapp.dto;

import com.batikan.courseapp.model.Enroll;

import java.util.Date;
import java.util.List;

public record TeacherCourseDto(
        String id,

        String name,

        String weekday
) {
}
