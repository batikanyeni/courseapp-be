package com.batikan.courseapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record UpdateCourseTeacherRequest(
        @NotBlank
        String teacher_id
) {
}
