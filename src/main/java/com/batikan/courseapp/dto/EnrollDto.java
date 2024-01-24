package com.batikan.courseapp.dto;

public record EnrollDto(
        String id,

        EnrollStudentDto student,

        EnrollCourseDto course
) {


}
