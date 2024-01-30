package com.example.Etribe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "code", length = 100, nullable = false)
    private int code;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Column(name = "active", nullable = false)
    private boolean active;
}
