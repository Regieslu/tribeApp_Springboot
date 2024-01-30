package com.example.Etribe.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateStudentDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastname;
    @Email
    @NotBlank
    private String email;
    @NotNull
    private Boolean active;
}
