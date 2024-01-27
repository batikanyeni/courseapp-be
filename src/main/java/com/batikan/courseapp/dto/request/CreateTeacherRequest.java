package com.batikan.courseapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateTeacherRequest(
        @NotBlank
        String name,
        @NotBlank
        String Surname,
        @NotBlank
        String email,
        @NotBlank
        String password,

        String telno
) {

}
