package com.example.Etribe.Service;

import com.example.Etribe.Repository.SubjectRepository;
import com.example.Etribe.dto.CreateSubjectDTO;
import com.example.Etribe.dto.SubjectDTO;
import com.example.Etribe.dto.UpdateSubjectDTO;
import com.example.Etribe.exception.SubjectNotFoundException;
import com.example.Etribe.mapper.SubjectMapper;
import com.example.Etribe.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository repository;
    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    public List<SubjectDTO> findAll(){
        return subjectMapper.toDTO(repository.listActiveSubjects());
    }
    public List<SubjectDTO> findAllDeactivatedSubjects() {
        return subjectMapper.toDTO(repository.listDeactivatedSubjects());
    }
    public SubjectDTO save(CreateSubjectDTO data){
        Subject entity = repository.save(subjectMapper.toModel(data));
        return subjectMapper.toDTO(entity);
    }
    public void update(long subjectId, UpdateSubjectDTO data){
        Optional<Subject> result= repository.findById(subjectId);
        if (result.isEmpty()){
            throw new SubjectNotFoundException();
        }

        Subject subject = result.get();
        subjectMapper.update(subject, data);
        repository.save(subject);
    }
    public void deactivate(long subjectId, UpdateSubjectDTO data){
        Optional<Subject> result= repository.findById(subjectId);
        if (result.isEmpty()){
            throw new SubjectNotFoundException();
        }
        Subject subject = result.get();
        subject.setActive(data.getActive());
        repository.save(subject);
    }
    public void activate(long subjectId, UpdateSubjectDTO data){
        Optional<Subject> result= repository.findById(subjectId);
        if (result.isEmpty()){
            throw new SubjectNotFoundException();
        }
        Subject subject = result.get();
        subject.setActive(data.getActive());
        repository.save(subject);
    }

    public SubjectDTO getSubjectById(long subjectId) {
        Optional<Subject> result= repository.findById(subjectId);
        if (result.isEmpty()){
            throw new SubjectNotFoundException();
        }
        Subject subject = result.get();
        return subjectMapper.toDTO(subject);
    }
}
