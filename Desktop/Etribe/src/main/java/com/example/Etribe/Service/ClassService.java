package com.example.Etribe.Service;
import com.example.Etribe.Repository.SubjectMembershipRepository;
import com.example.Etribe.dto.SubjectDTO;
import com.example.Etribe.mapper.ClassMapper;
import com.example.Etribe.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private SubjectMembershipRepository repository;

    @Autowired
    private ClassMapper mapper;

    @Autowired
    private SubjectMapper subjectMapper;

    public void addSubject(long studentID, long subjectID){
        repository.save(mapper.toModel(studentID, subjectID));
    }

    public List<SubjectDTO> findSubjectByStudent(long studentId) {
        return subjectMapper.toDTO(repository.findSubjectByStudent(studentId)).stream().filter(SubjectDTO::isActive).toList();
    }
}
