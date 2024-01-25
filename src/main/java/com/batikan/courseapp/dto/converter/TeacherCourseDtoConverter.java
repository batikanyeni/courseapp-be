package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.TeacherCourseDto;
import com.batikan.courseapp.model.Course;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeacherCourseDtoConverter {
    //Course to TeacherCourseDto

    private final EnrollDtoConverter enrollDtoConverter;

    public TeacherCourseDtoConverter(EnrollDtoConverter enrollDtoConverter) {
        this.enrollDtoConverter = enrollDtoConverter;
    }

    public TeacherCourseDto convert(Course from){
        return new TeacherCourseDto(
                from.getId(),
                from.getName(),
                from.getDate(),
                from.getEnrollList().stream().map(enrollDtoConverter::convert).collect(Collectors.toList()));
    }
}
