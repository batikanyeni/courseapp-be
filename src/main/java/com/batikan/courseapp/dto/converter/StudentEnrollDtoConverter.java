package com.batikan.courseapp.dto.converter;


import com.batikan.courseapp.dto.StudentEnrollDto;
import com.batikan.courseapp.model.Enroll;
import org.springframework.stereotype.Component;

@Component
public class StudentEnrollDtoConverter {
    //Enroll to StudentEnrollDto

    private final EnrollCourseDtoConverter enrollCourseDtoConverter;

    public StudentEnrollDtoConverter(EnrollCourseDtoConverter enrollCourseDtoConverter) {
        this.enrollCourseDtoConverter = enrollCourseDtoConverter;
    }

    public StudentEnrollDto convert(Enroll from){
        return new StudentEnrollDto(
                from.getId(),
                enrollCourseDtoConverter.convert(from.getCourse()));
    }
}
