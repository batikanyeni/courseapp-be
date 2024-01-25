package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.CourseDto;
import com.batikan.courseapp.model.Course;

import java.util.stream.Collectors;

public class CourseDtoConverter {
    //Course to CourseDto
    private final EnrollDtoConverter enrollDtoConverter;

    public CourseDtoConverter(EnrollDtoConverter enrollDtoConverter) {
        this.enrollDtoConverter = enrollDtoConverter;
    }

    public CourseDto convert(Course from){
        return new CourseDto(from.getId(),
                from.getName(),
                from.getDate(),
                from.getTeacher(),
                from.getEnrollList().stream().map(t -> enrollDtoConverter.convert(t)).collect(Collectors.toList()));
    }
}
