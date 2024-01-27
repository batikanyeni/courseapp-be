package com.batikan.courseapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateCourseRequest(

        @NotBlank
        String courseName,

        @NotBlank
        String weekday,

        @NotBlank
        String teacher_id


) {
}
