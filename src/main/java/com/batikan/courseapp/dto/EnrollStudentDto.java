package com.batikan.courseapp.dto;

public record EnrollStudentDto(
        String id,

        String name,

        String surname,

        String email,

        String password,

        String telno
) {
}
