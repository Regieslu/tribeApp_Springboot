package com.example.Etribe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class SubjectMembershipKey {
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "subject_id")
    private long subjectId;
}
