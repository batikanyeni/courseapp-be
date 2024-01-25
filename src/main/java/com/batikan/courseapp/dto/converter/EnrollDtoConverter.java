package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.EnrollDto;
import com.batikan.courseapp.model.Enroll;
import org.springframework.stereotype.Component;

@Component
public class EnrollDtoConverter {
    //Enroll to EnrollDto

    private final EnrollStudentDtoConverter enrollStudentDtoConverter;
    private final EnrollCourseDtoConverter enrollCourseDtoConverter;

    public EnrollDtoConverter(EnrollStudentDtoConverter enrollStudentDtoConverter, EnrollCourseDtoConverter enrollCourseDtoConverter) {
        this.enrollStudentDtoConverter = enrollStudentDtoConverter;
        this.enrollCourseDtoConverter = enrollCourseDtoConverter;
    }

    public EnrollDto convert(Enroll from){
        return new EnrollDto(
                from.getId(),
                enrollStudentDtoConverter.convert(from.getStudent()),
                enrollCourseDtoConverter.convert(from.getCourse())
        );
    }
}
