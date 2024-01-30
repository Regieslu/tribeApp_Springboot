package com.example.Etribe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "subject_membership")
public class SubjectMembership {
    @EmbeddedId
    private SubjectMembershipKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name="subject_id")
    private Subject subject;
}
