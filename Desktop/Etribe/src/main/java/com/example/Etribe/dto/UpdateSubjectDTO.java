package com.example.Etribe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
public class UpdateSubjectDTO {
    @NumberFormat
    private long code;
    @NotBlank
    private String name;
    @NotNull
    private Boolean active;
}
