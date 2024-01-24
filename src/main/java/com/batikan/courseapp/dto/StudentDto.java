package com.batikan.courseapp.dto;

import java.util.List;

public record StudentDto(
         String id,

         String name,

         String surname,

         String email,

         String password,

         String telno,

         List<StudentEnrollDto> studentEnrollments
) {
}
