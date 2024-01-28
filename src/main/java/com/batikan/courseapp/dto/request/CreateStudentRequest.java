package com.batikan.courseapp.dto.request;


import org.springframework.validation.annotation.Validated;

@Validated
public record CreateStudentRequest(
        String name,

        String surname,

        String email,

        String password,

        String telno
) {
}
