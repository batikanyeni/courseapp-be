package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.EnrollCourseDto;
import com.batikan.courseapp.model.Course;
import org.springframework.stereotype.Component;

@Component
public class EnrollCourseDtoConverter {
    //Course to EnrollCourseDto

    private final CourseTeacherDtoConverter courseTeacherDtoConverter;

    public EnrollCourseDtoConverter(CourseTeacherDtoConverter courseTeacherDtoConverter) {
        this.courseTeacherDtoConverter = courseTeacherDtoConverter;
    }

    public EnrollCourseDto convert(Course from){
        return new EnrollCourseDto(
                from.getId(),
                from.getName(),
                from.getDate(),
                courseTeacherDtoConverter.convert(from.getTeacher())
        );
    }
}
