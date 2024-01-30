package com.example.Etribe.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class CreateStudentDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastname;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private Boolean active;
}
