package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.StudentEnrollDto;
import com.batikan.courseapp.model.Enroll;

public class StudentEnrollDtoConverter {
    //Enroll to StudentEnrollDto
    private final CourseDtoConverter courseDtoConverter;

    public StudentEnrollDtoConverter(CourseDtoConverter courseDtoConverter) {
        this.courseDtoConverter = courseDtoConverter;
    }

    public StudentEnrollDto convert(Enroll from){
        return new StudentEnrollDto(from.getId(),
                courseDtoConverter.convert(from.getCourse()));
    }
}
