package com.batikan.courseapp.dto.request;

public record UpdateTeacherRequest(
        String name,

        String Surname,

        String email,

        String password,

        String telno
) {
}
