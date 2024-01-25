package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.CourseDto;
import com.batikan.courseapp.model.Course;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CourseDtoConverter {
    //Course to CourseDto

    private final CourseTeacherDtoConverter courseTeacherDtoConverter;
    private final EnrollDtoConverter enrollDtoConverter;

    public CourseDtoConverter(CourseTeacherDtoConverter courseTeacherDtoConverter, EnrollDtoConverter enrollDtoConverter) {
        this.courseTeacherDtoConverter = courseTeacherDtoConverter;
        this.enrollDtoConverter = enrollDtoConverter;
    }

    public CourseDto convert(Course from){
        return new CourseDto(from.getId(),
                from.getName(),
                from.getDate(),
                courseTeacherDtoConverter.convert(from.getTeacher()),
                from.getEnrollList().stream().map(enrollDtoConverter::convert).collect(Collectors.toList()));
    }
}
