package com.batikan.courseapp.dto.request;

import org.springframework.validation.annotation.Validated;

@Validated
public record UpdateCourseRequest(

        String name,

        String weekday
) {
}
