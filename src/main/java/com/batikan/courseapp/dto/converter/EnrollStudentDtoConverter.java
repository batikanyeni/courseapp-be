package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.EnrollStudentDto;
import com.batikan.courseapp.model.Student;

public class EnrollStudentDtoConverter {
    //Student to EnrollStudentDto

    public EnrollStudentDto convert(Student from){
        return new EnrollStudentDto(from.getId(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getPassword(),
                from.getTelno());
    }
}
