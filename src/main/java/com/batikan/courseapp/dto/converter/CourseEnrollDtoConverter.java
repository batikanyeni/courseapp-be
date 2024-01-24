package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.CourseEnrollDto;
import com.batikan.courseapp.dto.EnrollDto;
import com.batikan.courseapp.model.Enroll;

public class CourseEnrollDtoConverter {
    //Enroll to CourseEnrollDto
    private final StudentDtoConverter studentDtoConverter;

    public CourseEnrollDtoConverter(StudentDtoConverter studentDtoConverter) {
        this.studentDtoConverter = studentDtoConverter;
    }

    public CourseEnrollDto convert(Enroll from){
        return new CourseEnrollDto(from.getId(),
                studentDtoConverter.convert(from.getStudent()));
    }
}
