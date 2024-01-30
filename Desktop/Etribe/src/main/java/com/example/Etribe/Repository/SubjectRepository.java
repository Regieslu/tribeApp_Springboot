package com.example.Etribe.Repository;

import com.example.Etribe.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository <Subject, Long> {
    @Query("SELECT s FROM Subject s WHERE s.active = true")
    List<Subject> listActiveSubjects();
    @Query("SELECT s FROM Subject s WHERE s.active = false")
    List<Subject> listDeactivatedSubjects();
}
