package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.CourseDto;
import com.batikan.courseapp.model.Course;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
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
                from.getWeekday(),
                courseTeacherDtoConverter.convert(from.getTeacher()),
                from.getEnrollList().stream().map(courseEnrollDtoConverter::convert).collect(Collectors.toList()));
    }
}
