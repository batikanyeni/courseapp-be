package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.CourseEnrollDto;
import com.batikan.courseapp.dto.EnrollStudentDto;
import com.batikan.courseapp.model.Enroll;
import org.springframework.stereotype.Component;

@Component
public class CourseEnrollDtoConverter {
    //Enroll to CourseEnrollDto
    private final EnrollStudentDtoConverter enrollStudentDtoConverter;

    public CourseEnrollDtoConverter(EnrollStudentDtoConverter enrollStudentDtoConverter) {
        this.enrollStudentDtoConverter = enrollStudentDtoConverter;
    }

    public CourseEnrollDto convert(Enroll from){
        return new CourseEnrollDto(
                from.getId(),
                enrollStudentDtoConverter.convert(from.getStudent()));
    }
}
