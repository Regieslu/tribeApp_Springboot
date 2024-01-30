package com.example.Etribe.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private long id;
    private String firstName;
    private String lastname;
    private String email;
    private boolean active;
}
