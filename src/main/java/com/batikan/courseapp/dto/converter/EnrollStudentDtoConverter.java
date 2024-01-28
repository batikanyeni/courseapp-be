package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.EnrollStudentDto;
import com.batikan.courseapp.model.Student;
import org.springframework.stereotype.Component;

@Component
public class EnrollStudentDtoConverter {
    //StudentDto to EnrollStudentDto

    public EnrollStudentDto convert(Student from){
        return new EnrollStudentDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getTelno()
        );
    }
}
