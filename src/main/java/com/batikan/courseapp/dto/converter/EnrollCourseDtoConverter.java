package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.EnrollCourseDto;
import com.batikan.courseapp.model.Course;

public class EnrollCourseDtoConverter {
    //Course to EnrollCourseDto
    private final TeacherDtoConverter teacherDtoConverter;

    public EnrollCourseDtoConverter(TeacherDtoConverter teacherDtoConverter) {
        this.teacherDtoConverter = teacherDtoConverter;
    }

    public EnrollCourseDto convert(Course from){
        return new EnrollCourseDto(from.getId(),
                from.getName(),
                from.getDate(),
                teacherDtoConverter.convert(from.getTeacher()));
    }
}
