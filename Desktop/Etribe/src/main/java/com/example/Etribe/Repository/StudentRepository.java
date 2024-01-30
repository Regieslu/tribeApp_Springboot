package com.example.Etribe.Repository;

import com.example.Etribe.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.active = true")
    List<Student> listActiveStudents();

    @Query("SELECT s FROM Student s WHERE s.active = false")
    List<Student> listDeactivatedStudents();
}
