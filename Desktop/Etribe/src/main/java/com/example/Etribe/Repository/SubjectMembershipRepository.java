package com.example.Etribe.Repository;

import com.example.Etribe.model.Subject;
import com.example.Etribe.model.SubjectMembership;
import com.example.Etribe.model.SubjectMembershipKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMembershipRepository extends JpaRepository<SubjectMembership, SubjectMembershipKey> {
    //JPQL
    // de todas las rows de la tabla subject_membership obten las subjects donde el id del student concuerde con el studentid de la tabla
    @Query("SELECT i.subject FROM SubjectMembership i WHERE i.student.id = :studentId")
    List<Subject> findSubjectByStudent(long studentId);
}
