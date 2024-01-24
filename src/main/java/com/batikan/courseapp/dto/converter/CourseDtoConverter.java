package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.CourseDto;
import com.batikan.courseapp.model.Course;

import java.util.stream.Collectors;

public class CourseDtoConverter {
    //Course to CourseDto

    private final CourseTeacherDtoConverter courseTeacherDtoConverter;
    private final CourseEnrollDtoConverter courseEnrollDtoConverter;

    public CourseDtoConverter(CourseTeacherDtoConverter courseTeacherDtoConverter, CourseEnrollDtoConverter courseEnrollDtoConverter) {
        this.courseTeacherDtoConverter = courseTeacherDtoConverter;
        this.courseEnrollDtoConverter = courseEnrollDtoConverter;
    }

    public CourseDto convert(Course from){
        return new CourseDto(from.getId(),
                from.getName(),
                from.getDate(),
                courseTeacherDtoConverter.convert(from.getTeacher()),
                from.getEnrollList().stream().map(a -> courseEnrollDtoConverter.convert(a)).collect(Collectors.toList()));

    }
}
